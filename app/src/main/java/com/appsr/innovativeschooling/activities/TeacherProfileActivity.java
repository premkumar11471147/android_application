package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;

import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.activities.editfunctions.AddEditTeacherProfileActivity;
import com.appsr.innovativeschooling.adapters.TeacherProfileAdapter;
import com.appsr.innovativeschooling.models.TeacherProfile;
import com.appsr.innovativeschooling.viewmodels.TeacherProfileViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TeacherProfileActivity extends AppCompatActivity implements TeacherProfileAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private TeacherProfileAdapter adapter;
    private TeacherProfileViewModel viewModel;
    private FloatingActionButton fabAddTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        recyclerView = findViewById(R.id.recyclerViewTeachers);
        fabAddTeacher = findViewById(R.id.fabAddTeacher);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeacherProfileAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(TeacherProfileViewModel.class);

        viewModel.getTeachers().observe(this, new Observer<List<TeacherProfile>>() {
            @Override
            public void onChanged(List<TeacherProfile> teacherProfiles) {
                adapter.setTeacherList(teacherProfiles);
            }
        });

        fabAddTeacher.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherProfileActivity.this, AddEditTeacherProfileActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onEditClick(TeacherProfile teacher) {
        Intent intent = new Intent(this, AddEditTeacherProfileActivity.class);
        intent.putExtra("teacher_id", teacher.getTeacher_id());
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(TeacherProfile teacher) {
        viewModel.deleteTeacher(teacher);
        Toast.makeText(this, "Teacher Profile Deleted", Toast.LENGTH_SHORT).show();
    }
}
