package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.StudentAttendance;
import com.appsr.innovativeschooling.models.TeacherAttendance;

import java.util.List;

@Dao
public interface TeacherAttendanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TeacherAttendance attendance);

    @Update
    void update(TeacherAttendance attendance);

    @Delete
    void delete(TeacherAttendance attendance);

    @Query("SELECT * FROM teacher_attendance WHERE id = :teacherId")
    LiveData<List<TeacherAttendance>> getAttendanceByTeacher(int teacherId);

    @Query("SELECT * FROM teacher_attendance")
    LiveData<List<TeacherAttendance>> getAllAttendanceTeacher();
}

