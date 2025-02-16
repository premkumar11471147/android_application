package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.StudentProfile;

import java.util.List;

@Dao
public interface StudentProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(StudentProfile student);

    @Update
    void updateStudent(StudentProfile student);

    @Delete
    void deleteStudent(StudentProfile student);

    @Query("SELECT * FROM student_profile ORDER BY first_name ASC")
    LiveData<List<StudentProfile>> getAllStudents();

    @Query("SELECT * FROM student_profile WHERE student_id = :studentId")
    LiveData<StudentProfile> getStudentById(int studentId);
}
