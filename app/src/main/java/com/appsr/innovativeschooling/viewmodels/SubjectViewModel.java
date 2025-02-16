package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.Subject;
import com.appsr.innovativeschooling.repositories.StudentPersonalProfileRepository;
import com.appsr.innovativeschooling.repositories.SubjectRepository;

import java.util.List;

public class SubjectViewModel extends ViewModel {
    private SubjectRepository repository;
    private final MutableLiveData<List<Subject>> subjectsLiveData = new MutableLiveData<>();



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
            repository = new SubjectRepository(context.getApplicationContext());
        }
    }
    public SubjectViewModel() {
    }

    public LiveData<List<Subject>> getSubjects() {
        return subjectsLiveData;
    }

    public void fetchAllSubjects() {
        repository.getAllSubjects();
    }

    public void insertSubject(Subject subject) {
        repository.insert(subject);
    }

    public void updateSubject(Subject subject) {
        repository.update(subject);
    }

    public void deleteSubject(Subject subject) {
        repository.delete(subject);
    }
}

