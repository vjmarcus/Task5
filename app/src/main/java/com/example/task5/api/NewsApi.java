package com.example.task5.api;

import com.example.task5.data.StoryList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("everything")
    Call <StoryList>  getPostsByDate(@Query("q") String key,
                                     @Query("from") String fromDate,
                                     @Query("to") String toDate,
                                     @Query("pageSize") int pageSize,
                                     @Query("language") String language,
                                     @Query("apiKey") String apiKey);
}
