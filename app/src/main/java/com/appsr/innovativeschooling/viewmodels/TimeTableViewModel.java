package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.TimeTable;
import com.appsr.innovativeschooling.repositories.TeacherProfileRepository;
import com.appsr.innovativeschooling.repositories.TimeTableRepository;

import java.util.List;

public class TimeTableViewModel extends ViewModel {
    private TimeTableRepository repository;
    private final MutableLiveData<List<TimeTable>> timeTablesLiveData = new MutableLiveData<>();

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
            repository = new TimeTableRepository(context.getApplicationContext());
        }
    }


    public TimeTableViewModel() {
    }

    public LiveData<List<TimeTable>> getAllTimeTables() {
        return timeTablesLiveData;
    }

    public void fetchAllTimeTables() {
        repository.getAllTimeTables();
    }

    public void insertTimeTable(TimeTable timeTable) {
        repository.insert(timeTable);
    }

    public void updateTimeTable(TimeTable timeTable) {
        repository.update(timeTable);
    }

    public void deleteTimeTable(TimeTable timeTable) {
        repository.delete(timeTable);
    }
}
