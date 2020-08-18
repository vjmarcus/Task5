package com.example.task5.models;

import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.task5.api.ApiFactory;
import com.example.task5.api.NewsApi;
import com.example.task5.data.Story;
import com.example.task5.data.StoryList;
import com.example.task5.listeners.ResponseListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainModel {

    private List<Story> storyList;
    private ResponseListener responseListener;

    private static final String TAG = "MyApp";

    public List<Story> loadStories(String key) {
        ApiFactory apiFactory = ApiFactory.getInstance();
        NewsApi newsApi = ApiFactory.getNewsApi();
        Call<StoryList> call = newsApi.getPostsByDate(key, ApiFactory.getCurrentDate(),
                ApiFactory.getCurrentDate(), 20, "en", ApiFactory.API_KEY);
        call.enqueue(new Callback<StoryList>() {
            @Override
            public void onResponse(@NonNull Call<StoryList> call, @NonNull Response<StoryList> response) {
                Log.d(TAG, "onResponse: " + response);
                StoryList articlesList = response.body();
                if (articlesList != null) {
                    storyList = articlesList.getArticles();
//                    initRecyclerViewClickListener();
//                    initRecycler();
//                    responseListener.responseReceived(true);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<StoryList> call, Throwable t) {
//                responseListener.responseReceived(false);
                Log.d(TAG, "loadStories onFailure: ERROR");
            }
        });
        return storyList;
    }
}
