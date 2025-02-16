package com.appsr.innovativeschooling.activities.editfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.TeacherProfile;
import com.appsr.innovativeschooling.viewmodels.TeacherProfileViewModel;


import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;


public class AddEditTeacherProfileActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etTeacherId, etClassId, etSchoolId;
    private Button btnSave;
    private TeacherProfileViewModel viewModel;
    private int teacherId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_teacher_profile);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etTeacherId = findViewById(R.id.etTeacherId);
        etClassId = findViewById(R.id.etClassId);
        etSchoolId = findViewById(R.id.etSchoolId);
        btnSave = findViewById(R.id.btnSave);

        viewModel = new ViewModelProvider(this).get(TeacherProfileViewModel.class);

        if (getIntent().hasExtra("teacher_id")) {
            teacherId = getIntent().getIntExtra("teacher_id", -1);
            loadTeacherData(teacherId);
        }

        btnSave.setOnClickListener(v -> saveTeacherProfile());
    }

    private void loadTeacherData(int teacherId) {
        viewModel.getTeacherById(teacherId).observe(this, teacherProfile -> {
            if (teacherProfile != null) {
                etFirstName.setText(teacherProfile.getTeacher_id());
                etLastName.setText(teacherProfile.getLastName());
                etTeacherId.setText(String.valueOf(teacherProfile.getTeacher_id()));
                etClassId.setText(String.valueOf(teacherProfile.getClassId()));
                etSchoolId.setText(String.valueOf(teacherProfile.getSchoolId()));
            }
        });
    }

    private void saveTeacherProfile() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String teacherIdStr = etTeacherId.getText().toString().trim();
        String classIdStr = etClassId.getText().toString().trim();
        String schoolIdStr = etSchoolId.getText().toString().trim();

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) ||
                TextUtils.isEmpty(teacherIdStr) || TextUtils.isEmpty(classIdStr) || TextUtils.isEmpty(schoolIdStr)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int teacherId = Integer.parseInt(teacherIdStr);
        int classId = Integer.parseInt(classIdStr);
        int schoolId = Integer.parseInt(schoolIdStr);

        TeacherProfile teacherProfile = new TeacherProfile(/*teacherId, firstName, lastName, classId, schoolId*/);
        //TODO we need to feed the data

        if (this.teacherId == -1) {
            viewModel.insertTeacher(teacherProfile);
            Toast.makeText(this, "Teacher Added", Toast.LENGTH_SHORT).show();
        } else {
            teacherProfile.setTeacher_id(this.teacherId);
            viewModel.updateTeacher(teacherProfile);
            Toast.makeText(this, "Teacher Updated", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}
