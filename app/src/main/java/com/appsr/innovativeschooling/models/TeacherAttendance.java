package com.appsr.innovativeschooling.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_attendance",
        foreignKeys = @ForeignKey(entity = TeacherProfile.class, parentColumns = "teacher_id", childColumns = "id"),
        indices = {@Index(value = "id")})
public class TeacherAttendance {
    @PrimaryKey(autoGenerate = true)
    public int attendance_id;

    @ColumnInfo(name = "id")
    public int teacherId;

    public String date;
    public int attendance_status;
    public String absent_reason;


    public int getAttendance_id () {
        return attendance_id;
    }

    public void setAttendance_id (int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getTeacherId () {
        return teacherId;
    }

    public void setTeacherId (int teacherId) {
        this.teacherId = teacherId;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public int getAttendance_status () {
        return attendance_status;
    }

    public void setAttendance_status (int attendance_status) {
        this.attendance_status = attendance_status;
    }

    public String getAbsent_reason () {
        return absent_reason;
    }

    public void setAbsent_reason (String absent_reason) {
        this.absent_reason = absent_reason;
    }
}

