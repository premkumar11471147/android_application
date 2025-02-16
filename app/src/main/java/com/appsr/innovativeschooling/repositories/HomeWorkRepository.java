package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.FeesDao;
import com.appsr.innovativeschooling.database.dao.HomeWorkDao;
import com.appsr.innovativeschooling.models.Fees;
import com.appsr.innovativeschooling.models.HomeWork;

import java.util.List;
import java.util.concurrent.Executors;

public class HomeWorkRepository {
    private HomeWorkDao dao;
    private LiveData<List<HomeWork>> allHomeWork;

    public HomeWorkRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        dao = db.homeWorkDao();
        allHomeWork = dao.getAllHomeWork();
    }

    public void insert(HomeWork homeWork) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insertHomeWork(homeWork));
    }

    public void update(HomeWork homeWork) {
        Executors.newSingleThreadExecutor().execute(() -> dao.updateHomeWork(homeWork));
    }

    public void delete(HomeWork homeWork) {
        Executors.newSingleThreadExecutor().execute(() -> dao.deleteHomeWork(homeWork));
    }

    public LiveData<List<HomeWork>> getAllHomeWork() {
        return allHomeWork;
    }
}

