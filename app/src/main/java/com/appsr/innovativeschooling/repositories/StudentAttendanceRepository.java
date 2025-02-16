package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.StudentAttendanceDao;
import com.appsr.innovativeschooling.models.StudentAttendance;

import java.util.List;
import java.util.concurrent.Executors;

public class StudentAttendanceRepository {
    private StudentAttendanceDao attendanceDao;
    private LiveData<List<StudentAttendance>> allAttendance;

    public StudentAttendanceRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        attendanceDao = db.studentAttendanceDao();
        allAttendance = attendanceDao.getAllAttendance();
    }

    public void insert(StudentAttendance attendance) {
        Executors.newSingleThreadExecutor().execute(() -> attendanceDao.insertAttendance(attendance));
    }

    public void update(StudentAttendance attendance) {
        Executors.newSingleThreadExecutor().execute(() -> attendanceDao.updateAttendance(attendance));
    }

    public void delete(StudentAttendance attendance) {
        Executors.newSingleThreadExecutor().execute(() -> attendanceDao.deleteAttendance(attendance));
    }

    public LiveData<List<StudentAttendance>> getAllAttendance() {
        return allAttendance;
    }
}
