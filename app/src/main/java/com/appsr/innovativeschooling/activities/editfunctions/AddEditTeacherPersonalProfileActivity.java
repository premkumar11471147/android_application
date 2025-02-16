package com.appsr.innovativeschooling.activities.editfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.TeacherPersonalProfile;
import com.appsr.innovativeschooling.viewmodels.TeacherPersonalProfileViewModel;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddEditTeacherPersonalProfileActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etPhoneNumber;
    private Button btnSave;
    private TeacherPersonalProfileViewModel viewModel;
    private int teacherId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_teacher_personal_profile);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSave = findViewById(R.id.btnSave);

        viewModel = new ViewModelProvider(this).get(TeacherPersonalProfileViewModel.class);

        if (getIntent().hasExtra("teacher_id")) {
            teacherId = getIntent().getIntExtra("teacher_id", -1);
            loadTeacherData(teacherId);
        }

        btnSave.setOnClickListener(v -> saveTeacherProfile());
    }

    private void loadTeacherData(int teacherId) {
        viewModel.getTeacherByID(teacherId).observe(this, teacherPersonalProfile -> {
            if (teacherPersonalProfile != null) {
                etFirstName.setText(teacherPersonalProfile.getMother_name());
                etLastName.setText(teacherPersonalProfile.getFather_name());
                etPhoneNumber.setText(teacherPersonalProfile.getPhone_number());
            }
        });
    }

    private void saveTeacherProfile() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(phoneNumber)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        TeacherPersonalProfile teacherPersonalProfile = new TeacherPersonalProfile(/*teacherId, firstName, lastName, phoneNumber*/);
        //TODO we need to feed the data

        if (teacherId == -1) {
            viewModel.insertProfile(teacherPersonalProfile);
            Toast.makeText(this, "Teacher Personal Profile Added", Toast.LENGTH_SHORT).show();
        } else {
            teacherPersonalProfile.setTeacherId(teacherId);
            viewModel.updateProfile(teacherPersonalProfile);
            Toast.makeText(this, "Teacher Personal Profile Updated", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}
