package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.ExamDao;
import com.appsr.innovativeschooling.database.dao.FeesDao;
import com.appsr.innovativeschooling.models.ExamTimeTable;
import com.appsr.innovativeschooling.models.Fees;

import java.util.List;
import java.util.concurrent.Executors;

public class ExamTimeTableRepository {
    private ExamDao dao;
    private LiveData<List<ExamTimeTable>> allExamTimeTables;

    public ExamTimeTableRepository(Context application) {
        SchoolDatabase db = SchoolDatabase.getDatabase(application);
        dao = db.examDao();
        allExamTimeTables = dao.getAllExam();
    }

    public void insert(ExamTimeTable examTimeTable) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insertExam(examTimeTable));
    }

    public void update(ExamTimeTable examTimeTable) {
        Executors.newSingleThreadExecutor().execute(() -> dao.updateExam(examTimeTable));
    }

    public void delete(ExamTimeTable examTimeTable) {
        Executors.newSingleThreadExecutor().execute(() -> dao.deleteExam(examTimeTable));
    }

    public LiveData<List<ExamTimeTable>> getAllExamTimeTables() {
        return allExamTimeTables;
    }

    public LiveData<List<ExamTimeTable>> getAllExamTimeTablesByClassID(int classID) {
        return dao.getExamByClassId(classID);
    }
}


