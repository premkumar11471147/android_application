package com.appsr.innovativeschooling.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.ExamTimeTable;
import com.appsr.innovativeschooling.viewmodels.ExamTimeTableViewModel;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddEditExamActivity extends AppCompatActivity {

    private EditText examNameEditText, dateEditText, timeEditText, syllabusEditText;
    private Spinner classSpinner, subjectSpinner;
    private Button saveButton;
    private ExamTimeTableViewModel examViewModel;
    private boolean isEdit = false;
    private int examId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_exam);

        examNameEditText = findViewById(R.id.exam_name);
        dateEditText = findViewById(R.id.exam_date);
        timeEditText = findViewById(R.id.exam_time);
        syllabusEditText = findViewById(R.id.exam_syllabus);
        classSpinner = findViewById(R.id.class_spinner);
        subjectSpinner = findViewById(R.id.subject_spinner);
        saveButton = findViewById(R.id.save_button);

        examViewModel = new ViewModelProvider(this).get(ExamTimeTableViewModel.class);

        // Check if the activity was opened for editing
        if (getIntent().hasExtra("EXAM_ID")) {
            isEdit = true;
            examId = getIntent().getIntExtra("EXAM_ID", -1);
            loadExamData(examId);
        }

        saveButton.setOnClickListener(v -> saveExamData());
    }

    private void loadExamData(int examId) {
        // Load the exam details from the ViewModel (assuming data exists in the ViewModel)
        examViewModel.getExamTimeTableByClassID(examId).observe(this, exams -> {
            if (exams != null) {
                ExamTimeTable timetable = exams.get(examId);
                examNameEditText.setText(timetable.getExam_name());
                dateEditText.setText(timetable.getDate());
                timeEditText.setText(timetable.getTime());
                syllabusEditText.setText(timetable.getSyllabus());
                // Populate other fields like class and subject using the spinner
            }
        });
    }

    private void saveExamData() {
        String examName = examNameEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String syllabus = syllabusEditText.getText().toString();
        // Get selected class and subject from spinner (you may need to create adapters)
        int classId = (int) classSpinner.getSelectedItem();
        int subjectId = (int) subjectSpinner.getSelectedItem();

        if (examName.isEmpty() || date.isEmpty() || time.isEmpty() || syllabus.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ExamTimeTable exam = new ExamTimeTable();
        //TODO data feeding is pending
        if (isEdit) {
            exam.setExam_time_table_id(examId);
            examViewModel.updateExamTimeTable(exam);
        } else {
            examViewModel.insertExamTimeTable(exam);
        }

        Toast.makeText(this, "Exam details saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
