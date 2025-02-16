package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.Classes;

import java.util.List;

@Dao
public interface ClassDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClass(Classes classObj);

    @Update
    void updateClass(Classes classObj);

    @Delete
    void deleteClass(Classes classObj);

    @Query("SELECT * FROM classes WHERE class_id = :class_id")
    LiveData<Classes> getClassesById(int class_id);

    @Query("SELECT * FROM classes")
    LiveData<List<Classes>> getAllClasses();
}