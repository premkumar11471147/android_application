package com.appsr.innovativeschooling.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.StudentAttendanceDao;
import com.appsr.innovativeschooling.database.dao.TeacherAttendanceDao;
import com.appsr.innovativeschooling.models.StudentAttendance;
import com.appsr.innovativeschooling.models.TeacherAttendance;

import java.util.List;
import java.util.concurrent.Executors;

public class TeacherAttendanceRepository {
    private TeacherAttendanceDao attendanceDao;
    private LiveData<List<TeacherAttendance>> allAttendance;

    public TeacherAttendanceRepository (Context application) {
        SchoolDatabase db =  SchoolDatabase.getDatabase(application);
        attendanceDao = db.teacherAttendanceDao();
        allAttendance = attendanceDao.getAllAttendanceTeacher();
    }

    public void insert(TeacherAttendance attendance) {
        Executors.newSingleThreadExecutor().execute(() -> attendanceDao.insert(attendance));
    }

    public void update(TeacherAttendance attendance) {
        Executors.newSingleThreadExecutor().execute(() -> attendanceDao.update(attendance));
    }

    public void delete(TeacherAttendance attendance) {
        Executors.newSingleThreadExecutor().execute(() -> attendanceDao.delete(attendance));
    }

    public LiveData<List<TeacherAttendance>> getAllAttendance() {
        return allAttendance;
    }

    public LiveData<List<TeacherAttendance>> getAttendanceByID(int teacherID) {
        return attendanceDao.getAttendanceByTeacher(teacherID);
    }
}
