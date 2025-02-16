package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.StudentProfile;
import com.appsr.innovativeschooling.models.TeacherPersonalProfile;

import java.util.List;

@Dao
public interface TeacherPersonalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeacherPersonal(TeacherPersonalProfile profile);

    @Update
    void updateTeacherPersonal(TeacherPersonalProfile profile);

    @Delete
    void deleteTeacherPersonal(TeacherPersonalProfile profile);

    @Query("SELECT * FROM teacher_personal_profile WHERE ID = :id")
    LiveData<TeacherPersonalProfile> getTeacherPersonalById(int id);

    @Query("SELECT * FROM teacher_personal_profile")
    LiveData<List<TeacherPersonalProfile>> getAllTeacherPersonalProfile();
}