package com.appsr.innovativeschooling.activities.editfunctions;

import android.os.Bundle;

import com.appsr.innovativeschooling.models.StudentProfile;
import com.appsr.innovativeschooling.viewmodels.StudentProfileViewModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.appsr.innovativeschooling.databinding.ActivityAddEditStudentBinding;

import com.appsr.innovativeschooling.R;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


public class AddEditStudentActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etRollNumber, etClassId, etSchoolId;
    private Button btnSave;
    private StudentProfileViewModel studentViewModel;
    private StudentProfile existingStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_student);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etRollNumber = findViewById(R.id.etRollNumber);
        etClassId = findViewById(R.id.etClassId);
        etSchoolId = findViewById(R.id.etSchoolId);
        btnSave = findViewById(R.id.btnSave);



    }

    @Override
    protected void onResume () {
        super.onResume();
        studentViewModel = new ViewModelProvider(this).get(StudentProfileViewModel.class);
        studentViewModel.init(getApplicationContext());

        // Check if editing an existing student
        if (getIntent().hasExtra("student_id")) {
            int studentId = getIntent().getIntExtra("student_id", -1);
            studentViewModel.fetchStudentById(studentId).observe(this, student -> {
                if (student != null) {
                    existingStudent = student;
                    etFirstName.setText(student.getFirstName());
                    etLastName.setText(student.getLastName());
                    etRollNumber.setText(String.valueOf(student.getRollNumber()));
                    etClassId.setText(String.valueOf(student.getClassId()));
                    etSchoolId.setText(String.valueOf(student.getSchoolId()));
                }
            });
        }

        btnSave.setOnClickListener(view -> saveStudent());
    }

    private void saveStudent() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String rollNumber = etRollNumber.getText().toString().trim();
        String classId = etClassId.getText().toString().trim();
        String schoolId = etSchoolId.getText().toString().trim();

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) ||
                TextUtils.isEmpty(rollNumber) || TextUtils.isEmpty(classId) || TextUtils.isEmpty(schoolId)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        int roll = Integer.parseInt(rollNumber);
        int classID = Integer.parseInt(classId);
        int schoolID = Integer.parseInt(schoolId);

        if (existingStudent == null) {
            // Insert new student
            StudentProfile newStudent = new StudentProfile();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setRollNumber(Integer.parseInt(rollNumber));
            newStudent.setClassId(classID);
            newStudent.setSchoolId(schoolID);
            studentViewModel.addStudent(newStudent);
        } else {
            // Update existing student
            existingStudent.setFirstName(firstName);
            existingStudent.setLastName(lastName);
            existingStudent.setRollNumber(roll);
            existingStudent.setClassId(classID);
            existingStudent.setSchoolId(schoolID);
            studentViewModel.updateStudent(existingStudent);
        }

        Toast.makeText(this, "Student saved successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
