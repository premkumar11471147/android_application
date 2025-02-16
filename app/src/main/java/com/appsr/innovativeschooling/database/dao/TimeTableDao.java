package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.TimeTable;

import java.util.List;

@Dao
public interface TimeTableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTimeTable(TimeTable timeTable);

    @Update
    void updateTimeTable(TimeTable timeTable);

    @Delete
    void deleteTimeTable(TimeTable timeTable);

    @Query("SELECT * FROM time_table WHERE time_table_id = :id")
    LiveData<TimeTable> getTimeTableById(int id);


    @Query("SELECT * FROM time_table WHERE class_id = :classId AND weekDays = :weekDay")
    LiveData<List<TimeTable>> getTimeTableForClass(int classId, String weekDay);


    @Query("SELECT * FROM time_table")
    LiveData<List<TimeTable>> getAllTimeTable();

}
