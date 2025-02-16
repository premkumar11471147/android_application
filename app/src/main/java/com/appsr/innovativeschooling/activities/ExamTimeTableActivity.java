package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;


import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.adapters.ExamTimeTableAdapter;
import com.appsr.innovativeschooling.models.ExamTimeTable;
import com.appsr.innovativeschooling.viewmodels.ExamTimeTableViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class ExamTimeTableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExamTimeTableAdapter adapter;
    private ExamTimeTableViewModel viewModel;
    private FloatingActionButton fabAddExam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_time_table);

        recyclerView = findViewById(R.id.recyclerViewExam);
        fabAddExam = findViewById(R.id.fabAddExam);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExamTimeTableAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ExamTimeTableViewModel.class);
        viewModel.getAllExamTimeTables().observe(this, new Observer<List<ExamTimeTable>>() {
            @Override
            public void onChanged(List<ExamTimeTable> examTimeTables) {
                adapter.setExamList(examTimeTables);
            }
        });

        fabAddExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamTimeTableActivity.this, AddEditExamActivity.class));
            }
        });
    }

    public void deleteExam(ExamTimeTable exam) {
        viewModel.deleteExamTimeTable(exam);
        Toast.makeText(this, "Exam Deleted", Toast.LENGTH_SHORT).show();
    }
}
