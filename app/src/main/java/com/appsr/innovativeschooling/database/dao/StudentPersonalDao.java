package com.appsr.innovativeschooling.database.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.StudentPersonalProfile;
import com.appsr.innovativeschooling.models.StudentProfile;

import java.util.List;

@Dao
public interface StudentPersonalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudentPersonal(StudentPersonalProfile profile);

    @Update
    void updateStudentPersonal(StudentPersonalProfile profile);

    @Delete
    void deleteStudentPersonal(StudentPersonalProfile profile);

    @Query("SELECT * FROM student_personal_profile WHERE ID = :id")
    LiveData<StudentPersonalProfile> getStudentPersonalById(int id);


    @Query("SELECT * FROM student_personal_profile")
    LiveData<List<StudentPersonalProfile>> getStudentPersonalProfileList();
}