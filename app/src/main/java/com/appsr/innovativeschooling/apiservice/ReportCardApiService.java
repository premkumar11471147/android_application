package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.ReportCard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReportCardApiService {
    @GET("report_cards")
    Call<List<ReportCard>> getAllReportCards();

    @GET("report_cards/{id}")
    Call<ReportCard> getReportCardById(@Path("id") int id);

    @POST("report_cards")
    Call<Void> createReportCard(@Body ReportCard reportCard);

    @PUT("report_cards/{id}")
    Call<Void> updateReportCard(@Path("id") int id, @Body ReportCard reportCard);

    @DELETE("report_cards/{id}")
    Call<Void> deleteReportCard(@Path("id") int id);
}
