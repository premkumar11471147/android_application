package com.appsr.innovativeschooling.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.TeacherPersonalProfile;
import com.appsr.innovativeschooling.repositories.TeacherAttendanceRepository;
import com.appsr.innovativeschooling.repositories.TeacherPersonalProfileRepository;

import java.util.List;
public class TeacherPersonalProfileViewModel extends ViewModel {
    private TeacherPersonalProfileRepository repository;
    private final MutableLiveData<List<TeacherPersonalProfile>> profilesLiveData = new MutableLiveData<>();

    public TeacherPersonalProfileViewModel() {
    }

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
            repository = new TeacherPersonalProfileRepository(context.getApplicationContext());
        }
    }

    public LiveData<List<TeacherPersonalProfile>> getAllProfiles() {
        return profilesLiveData;
    }

    public void fetchAllProfiles() {
        repository.getAllPersonalProfiles();/*new RepositoryCallback<List<TeacherPersonalProfile>>() {
            @Override
            public void onSuccess(List<TeacherPersonalProfile> data) {
                profilesLiveData.postValue(data);
            }

            @Override
            public void onFailure(String errorMessage) {}
        }*/
    }

    public void insertProfile(TeacherPersonalProfile profile) {
        repository.insert(profile);
    }

    public void updateProfile(TeacherPersonalProfile profile) {
        repository.update(profile);
    }

    public void deleteProfile(TeacherPersonalProfile profile) {
        repository.delete(profile);
    }

    public LiveData<TeacherPersonalProfile> getTeacherByID(int teacherID) {
        return repository.getTeacherByID(teacherID);
    }
}

