package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;


import android.content.Intent;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.activities.editfunctions.AddEditTeacherAttendanceActivity;
import com.appsr.innovativeschooling.adapters.TeacherAttendanceAdapter;
import com.appsr.innovativeschooling.models.TeacherAttendance;
import com.appsr.innovativeschooling.viewmodels.TeacherAttendanceViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class TeacherAttendanceActivity extends AppCompatActivity implements TeacherAttendanceAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private TeacherAttendanceAdapter adapter;
    private TeacherAttendanceViewModel viewModel;
    private FloatingActionButton fabAddAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_attendance);

        recyclerView = findViewById(R.id.recyclerViewTeacherAttendance);
        fabAddAttendance = findViewById(R.id.fabAddTeacherAttendance);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeacherAttendanceAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(TeacherAttendanceViewModel.class);
        viewModel.getAttendance().observe(this, this::updateUI);

        fabAddAttendance.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherAttendanceActivity.this, AddEditTeacherAttendanceActivity.class);
            startActivity(intent);
        });
    }

    private void updateUI(List<TeacherAttendance> attendanceList) {
        adapter.setTeacherAttendanceList(attendanceList);
    }

    @Override
    public void onEditClick(TeacherAttendance attendance) {
        Intent intent = new Intent(this, AddEditTeacherAttendanceActivity.class);
        intent.putExtra("attendance_id", attendance.getAttendance_id());
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(TeacherAttendance attendance) {
        viewModel.deleteAttendance(attendance);
        Toast.makeText(this, "Attendance deleted", Toast.LENGTH_SHORT).show();
    }
}
