package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "home_work",
        foreignKeys = {
                @ForeignKey(entity = Classes.class, parentColumns = "class_id", childColumns = "class_id"),
                @ForeignKey(entity = Subject.class, parentColumns = "subject_id", childColumns = "subject_id")
        },
        indices = {@Index(value = "subject_id")})
public class HomeWork {
    @PrimaryKey(autoGenerate = true)
    public int home_work_id;

    @ColumnInfo(name = "subject_id")
    public int subjectId;

    public String description;
    public String due_date;
    public int class_id;

    public int getHome_work_id () {
        return home_work_id;
    }

    public void setHome_work_id (int home_work_id) {
        this.home_work_id = home_work_id;
    }

    public int getSubjectId () {
        return subjectId;
    }

    public void setSubjectId (int subjectId) {
        this.subjectId = subjectId;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDue_date () {
        return due_date;
    }

    public void setDue_date (String due_date) {
        this.due_date = due_date;
    }

    public int getClass_id () {
        return class_id;
    }

    public void setClass_id (int class_id) {
        this.class_id = class_id;
    }
}
