package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.HomeWork;
import com.appsr.innovativeschooling.repositories.FeesRepository;
import com.appsr.innovativeschooling.repositories.HomeWorkRepository;

import java.util.List;

public class HomeWorkViewModel extends ViewModel {
    private HomeWorkRepository repository;
    private final MutableLiveData<List<HomeWork>> homeWorksLiveData = new MutableLiveData<>();


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
            repository = new HomeWorkRepository(context.getApplicationContext());
        }
    }

    public HomeWorkViewModel() {
    }

    public LiveData<List<HomeWork>> getAllHomeWorks() {
        return homeWorksLiveData;
    }

    public void fetchAllHomeWorks() {
        repository.getAllHomeWork();
    }

    public void insertHomeWork(HomeWork homeWork) {
        repository.insert(homeWork);
    }

    public void updateHomeWork(HomeWork homeWork) {
        repository.update(homeWork);
    }

    public void deleteHomeWork(HomeWork homeWork) {
        repository.delete(homeWork);
    }
}
