package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.StudentPersonalProfile;
import com.appsr.innovativeschooling.repositories.StudentPersonalProfileRepository;

import java.util.List;
public class StudentPersonalProfileViewModel extends ViewModel {
    private StudentPersonalProfileRepository repository;
    private final MutableLiveData<List<StudentPersonalProfile>> profilesLiveData = new MutableLiveData<>();

    public StudentPersonalProfileViewModel() {
    }

    public LiveData<List<StudentPersonalProfile>> getStudentPersonalProfiles() {
        return profilesLiveData;
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
            repository = new StudentPersonalProfileRepository(context.getApplicationContext());
        }
    }


    public void fetchAllStudentPersonalProfiles() {
        repository.getAllProfiles();
    }

    public void insertStudentPersonalProfile(StudentPersonalProfile profile) {
        repository.insert(profile);
    }

    public void updateStudentPersonalProfile(StudentPersonalProfile profile) {
        repository.update(profile);
    }

    public void deleteStudentPersonalProfile(StudentPersonalProfile profile) {
        repository.delete(profile);
    }

    public LiveData<StudentPersonalProfile> getProfileByID(int id) {
       return repository.getProfile(id);
    }
}
