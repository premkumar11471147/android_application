package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_profile",
        foreignKeys = @ForeignKey(entity = Classes.class, parentColumns = "class_id", childColumns = "class_id"),
        indices = {@Index(value = "class_id"), @Index(value = "school_id")})
public class StudentProfile {
    @PrimaryKey(autoGenerate = true)
    public int student_id;

    @ColumnInfo(name = "admission_id")
    public String admissionID;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "class_id")
    public int classId;

    @ColumnInfo(name = "roll_number")
    public int rollNumber;

    @ColumnInfo(name = "school_id")
    public int schoolId;

    public int getStudent_id () {
        return student_id;
    }

    public void setStudent_id (int student_id) {
        this.student_id = student_id;
    }

    public String getAdmissionID () {
        return admissionID;
    }

    public void setAdmissionID (String admissionID) {
        this.admissionID = admissionID;
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

    public int getRollNumber () {
        return rollNumber;
    }

    public void setRollNumber (int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getSchoolId () {
        return schoolId;
    }

    public void setSchoolId (int schoolId) {
        this.schoolId = schoolId;
    }
}

