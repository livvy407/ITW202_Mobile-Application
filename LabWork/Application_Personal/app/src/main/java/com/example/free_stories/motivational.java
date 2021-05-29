package com.example.free_stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

public class motivational extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational);

    }

    public void motive1(View view) {
        startActivity(new Intent(motivational.this, motive_story1.class));
    }

    public void motive2(View view) {
        startActivity(new Intent(motivational.this, motive_story2.class));
    }

    public void motive3(View view) {
        startActivity(new Intent(motivational.this, motive_story3.class));
    }

    public void motive4(View view) {
        startActivity(new Intent(motivational.this, motive_story4.class));
    }
}