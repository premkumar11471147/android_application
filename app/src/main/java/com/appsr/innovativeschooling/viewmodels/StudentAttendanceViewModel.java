package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.StudentAttendance;
import com.appsr.innovativeschooling.repositories.ReportCardRepository;
import com.appsr.innovativeschooling.repositories.StudentAttendanceRepository;

import java.util.List;

public class StudentAttendanceViewModel extends ViewModel {
    private  StudentAttendanceRepository repository;
    private final MutableLiveData<List<StudentAttendance>> attendanceLiveData = new MutableLiveData<>();
    private Context context;

    public Context getContext () {
        return context;
    }

    public void setContext (Context context) {
        this.context = context;
    }

    public void init(Context context) {
        setContext(context);
        if (repository == null) {
            repository = new StudentAttendanceRepository(context.getApplicationContext());
        }
    }

    public StudentAttendanceViewModel() {
    }

    public LiveData<List<StudentAttendance>> getAttendance() {
        return attendanceLiveData;
    }

    public void fetchAllAttendance() {
        repository.getAllAttendance();
    }

    public void insertAttendance(StudentAttendance attendance) {
        repository.insert(attendance);
    }

    public void updateAttendance(StudentAttendance attendance) {
        repository.update(attendance);
    }

    public void deleteAttendance(StudentAttendance attendance) {
        repository.delete(attendance);
    }
}
