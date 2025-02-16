package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.Events;
import com.appsr.innovativeschooling.repositories.EventsRepository;
import com.appsr.innovativeschooling.repositories.StudentProfileRepository;

import java.util.List;

public class EventsViewModel extends ViewModel {
    private EventsRepository repository;
    private Context context;

    public Context getContext () {
        return context;
    }

    public void setContext (Context context) {
        this.context = context;
    }

    public void init(Context context) {
        setContext(context);
        if (repository == null) {
            repository = new EventsRepository(context.getApplicationContext());
        }
    }
    private final MutableLiveData<List<Events>> eventsLiveData = new MutableLiveData<>();

    public EventsViewModel() {

    }

    public LiveData<List<Events>> getAllEvents() {
        return eventsLiveData;
    }

    public void fetchAllEvents() {
        repository.getAllEvents();
    }

    public void insertEvent(Events event) {
        repository.insert(event);
    }

    public void updateEvent(Events event) {
        repository.update(event);
    }

    public void deleteEvent(Events event) {
        repository.update(event);
    }
}

