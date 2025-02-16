package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;


import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.activities.editfunctions.AddEditTeacherPersonalProfileActivity;
import com.appsr.innovativeschooling.adapters.TeacherPersonalProfileAdapter;
import com.appsr.innovativeschooling.models.TeacherPersonalProfile;
import com.appsr.innovativeschooling.viewmodels.TeacherPersonalProfileViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class TeacherPersonalProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeacherPersonalProfileAdapter adapter;
    private TeacherPersonalProfileViewModel viewModel;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_personal_profile);

        recyclerView = findViewById(R.id.recyclerView);
        fabAdd = findViewById(R.id.fabAdd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TeacherPersonalProfileAdapter(this, new TeacherPersonalProfileAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(TeacherPersonalProfile profile) {
                Intent intent = new Intent(TeacherPersonalProfileActivity.this, AddEditTeacherPersonalProfileActivity.class);
                intent.putExtra("teacher_id", profile.getTeacherId());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(TeacherPersonalProfile profile) {
                viewModel.deleteProfile(profile);
                Toast.makeText(TeacherPersonalProfileActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(TeacherPersonalProfileViewModel.class);

        viewModel.getAllProfiles().observe(this, teacherPersonalProfiles -> {
            adapter.setTeacherPersonalProfiles(teacherPersonalProfiles);
        });

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(TeacherPersonalProfileActivity.this, AddEditTeacherPersonalProfileActivity.class));
        });
    }
}
