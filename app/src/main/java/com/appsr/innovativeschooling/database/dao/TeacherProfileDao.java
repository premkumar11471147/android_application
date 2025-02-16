package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.TeacherProfile;

import java.util.List;

@Dao
public interface TeacherProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeacher(TeacherProfile teacher);

    @Update
    void updateTeacher(TeacherProfile teacher);

    @Delete
    void deleteTeacher(TeacherProfile teacher);


    @Query("SELECT * FROM teacher_profile ORDER BY first_name ASC")
    LiveData<List<TeacherProfile>> getAllTeachers();

    @Query("SELECT * FROM teacher_profile WHERE teacher_id = :teacherId")
    LiveData<TeacherProfile> getTeacherById(int teacherId);

}