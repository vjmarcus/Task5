package com.example.task5.presenters;

import android.util.Log;

import com.example.task5.R;
import com.example.task5.data.Story;
import com.example.task5.models.MainModel;
import com.example.task5.views.MainView;

import java.util.List;

public class MainPresenter {

    private static final String SOFTWARE = "software";
    private static final String ANDROID = "android";
    private static final String SCIENCE = "science";
    private static final String TECHNOLOGY = "technology";
    private static final String BITCOIN = "bitcoin";
    private static final String TAG = "MyApp";

    private MainView mainView;
    private MainModel mainModel;

    private List<Story> storyList;

    public MainPresenter(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void attachView(MainView mainView) {
        this.mainView = mainView;
    }

    public void itemClicked(String key) {
        storyList.clear();
        storyList = mainModel.loadStories(key);
        Log.d(TAG, "itemClicked presenter");
    }
}
