package com.appsr.innovativeschooling.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "classes")
public class Classes {
    @PrimaryKey(autoGenerate = true)
    private int class_id; // Primary Key

    private String className;
    private String classSection;

    public int getClass_id () {
        return class_id;
    }

    public void setClass_id (int class_id) {
        this.class_id = class_id;
    }

    public String getClassName () {
        return className;
    }

    public void setClassName (String className) {
        this.className = className;
    }

    public String getClassSection () {
        return classSection;
    }

    public void setClassSection (String classSection) {
        this.classSection = classSection;
    }
}

