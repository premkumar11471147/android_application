package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.StudentAttendance;

import java.util.List;

@Dao
public interface StudentAttendanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAttendance(StudentAttendance attendance);

    @Update
    void updateAttendance(StudentAttendance attendance);

    @Delete
    void deleteAttendance(StudentAttendance attendance);

    @Query("SELECT * FROM student_attendance WHERE id = :studentId")
    LiveData<List<StudentAttendance>> getAttendanceByStudent(int studentId);

    @Query("SELECT * FROM student_attendance")
    LiveData<List<StudentAttendance>> getAllAttendance();
}
