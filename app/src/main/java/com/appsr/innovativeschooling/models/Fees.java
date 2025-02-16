package com.appsr.innovativeschooling.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "fees",
        foreignKeys = @ForeignKey(entity = StudentProfile.class, parentColumns = "student_id", childColumns = "student_id"),
        indices = {@Index(value = "student_id"), @Index(value = "class_id"), @Index(value = "school_id")})
public class Fees {
    @PrimaryKey(autoGenerate = true)
    public int receipt_id;

    @ColumnInfo(name = "student_id")
    public int studentId;

    public String term;
    public String date;
    public double total_amount;

    @ColumnInfo(name = "class_id")
    public int classId;

    @ColumnInfo(name = "school_id")
    public int schoolId;

    public int getReceipt_id () {
        return receipt_id;
    }

    public void setReceipt_id (int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getStudentId () {
        return studentId;
    }

    public void setStudentId (int studentId) {
        this.studentId = studentId;
    }

    public String getTerm () {
        return term;
    }

    public void setTerm (String term) {
        this.term = term;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public double getTotal_amount () {
        return total_amount;
    }

    public void setTotal_amount (double total_amount) {
        this.total_amount = total_amount;
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


