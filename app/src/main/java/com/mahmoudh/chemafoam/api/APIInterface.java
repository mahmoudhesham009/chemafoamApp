package com.mahmoudh.chemafoam.api;

import com.mahmoudh.chemafoam.model.FilteredData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("data")
    Call<FilteredData> getFilteredData(@Query("date") String date,
                                       @Query("shift") String shift,
                                       @Query("month") String month,
                                       @Query("week") int week,
                                       @Query("foamtype") String foamType);
}
