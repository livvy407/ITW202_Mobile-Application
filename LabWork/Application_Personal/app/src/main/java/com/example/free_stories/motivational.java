package com.example.free_stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

public class motivational extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational);

        // get the list of stories title and contents in string array.

        String[] titles = getResources().getStringArray(R.array.stories_title);
        String[] contents = getResources().getStringArray(R.array.story_content);

        recyclerView = findViewById(R.id.storiesListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //our adapter takes two string array
        adapter = (Adapter) new com.example.free_stories.Adapter(this, titles, contents);

    }
}