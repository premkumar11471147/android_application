package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.ExamTimeTable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ExamTimeTableApiService {
    @GET("exam_time_table")
    Call<List<ExamTimeTable>> getAllExamTimeTables();

    @GET("exam_time_table/{id}")
    Call<ExamTimeTable> getExamTimeTableById(@Path("id") int id);

    @POST("exam_time_table")
    Call<Void> createExamTimeTable(@Body ExamTimeTable timeTable);

    @PUT("exam_time_table/{id}")
    Call<Void> updateExamTimeTable(@Path("id") int id, @Body ExamTimeTable timeTable);

    @DELETE("exam_time_table/{id}")
    Call<Void> deleteExamTimeTable(@Path("id") int id);
}

