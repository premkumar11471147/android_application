package com.appsr.innovativeschooling.database.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.Fees;

import java.util.List;

@Dao
public interface FeesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFees(Fees fees);

    @Update
    void updateFees(Fees fees);

    @Delete
    void deleteFees(Fees fees);

    @Query("SELECT * FROM Fees WHERE receipt_id = :receipt_id")
    LiveData<Fees> getFeesById(int receipt_id);


    @Query("SELECT * FROM fees WHERE student_id = :studentId")
    LiveData<List<Fees>> getFeesByStudent(int studentId);
    @Query("SELECT * FROM fees ")
    LiveData<List<Fees>> getAllFees();
}