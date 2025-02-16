package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.app.DownloadManager;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.apiservice.TeacherProfileApiService;
import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.TeacherProfileDao;
import com.appsr.innovativeschooling.models.TeacherProfile;
import com.appsr.innovativeschooling.retrofit.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Callback;

public class TeacherProfileRepository {
    private TeacherProfileDao teacherProfileDao;
    private LiveData<List<TeacherProfile>> allTeachers;
    private TeacherProfileApiService teacherApiService;

    public TeacherProfileRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        teacherProfileDao = db.teacherDao();
        allTeachers = teacherProfileDao.getAllTeachers();
        teacherApiService = RetrofitClient.getInstance().create(TeacherProfileApiService.class);
    }

    public void insert(TeacherProfile teacher) {
        Executors.newSingleThreadExecutor().execute(() -> teacherProfileDao.insertTeacher(teacher));
    }

    public void update(TeacherProfile teacher) {
        Executors.newSingleThreadExecutor().execute(() -> teacherProfileDao.updateTeacher(teacher));
    }

    public void delete(TeacherProfile teacher) {
        Executors.newSingleThreadExecutor().execute(() -> teacherProfileDao.deleteTeacher(teacher));
    }

    public LiveData<List<TeacherProfile>> getAllTeachers() {
        return allTeachers;
    }

    public LiveData<TeacherProfile> getTeacherById(int id) {
        return teacherProfileDao.getTeacherById(id);
    }

    public void fetchTeachersFromServer(Callback<List<TeacherProfile>> callback) {
        teacherApiService.getAllTeachers().enqueue( callback);
    }
}

