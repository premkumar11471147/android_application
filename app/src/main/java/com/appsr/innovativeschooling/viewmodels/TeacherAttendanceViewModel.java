package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.TeacherAttendance;
import com.appsr.innovativeschooling.repositories.ReportCardRepository;
import com.appsr.innovativeschooling.repositories.TeacherAttendanceRepository;

import java.util.List;

public class TeacherAttendanceViewModel extends ViewModel {
    private TeacherAttendanceRepository repository;
    private final MutableLiveData<List<TeacherAttendance>> attendanceLiveData = new MutableLiveData<>();
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
            repository = new TeacherAttendanceRepository(context.getApplicationContext());
        }
    }

    public TeacherAttendanceViewModel() {
    }

    public LiveData<List<TeacherAttendance>> getAttendance() {
        return attendanceLiveData;
    }

    public void fetchAllAttendance() {
        repository.getAllAttendance();
    }

    public void insertAttendance(TeacherAttendance attendance) {
        repository.insert(attendance);
    }

    public void updateAttendance(TeacherAttendance attendance) {
        repository.update(attendance);
    }

    public void deleteAttendance(TeacherAttendance attendance) {
        repository.delete(attendance);
    }

    public LiveData<List<TeacherAttendance>> getAttendanceByID(int teacherID) {
        return repository.getAttendanceByID(teacherID);
    }
}
