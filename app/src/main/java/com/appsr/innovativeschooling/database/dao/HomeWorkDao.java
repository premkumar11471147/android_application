package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.HomeWork;

import java.util.List;

@Dao
public interface HomeWorkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHomeWork(HomeWork homeWork);

    @Update
    void updateHomeWork(HomeWork homeWork);

    @Delete
    void deleteHomeWork(HomeWork homeWork);

    @Query("SELECT * FROM home_work WHERE home_work_id = :id")
    LiveData<HomeWork> getHomeWorkById(int id);

    @Query("SELECT * FROM home_work WHERE class_id = :classID")
    LiveData<List<HomeWork>> getHomeWorkByClassID(int classID);

    @Query("SELECT * FROM home_work")
    LiveData<List<HomeWork>> getAllHomeWork();


}
