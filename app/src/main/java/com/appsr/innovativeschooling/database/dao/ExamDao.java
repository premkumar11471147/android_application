package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.ExamTimeTable;

import java.util.List;

@Dao
public interface ExamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExam(ExamTimeTable exam);

    @Update
    void updateExam(ExamTimeTable exam);

    @Delete
    void deleteExam(ExamTimeTable exam);

    @Query("SELECT * FROM exam_time_table WHERE class_id = :classID")
    LiveData<List<ExamTimeTable>> getExamByClassId(int classID);

    @Query("SELECT * FROM exam_time_table ORDER BY exam_time_table_id ASC")
    LiveData<List<ExamTimeTable>> getAllExam();
}