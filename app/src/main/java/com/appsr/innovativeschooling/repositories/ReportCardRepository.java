package com.appsr.innovativeschooling.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.ReportCardDao;
import com.appsr.innovativeschooling.models.ReportCard;

import java.util.List;
import java.util.concurrent.Executors;

public class ReportCardRepository {
    private ReportCardDao dao;
    private LiveData<List<ReportCard>> allReportCards;

    public ReportCardRepository(Context application) {
        SchoolDatabase db =SchoolDatabase.getDatabase(application);
        dao = db.reportCardDao();
        allReportCards = dao.getAllReportCards();
    }

    public void insert(ReportCard reportCard) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insertReportCard(reportCard));
    }

    public void update(ReportCard reportCard) {
        Executors.newSingleThreadExecutor().execute(() -> dao.updateReportCard(reportCard));
    }

    public void delete(ReportCard reportCard) {
        Executors.newSingleThreadExecutor().execute(() -> dao.deleteReportCard(reportCard));
    }

    public LiveData<List<ReportCard>> getAllReportCards() {
        return allReportCards;
    }
}
