package com.appsr.innovativeschooling.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.activities.editfunctions.AddEditStudentActivity;
import com.appsr.innovativeschooling.adapters.StudentProfileAdapter;
import com.appsr.innovativeschooling.models.StudentProfile;
import com.appsr.innovativeschooling.viewmodels.StudentProfileViewModel;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class StudentProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentProfileAdapter adapter;
    private StudentProfileViewModel viewModel;
    private FloatingActionButton fabAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddStudent = findViewById(R.id.fabAddStudent);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(StudentProfileViewModel.class);
        adapter = new StudentProfileAdapter(new StudentProfileAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(StudentProfile student) {
                Intent intent = new Intent(StudentProfileActivity.this, AddEditStudentActivity.class);
                intent.putExtra("student_id", student.getStudent_id());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(StudentProfile student) {
                viewModel.deleteStudent(student);
                Toast.makeText(StudentProfileActivity.this, "Student Deleted", Toast.LENGTH_SHORT).show();
            }
        },new ArrayList<StudentProfile>());

        recyclerView.setAdapter(adapter);

        viewModel.getStudents().observe(this, new Observer<List<StudentProfile>>() {
            @Override
            public void onChanged(List<StudentProfile> students) {
                adapter.updateList(students);
            }
        });

        fabAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentProfileActivity.this, AddEditStudentActivity.class));
            }
        });
    }
}

