package com.appsr.innovativeschooling.repositories;


import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.EventsDao;
import com.appsr.innovativeschooling.database.dao.ExamDao;
import com.appsr.innovativeschooling.models.Events;
import com.appsr.innovativeschooling.models.ExamTimeTable;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

public class EventsRepository {
    private EventsDao dao;
    private LiveData<List<Events>> allEvents;

    public EventsRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        dao = db.eventsDao();
        allEvents = dao.getUpcomingEvents(new Date().toString());
    }

    public void insert(Events event) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insertEvent(event));
    }

    public void update(Events event) {
        Executors.newSingleThreadExecutor().execute(() -> dao.updateEvent(event));
    }

    public void delete(Events event) {
        Executors.newSingleThreadExecutor().execute(() -> dao.deleteEvent(event));
    }

    public LiveData<List<Events>> getAllEvents() {
        return allEvents;
    }
}


