package com.appsr.innovativeschooling.activities.editfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.StudentPersonalProfile;
import com.appsr.innovativeschooling.viewmodels.StudentPersonalProfileViewModel;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddEditStudentPersonalProfileActivity extends AppCompatActivity {

    private EditText etPhoto, etDOB, etGender, etFatherName, etMotherName, etPhone, etAltPhone, etEmail, etAddress;
    private Button btnSave;

    private StudentPersonalProfileViewModel viewModel;
    private int studentId = -1; // Default for new entry

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_student_personal_profile);

        etPhoto = findViewById(R.id.etPhoto);
        etDOB = findViewById(R.id.etDOB);
        etGender = findViewById(R.id.etGender);
        etFatherName = findViewById(R.id.etFatherName);
        etMotherName = findViewById(R.id.etMotherName);
        etPhone = findViewById(R.id.etPhone);
        etAltPhone = findViewById(R.id.etAltPhone);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        btnSave = findViewById(R.id.btnSave);

        viewModel = new ViewModelProvider(this).get(StudentPersonalProfileViewModel.class);

        if (getIntent().hasExtra("student_id")) {
            studentId = getIntent().getIntExtra("student_id", -1);
            loadStudentPersonalProfile(studentId);
        }

        btnSave.setOnClickListener(v -> saveStudentPersonalProfile());
    }

    private void loadStudentPersonalProfile(int studentId) {
        viewModel.getProfileByID(studentId).observe(this, studentPersonalProfile -> {
            if (studentPersonalProfile != null) {
                etPhoto.setText(studentPersonalProfile.getPhoto());
                etDOB.setText(studentPersonalProfile.getDate_of_birth());
                etGender.setText(studentPersonalProfile.getGender());
                etFatherName.setText(studentPersonalProfile.getFather_name());
                etMotherName.setText(studentPersonalProfile.getMother_name());
                etPhone.setText(studentPersonalProfile.getPhone_number());
                etAltPhone.setText(studentPersonalProfile.getAlternate_number());
                etEmail.setText(studentPersonalProfile.getEmail_id());
                etAddress.setText(studentPersonalProfile.getAddress());
            }
        });
    }

    private void saveStudentPersonalProfile() {
        String photo = etPhoto.getText().toString().trim();
        String dob = etDOB.getText().toString().trim();
        String gender = etGender.getText().toString().trim();
        String fatherName = etFatherName.getText().toString().trim();
        String motherName = etMotherName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String altPhone = etAltPhone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        if (TextUtils.isEmpty(fatherName) || TextUtils.isEmpty(motherName) || TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Father Name, Mother Name, and Phone are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        StudentPersonalProfile profile = new StudentPersonalProfile(/*studentId, photo, dob, gender, fatherName, motherName, phone, altPhone, email, address*/);
        //TODO we need to feed the data

        if (studentId == -1) {
            viewModel.insertStudentPersonalProfile(profile);
            Toast.makeText(this, "Student Personal Profile Added", Toast.LENGTH_SHORT).show();
        } else {
            viewModel.updateStudentPersonalProfile(profile);
            Toast.makeText(this, "Student Personal Profile Updated", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}
