package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "exam_time_table",
        foreignKeys = @ForeignKey(entity = Classes.class, parentColumns = "class_id", childColumns = "class_id"),
        indices = {@Index(value = "class_id")})
public class ExamTimeTable {
    @PrimaryKey(autoGenerate = true)
    public int exam_time_table_id;

    @ColumnInfo(name = "class_id")
    public int classId;

    public String exam_name;
    public String subject;
    public String date;
    public String time;
    public String syllabus;


    public int getExam_time_table_id () {
        return exam_time_table_id;
    }

    public void setExam_time_table_id (int exam_time_table_id) {
        this.exam_time_table_id = exam_time_table_id;
    }

    public int getClassId () {
        return classId;
    }

    public void setClassId (int classId) {
        this.classId = classId;
    }

    public String getExam_name () {
        return exam_name;
    }

    public void setExam_name (String exam_name) {
        this.exam_name = exam_name;
    }

    public String getSubject () {
        return subject;
    }

    public void setSubject (String subject) {
        this.subject = subject;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

    public String getSyllabus () {
        return syllabus;
    }

    public void setSyllabus (String syllabus) {
        this.syllabus = syllabus;
    }
}


