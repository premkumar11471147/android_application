package com.appsr.innovativeschooling.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_personal_profile",
        foreignKeys = @ForeignKey(entity = StudentProfile.class, parentColumns = "student_id", childColumns = "id"),
        indices = {@Index(value = "id")})
public class StudentPersonalProfile {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int studentId;

    public String photo;
    public String date_of_birth;
    public String gender;
    public String father_name;
    public String mother_name;
    public String phone_number;
    public String alternate_number;
    public String email_id;
    public String address;

    public int getStudentId () {
        return studentId;
    }

    public void setStudentId (int studentId) {
        this.studentId = studentId;
    }

    public String getPhoto () {
        return photo;
    }

    public void setPhoto (String photo) {
        this.photo = photo;
    }

    public String getDate_of_birth () {
        return date_of_birth;
    }

    public void setDate_of_birth (String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public String getFather_name () {
        return father_name;
    }

    public void setFather_name (String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name () {
        return mother_name;
    }

    public void setMother_name (String mother_name) {
        this.mother_name = mother_name;
    }

    public String getPhone_number () {
        return phone_number;
    }

    public void setPhone_number (String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAlternate_number () {
        return alternate_number;
    }

    public void setAlternate_number (String alternate_number) {
        this.alternate_number = alternate_number;
    }

    public String getEmail_id () {
        return email_id;
    }

    public void setEmail_id (String email_id) {
        this.email_id = email_id;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }
}


