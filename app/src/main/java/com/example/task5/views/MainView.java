package com.example.task5.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.task5.R;
import com.example.task5.adapter.StoryAdapter;
import com.example.task5.data.Story;
import com.example.task5.listeners.RecyclerViewClickListener;
import com.example.task5.listeners.ResponseListener;
import com.example.task5.models.MainModel;
import com.example.task5.presenters.MainPresenter;

import java.util.List;

public class MainView extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String SOFTWARE = "software";
    private static final String ANDROID = "android";
    private static final String SCIENCE = "science";
    private static final String TECHNOLOGY = "technology";
    private static final String BITCOIN = "bitcoin";
    private static final String TAG = "MyApp";
    private Spinner spinner;
    private List<Story> storyList;
    private RecyclerViewClickListener recyclerViewClickListener;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ResponseListener responseListener;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        mainPresenter = new MainPresenter(new MainModel());
        mainPresenter.attachView(this);
        initSpinner();
//        initRecycler();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //DO NOTHING
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getSelectedItem() != null)
        mainPresenter.itemClicked(adapterView.getSelectedItem().toString());
    }

    private void initRecycler(List <Story> storyList) {
        RecyclerView recyclerView = findViewById(R.id.story_recycler);
        StoryAdapter storyAdapter = new StoryAdapter(storyList, recyclerViewClickListener);
        recyclerView.setAdapter(storyAdapter);
    }

    private void initSpinner() {
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<?> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.topics,
                android.R.layout.simple_list_item_1);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }
}