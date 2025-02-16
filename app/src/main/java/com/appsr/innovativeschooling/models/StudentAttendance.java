package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_attendance",
        foreignKeys = @ForeignKey(entity = StudentProfile.class, parentColumns = "student_id", childColumns = "id"),
        indices = {@Index(value = "id")})
public class StudentAttendance {
    @PrimaryKey(autoGenerate = true)
    public int attendance_id;

    @ColumnInfo(name = "id")
    public int studentId;

    public String date;
    public boolean present;
    public String absent_reason;

    public int getAttendance_id () {
        return attendance_id;
    }

    public void setAttendance_id (int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getStudentId () {
        return studentId;
    }

    public void setStudentId (int studentId) {
        this.studentId = studentId;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public boolean isPresent () {
        return present;
    }

    public void setPresent (boolean present) {
        this.present = present;
    }

    public String getAbsent_reason () {
        return absent_reason;
    }

    public void setAbsent_reason (String absent_reason) {
        this.absent_reason = absent_reason;
    }
}
