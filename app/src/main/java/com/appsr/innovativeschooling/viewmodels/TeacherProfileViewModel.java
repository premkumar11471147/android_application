package com.appsr.innovativeschooling.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.TeacherProfile;
import com.appsr.innovativeschooling.repositories.TeacherPersonalProfileRepository;
import com.appsr.innovativeschooling.repositories.TeacherProfileRepository;

import java.util.List;
public class TeacherProfileViewModel extends ViewModel {
    private TeacherProfileRepository repository;
    private final MutableLiveData<List<TeacherProfile>> teachersLiveData = new MutableLiveData<>();


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
            repository = new TeacherProfileRepository(context.getApplicationContext());
        }
    }

    public TeacherProfileViewModel() {
    }

    public LiveData<List<TeacherProfile>> getTeachers() {
        return teachersLiveData;
    }


    public LiveData<TeacherProfile> getTeacherById(int id) {
        return repository.getTeacherById(id);
    }
    public void fetchAllTeachers() {
        repository.getAllTeachers();
    }

    public void insertTeacher(TeacherProfile teacher) {
        repository.insert(teacher);
    }

    public void updateTeacher(TeacherProfile teacher) {
        repository.update(teacher);
    }

    public void deleteTeacher(TeacherProfile teacher) {
        repository.delete(teacher);
    }
}

