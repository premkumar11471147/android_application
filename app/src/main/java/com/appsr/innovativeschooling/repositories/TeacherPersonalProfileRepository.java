package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.TeacherPersonalDao;
import com.appsr.innovativeschooling.models.TeacherPersonalProfile;

import java.util.List;
import java.util.concurrent.Executors;

public class TeacherPersonalProfileRepository {
    private TeacherPersonalDao teacherPersonalDao;
    private LiveData<List<TeacherPersonalProfile>> allPersonalProfiles;

    public TeacherPersonalProfileRepository(Context application) {
        SchoolDatabase database = SchoolDatabase.getDatabase(application);
        teacherPersonalDao = database.teacherPersonalDao();
        allPersonalProfiles = teacherPersonalDao.getAllTeacherPersonalProfile();
    }

    public void insert(TeacherPersonalProfile profile) {
        Executors.newSingleThreadExecutor().execute(() ->  teacherPersonalDao.insertTeacherPersonal(profile));
    }

    public void update(TeacherPersonalProfile profile) {
        Executors.newSingleThreadExecutor().execute(() ->  teacherPersonalDao.updateTeacherPersonal(profile));
    }

    public void delete(TeacherPersonalProfile profile) {
        Executors.newSingleThreadExecutor().execute(() ->  teacherPersonalDao.deleteTeacherPersonal(profile));
    }

    public LiveData<List<TeacherPersonalProfile>> getAllPersonalProfiles() {
        return allPersonalProfiles;
    }
    public LiveData<TeacherPersonalProfile> getTeacherByID(int teacherID) {
        return teacherPersonalDao.getTeacherPersonalById(teacherID);
    }

}

