package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "report_card",
        foreignKeys = {
                @ForeignKey(entity = StudentProfile.class, parentColumns = "student_id", childColumns = "admission_id"),
                @ForeignKey(entity = Subject.class, parentColumns = "subject_id", childColumns = "subject_id")
        },
        indices = {@Index(value = "admission_id"), @Index(value = "subject_id")})
public class ReportCard {
    @PrimaryKey(autoGenerate = true)
    public int report_id;

    @ColumnInfo(name = "admission_id")
    public int admissionId;

    @ColumnInfo(name = "exam_id")
    public int examId;

    @ColumnInfo(name = "subject_id")
    public int subjectId;

    public double total_marks;
    public String grade;
    public String remarks;

    @ColumnInfo(name = "attendance_id")
    public int attendanceId;

    public int getReport_id () {
        return report_id;
    }

    public void setReport_id (int report_id) {
        this.report_id = report_id;
    }

    public int getAdmissionId () {
        return admissionId;
    }

    public void setAdmissionId (int admissionId) {
        this.admissionId = admissionId;
    }

    public int getExamId () {
        return examId;
    }

    public void setExamId (int examId) {
        this.examId = examId;
    }

    public int getSubjectId () {
        return subjectId;
    }

    public void setSubjectId (int subjectId) {
        this.subjectId = subjectId;
    }

    public double getTotal_marks () {
        return total_marks;
    }

    public void setTotal_marks (double total_marks) {
        this.total_marks = total_marks;
    }

    public String getGrade () {
        return grade;
    }

    public void setGrade (String grade) {
        this.grade = grade;
    }

    public String getRemarks () {
        return remarks;
    }

    public void setRemarks (String remarks) {
        this.remarks = remarks;
    }

    public int getAttendanceId () {
        return attendanceId;
    }

    public void setAttendanceId (int attendanceId) {
        this.attendanceId = attendanceId;
    }
}

