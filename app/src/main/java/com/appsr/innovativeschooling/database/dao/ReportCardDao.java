package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.ReportCard;

import java.util.List;

@Dao
public interface ReportCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReportCard(ReportCard reportCard);

    @Update
    void updateReportCard(ReportCard reportCard);

    @Delete
    void deleteReportCard(ReportCard reportCard);


    @Query("SELECT * FROM report_card WHERE admission_id = :admissionId")
    LiveData<List<ReportCard>> getReportCardsByStudent(int admissionId);


    @Query("SELECT * FROM report_card")
    LiveData<List<ReportCard>> getAllReportCards();
}
