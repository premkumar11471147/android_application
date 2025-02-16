package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.FeesDao;
import com.appsr.innovativeschooling.models.Fees;

import java.util.List;
import java.util.concurrent.Executors;

public class FeesRepository {
    private FeesDao feesDao;
    private LiveData<List<Fees>> allFees;

    public FeesRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        feesDao = db.feesDao();
        allFees = feesDao.getAllFees();
    }

    public void insert(Fees fees) {
        Executors.newSingleThreadExecutor().execute(() -> feesDao.insertFees(fees));
    }

    public void update(Fees fees) {
        Executors.newSingleThreadExecutor().execute(() -> feesDao.updateFees(fees));
    }

    public void delete(Fees fees) {
        Executors.newSingleThreadExecutor().execute(() -> feesDao.deleteFees(fees));
    }

    public LiveData<List<Fees>> getAllFees() {
        return allFees;
    }
}

