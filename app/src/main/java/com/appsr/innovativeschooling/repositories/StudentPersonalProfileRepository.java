package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.apiservice.StudentApiService;
import com.appsr.innovativeschooling.apiservice.StudentPersonalApiService;
import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.StudentPersonalDao;
import com.appsr.innovativeschooling.models.StudentPersonalProfile;
import com.appsr.innovativeschooling.retrofit.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executors;

import javax.security.auth.callback.Callback;

public class StudentPersonalProfileRepository {
    private StudentPersonalDao dao;
    private StudentPersonalApiService apiService;

    public StudentPersonalProfileRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        dao = db.studentPersonalDao();
        apiService = RetrofitClient.getInstance().createApiService(StudentPersonalApiService.class);
    }

    public void insert(StudentPersonalProfile profile) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insertStudentPersonal(profile));
    }

    public void update(StudentPersonalProfile profile) {
        Executors.newSingleThreadExecutor().execute(() -> dao.updateStudentPersonal(profile));
    }

    public void delete(StudentPersonalProfile profile) {
        Executors.newSingleThreadExecutor().execute(() -> dao.deleteStudentPersonal(profile));
    }

    public LiveData<StudentPersonalProfile> getProfile(int id) {
        return dao.getStudentPersonalById(id);
    }

    public LiveData<List<StudentPersonalProfile>> getAllProfiles() {
        return dao.getStudentPersonalProfileList();
    }
}
