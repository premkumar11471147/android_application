package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.StudentProfile;
import com.appsr.innovativeschooling.repositories.StudentProfileRepository;

import java.util.List;
public class StudentProfileViewModel extends ViewModel {
    private StudentProfileRepository repository;
    private final MutableLiveData<List<StudentProfile>> studentsLiveData = new MutableLiveData<>();
    private final MutableLiveData<StudentProfile> studentLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public StudentProfileViewModel() {
    }
    public void init(Context context) {
        setContext(context);
        if (repository == null) {
            repository = new StudentProfileRepository(context);
        }
    }
    public LiveData<List<StudentProfile>> getStudents() {
        return studentsLiveData;
    }

    public LiveData<StudentProfile> getStudent() {
        return studentLiveData;
    }

    public LiveData<String> getError() {
        return errorLiveData;
    }

    public void fetchAllStudents() {
        repository.getAllStudents();
    }

    public LiveData<StudentProfile> fetchStudentById(int id) {
        return repository.getStudentById(id);
    }

    public void addStudent(StudentProfile student) {
        repository.insert(student);
    }

    public void updateStudent(StudentProfile student) {
        repository.update(student);
    }

    public void deleteStudent(StudentProfile id) {
        repository.delete(id);
    }

    private Context context;

    public void setContext(Context context) {
        this.context = context.getApplicationContext();  // Save context as application context
    }

    public Context getContext() {
        return context;
    }
}

