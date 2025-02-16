package com.appsr.innovativeschooling.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsr.innovativeschooling.models.Fees;
import com.appsr.innovativeschooling.repositories.ExamTimeTableRepository;
import com.appsr.innovativeschooling.repositories.FeesRepository;

import java.util.List;
public class FeesViewModel extends ViewModel {
    private FeesRepository repository;
    private final MutableLiveData<List<Fees>> feesLiveData = new MutableLiveData<>();


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
            repository = new FeesRepository(context.getApplicationContext());
        }
    }
    public FeesViewModel() {
    }

    public LiveData<List<Fees>> getFees() {
        return feesLiveData;
    }

    public void fetchAllFees() {
        repository.getAllFees();
    }

    public void insertFee(Fees fee) {
        repository.insert(fee);
    }

    public void updateFee(Fees fee) {
        repository.update(fee);
    }

    public void deleteFee(Fees fee) {
        repository.delete(fee);
    }
}


