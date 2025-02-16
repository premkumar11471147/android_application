package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.StudentProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentApiService {
    @GET("student")
    Call<List<StudentProfile>> getAllStudents();

    @GET("student/{id}")
    Call<StudentProfile> getStudentById(@Path("id") int id);

    @POST("student")
    Call<Void> createStudent(@Body StudentProfile student);

    @PUT("student/{id}")
    Call<Void> updateStudent(@Path("id") int id, @Body StudentProfile student);

    @DELETE("student/{id}")
    Call<Void> deleteStudent(@Path("id") int id);
}
