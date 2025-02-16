package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.StudentPersonalProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentPersonalApiService {
    @GET("student_personal_profiles")
    Call<List<StudentPersonalProfile>> getAllStudentPersonalProfiles();

    @GET("student_personal_profiles/{id}")
    Call<StudentPersonalProfile> getStudentPersonalProfileById(@Path("id") int id);

    @POST("student_personal_profiles")
    Call<Void> createStudentPersonalProfile(@Body StudentPersonalProfile profile);

    @PUT("student_personal_profiles/{id}")
    Call<Void> updateStudentPersonalProfile(@Path("id") int id, @Body StudentPersonalProfile profile);

    @DELETE("student_personal_profiles/{id}")
    Call<Void> deleteStudentPersonalProfile(@Path("id") int id);
}

