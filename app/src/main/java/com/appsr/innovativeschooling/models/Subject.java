package com.appsr.innovativeschooling.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "subject")
public class Subject {
    @PrimaryKey(autoGenerate = true)
    public int subject_id;

    public String subject_name;
    public String subject_project_work;
    public String subject_assignment_work;
    public String subject_test;
    public String subject_running_notes;

    public int getSubject_id () {
        return subject_id;
    }

    public void setSubject_id (int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name () {
        return subject_name;
    }

    public void setSubject_name (String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_project_work () {
        return subject_project_work;
    }

    public void setSubject_project_work (String subject_project_work) {
        this.subject_project_work = subject_project_work;
    }

    public String getSubject_assignment_work () {
        return subject_assignment_work;
    }

    public void setSubject_assignment_work (String subject_assignment_work) {
        this.subject_assignment_work = subject_assignment_work;
    }

    public String getSubject_test () {
        return subject_test;
    }

    public void setSubject_test (String subject_test) {
        this.subject_test = subject_test;
    }

    public String getSubject_running_notes () {
        return subject_running_notes;
    }

    public void setSubject_running_notes (String subject_running_notes) {
        this.subject_running_notes = subject_running_notes;
    }
}

