package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.FeesDao;
import com.appsr.innovativeschooling.database.dao.SubjectDao;
import com.appsr.innovativeschooling.models.Fees;
import com.appsr.innovativeschooling.models.Subject;

import java.util.List;
import java.util.concurrent.Executors;

public class SubjectRepository {
    private SubjectDao subjectDao;
    private LiveData<List<Subject>> allSubjects;

    public SubjectRepository(Context application) {
        SchoolDatabase db =SchoolDatabase.getDatabase(application);
        subjectDao = db.subjectDao();
        allSubjects = subjectDao.getAllSubjects();
    }

    public void insert(Subject subject) {
        Executors.newSingleThreadExecutor().execute(() -> subjectDao.insertSubject(subject));
    }

    public void update(Subject subject) {
        Executors.newSingleThreadExecutor().execute(() -> subjectDao.updateSubject(subject));
    }

    public void delete(Subject subject) {
        Executors.newSingleThreadExecutor().execute(() -> subjectDao.deleteSubject(subject));
    }

    public LiveData<List<Subject>> getAllSubjects() {
        return allSubjects;
    }
}

