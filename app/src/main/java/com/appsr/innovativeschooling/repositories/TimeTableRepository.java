package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.EventsDao;
import com.appsr.innovativeschooling.database.dao.TimeTableDao;
import com.appsr.innovativeschooling.models.Events;
import com.appsr.innovativeschooling.models.TimeTable;

import java.util.List;
import java.util.concurrent.Executors;

public class TimeTableRepository {
    private TimeTableDao dao;
    private LiveData<List<TimeTable>> allTimeTables;

    public TimeTableRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        dao = db.timeTableDao();
        allTimeTables = dao.getAllTimeTable();
    }

    public void insert(TimeTable timeTable) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insertTimeTable(timeTable));
    }

    public void update(TimeTable timeTable) {
        Executors.newSingleThreadExecutor().execute(() -> dao.updateTimeTable(timeTable));
    }

    public void delete(TimeTable timeTable) {
        Executors.newSingleThreadExecutor().execute(() -> dao.deleteTimeTable(timeTable));
    }

    public LiveData<List<TimeTable>> getAllTimeTables() {
        return allTimeTables;
    }
}

