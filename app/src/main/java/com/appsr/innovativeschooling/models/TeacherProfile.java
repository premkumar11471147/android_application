package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_profile",
        foreignKeys = @ForeignKey(entity = Classes.class, parentColumns = "class_id", childColumns = "class_id"),
        indices = {@Index(value = "class_id"), @Index(value = "school_id")})
public class TeacherProfile {
    @PrimaryKey(autoGenerate = true)
    public int teacher_id;



    @ColumnInfo(name = "school_teacher_id")
    public String schoolTeacherId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "class_id")
    public int classId;

    @ColumnInfo(name = "school_id")
    public int schoolId;

    public int getTeacher_id () {
        return teacher_id;
    }

    public void setTeacher_id (int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSchoolTeacherId () {
        return schoolTeacherId;
    }

    public void setSchoolTeacherId (String schoolTeacherId) {
        this.schoolTeacherId = schoolTeacherId;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public int getClassId () {
        return classId;
    }

    public void setClassId (int classId) {
        this.classId = classId;
    }

    public int getSchoolId () {
        return schoolId;
    }

    public void setSchoolId (int schoolId) {
        this.schoolId = schoolId;
    }
}

