package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.ExamTimeTable;
import com.appsr.innovativeschooling.repositories.EventsRepository;
import com.appsr.innovativeschooling.repositories.ExamTimeTableRepository;

import java.util.List;

public class ExamTimeTableViewModel extends ViewModel {
    private ExamTimeTableRepository repository;
    private final MutableLiveData<List<ExamTimeTable>> examTimeTablesLiveData = new MutableLiveData<>();

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
            repository = new ExamTimeTableRepository(context.getApplicationContext());
        }
    }


    public ExamTimeTableViewModel() {
    }

    public LiveData<List<ExamTimeTable>> getAllExamTimeTables() {
        return examTimeTablesLiveData;
    }

    public LiveData<List<ExamTimeTable>> getExamTimeTableByClassID(int classID) {
        return repository.getAllExamTimeTablesByClassID(classID);
    }

    public void fetchAllExamTimeTables() {
        repository.getAllExamTimeTables();
    }

    public void insertExamTimeTable(ExamTimeTable examTimeTable) {
        repository.insert(examTimeTable);
    }

    public void updateExamTimeTable(ExamTimeTable examTimeTable) {
        repository.update(examTimeTable);
    }

    public void deleteExamTimeTable(ExamTimeTable examTimeTable) {
        repository.delete(examTimeTable);
    }
}
