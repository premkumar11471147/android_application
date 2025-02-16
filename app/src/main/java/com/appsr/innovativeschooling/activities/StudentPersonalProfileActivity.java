package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.activities.editfunctions.AddEditStudentPersonalProfileActivity;
import com.appsr.innovativeschooling.adapters.StudentPersonalProfileAdapter;
import com.appsr.innovativeschooling.models.StudentPersonalProfile;
import com.appsr.innovativeschooling.viewmodels.StudentPersonalProfileViewModel;


import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class StudentPersonalProfileActivity extends AppCompatActivity implements StudentPersonalProfileAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private StudentPersonalProfileAdapter adapter;
    private StudentPersonalProfileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_personal_profile);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentPersonalProfileAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(StudentPersonalProfileViewModel.class);
        viewModel.getStudentPersonalProfiles().observe(this, new Observer<List<StudentPersonalProfile>>() {
            @Override
            public void onChanged(List<StudentPersonalProfile> studentPersonalProfiles) {
                adapter.setStudentPersonalProfiles(studentPersonalProfiles);
            }
        });

        findViewById(R.id.btnAddStudentPersonalProfile).setOnClickListener(v -> {
            startActivity(new Intent(StudentPersonalProfileActivity.this, AddEditStudentPersonalProfileActivity.class));
        });
    }

    @Override
    public void onEditClick(StudentPersonalProfile studentPersonalProfile) {
        Intent intent = new Intent(this, AddEditStudentPersonalProfileActivity.class);
        intent.putExtra("student_id", studentPersonalProfile.getStudentId());
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(StudentPersonalProfile studentPersonalProfile) {
        viewModel.deleteStudentPersonalProfile(studentPersonalProfile);
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
}
