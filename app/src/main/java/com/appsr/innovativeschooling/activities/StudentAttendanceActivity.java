package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;

import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.adapters.StudentAttendanceAdapter;
import com.appsr.innovativeschooling.models.StudentAttendance;
import com.appsr.innovativeschooling.viewmodels.StudentAttendanceViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class StudentAttendanceActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAttendanceAdapter adapter;
    private StudentAttendanceViewModel viewModel;
    private FloatingActionButton fabAddAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);

        recyclerView = findViewById(R.id.recyclerViewAttendance);
        fabAddAttendance = findViewById(R.id.fabAddAttendance);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentAttendanceAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(StudentAttendanceViewModel.class);
        viewModel.getAttendance().observe(this, new Observer<List<StudentAttendance>>() {
            @Override
            public void onChanged(List<StudentAttendance> attendances) {
                adapter.setAttendanceList(attendances);
            }
        });

        fabAddAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StudentAttendanceActivity.this, "Add Attendance Clicked", Toast.LENGTH_SHORT).show();
                // Implement add attendance logic
            }
        });
    }
}
