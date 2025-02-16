package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.StudentAttendance;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentAttendanceApiService {
    @GET("student_attendance")
    Call<List<StudentAttendance>> getAllStudentAttendance();

    @GET("student_attendance/{id}")
    Call<StudentAttendance> getStudentAttendanceById(@Path("id") int id);

    @POST("student_attendance")
    Call<Void> createStudentAttendance(@Body StudentAttendance attendance);

    @PUT("student_attendance/{id}")
    Call<Void> updateStudentAttendance(@Path("id") int id, @Body StudentAttendance attendance);

    @DELETE("student_attendance/{id}")
    Call<Void> deleteStudentAttendance(@Path("id") int id);
}

