package com.appsr.innovativeschooling.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "time_table",
        foreignKeys = {
                @ForeignKey(entity = Classes.class, parentColumns = "class_id", childColumns = "class_id"),
                @ForeignKey(entity = TeacherProfile.class, parentColumns = "teacher_id", childColumns = "teacher_id"),
                @ForeignKey(entity = Subject.class, parentColumns = "subject_id", childColumns = "subject_id")
        },
        indices = {@Index(value = "class_id"), @Index(value = "teacher_id"), @Index(value = "subject_id")})
public class TimeTable {
    @PrimaryKey(autoGenerate = true)
    public int time_table_id;

    public String time_from;
    public String time_to;
    public int class_id;
    public int teacher_id;
    public String weekDays;
    public String breakTimings;
    public int subject_id;


    public int getTime_table_id () {
        return time_table_id;
    }

    public void setTime_table_id (int time_table_id) {
        this.time_table_id = time_table_id;
    }

    public String getTime_from () {
        return time_from;
    }

    public void setTime_from (String time_from) {
        this.time_from = time_from;
    }

    public String getTime_to () {
        return time_to;
    }

    public void setTime_to (String time_to) {
        this.time_to = time_to;
    }

    public int getClass_id () {
        return class_id;
    }

    public void setClass_id (int class_id) {
        this.class_id = class_id;
    }

    public int getTeacher_id () {
        return teacher_id;
    }

    public void setTeacher_id (int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getWeekDays () {
        return weekDays;
    }

    public void setWeekDays (String weekDays) {
        this.weekDays = weekDays;
    }

    public String getBreakTimings () {
        return breakTimings;
    }

    public void setBreakTimings (String breakTimings) {
        this.breakTimings = breakTimings;
    }

    public int getSubject_id () {
        return subject_id;
    }

    public void setSubject_id (int subject_id) {
        this.subject_id = subject_id;
    }
}

