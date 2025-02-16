package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.TeacherProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TeacherProfileApiService {
    @GET("teacher_profiles")
    Call<List<TeacherProfile>> getAllTeachers();

    @GET("teacher_profiles/{id}")
    Call<TeacherProfile> getTeacherById(@Path("id") int id);

    @POST("teacher_profiles")
    Call<Void> createTeacher(@Body TeacherProfile teacherProfile);

    @PUT("teacher_profiles/{id}")
    Call<Void> updateTeacher(@Path("id") int id, @Body TeacherProfile teacherProfile);

    @DELETE("teacher_profiles/{id}")
    Call<Void> deleteTeacher(@Path("id") int id);
}

