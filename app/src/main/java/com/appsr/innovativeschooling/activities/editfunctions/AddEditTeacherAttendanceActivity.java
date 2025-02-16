package com.appsr.innovativeschooling.activities.editfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appsr.innovativeschooling.R;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.appsr.innovativeschooling.models.TeacherAttendance;
import com.appsr.innovativeschooling.viewmodels.TeacherAttendanceViewModel;

import java.util.Arrays;
import java.util.List;

public class AddEditTeacherAttendanceActivity extends AppCompatActivity {

    private EditText editTextReason, editTextDate;
    private Spinner spinnerAttendanceStatus;
    private Button buttonSave;
    private TeacherAttendanceViewModel viewModel;
    private int attendanceId = -1; // Default ID for new attendance

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_teacher_attendance);

        editTextReason = findViewById(R.id.editTextTeacherName);
        editTextDate = findViewById(R.id.editTextDate);
        spinnerAttendanceStatus = findViewById(R.id.spinnerAttendanceStatus);
        buttonSave = findViewById(R.id.buttonSaveAttendance);

        // ViewModel setup
        viewModel = new ViewModelProvider(this).get(TeacherAttendanceViewModel.class);

        // Spinner options
        List<String> statusOptions = Arrays.asList("Present", "Absent", "First Half", "Second Half");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, statusOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAttendanceStatus.setAdapter(adapter);

        // Check if editing existing attendance
        if (getIntent().hasExtra("attendance_id")) {
            attendanceId = getIntent().getIntExtra("attendance_id", -1);
            loadAttendanceData(attendanceId);
        }

        buttonSave.setOnClickListener(v -> saveAttendance());
    }

    private void loadAttendanceData(int id) {
        viewModel.getAttendanceByID(id).observe(this, attendance -> {
            if (attendance != null) {
                editTextReason.setText(attendance.get(id).getAbsent_reason());
                editTextDate.setText(attendance.get(id).getDate());
                spinnerAttendanceStatus.setSelection(getSpinnerIndex(spinnerAttendanceStatus, ""+attendance.get(id).getAttendance_status()));
            }
        });
    }

    private void saveAttendance() {
        String reason = editTextReason.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        String status = spinnerAttendanceStatus.getSelectedItem().toString();

        if (reason.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        TeacherAttendance attendance = new TeacherAttendance();
        //TODO need to feed the data

        if (attendanceId == -1) {
            viewModel.insertAttendance(attendance);
            Toast.makeText(this, "Attendance added", Toast.LENGTH_SHORT).show();
        } else {
            viewModel.updateAttendance(attendance);
            Toast.makeText(this, "Attendance updated", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private int getSpinnerIndex(Spinner spinner, String value) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equals(value)) {
                return i;
            }
        }
        return 0;
    }
}
