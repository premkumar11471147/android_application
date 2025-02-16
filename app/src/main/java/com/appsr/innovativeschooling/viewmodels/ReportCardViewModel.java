package com.appsr.innovativeschooling.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.ReportCard;
import com.appsr.innovativeschooling.repositories.HomeWorkRepository;
import com.appsr.innovativeschooling.repositories.ReportCardRepository;

import java.util.List;

public class ReportCardViewModel extends ViewModel {
    private ReportCardRepository repository;

    private final MutableLiveData<List<ReportCard>> reportCardsLiveData = new MutableLiveData<>();



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
            repository = new ReportCardRepository(context.getApplicationContext());
        }
    }

    public ReportCardViewModel() {
    }

    public LiveData<List<ReportCard>> getAllReportCards() {
        return reportCardsLiveData;
    }

    public void fetchAllReportCards() {
        repository.getAllReportCards();
    }

    public void insertReportCard(ReportCard reportCard) {
        repository.insert(reportCard);
    }

    public void updateReportCard(ReportCard reportCard) {
        repository.update(reportCard);
    }

    public void deleteReportCard(ReportCard reportCard) {
        repository.delete(reportCard);
    }
}
