package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.apiservice.StudentApiService;
import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.StudentProfileDao;
import com.appsr.innovativeschooling.models.StudentProfile;
import com.appsr.innovativeschooling.retrofit.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Callback;

public class StudentProfileRepository {
    private StudentProfileDao studentProfileDao;
    private LiveData<List<StudentProfile>> allStudents;
    private StudentApiService studentApiService;

    public StudentProfileRepository(Context context) {
        SchoolDatabase db = SchoolDatabase.getDatabase(context);
        studentProfileDao = db.studentDao();
        allStudents = studentProfileDao.getAllStudents();
        studentApiService = RetrofitClient.getInstance().createApiService(StudentApiService.class);
    }
    public void insert(StudentProfile student) {
        Executors.newSingleThreadExecutor().execute(() -> studentProfileDao.insertStudent(student));
    }

    public void update(StudentProfile student) {
        Executors.newSingleThreadExecutor().execute(() -> studentProfileDao.updateStudent(student));
    }

    public void delete(StudentProfile student) {
        Executors.newSingleThreadExecutor().execute(() -> studentProfileDao.deleteStudent(student));
    }

    public LiveData<List<StudentProfile>> getAllStudents() {
        return allStudents;
    }

    public LiveData<StudentProfile> getStudentById(int id) {
        return studentProfileDao.getStudentById(id);
    }

    public void fetchStudentsFromServer(Callback<List<StudentProfile>> callback) {
        studentApiService.getAllStudents().enqueue(callback);
    }
}
