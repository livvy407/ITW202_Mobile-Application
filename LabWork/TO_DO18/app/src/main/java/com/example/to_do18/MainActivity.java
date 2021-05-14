package com.example.to_do18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportData;
    private SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSportData = new ArrayList<>();
        mAdapter = new SportAdapter(this, mSportData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.sports_image);
        String[] sportList = getResources().getStringArray(R.array.sports_titles);
        String[] sportInfo = getResources().getStringArray(R.array.sports_info);

        mSportData.clear();

        for(int i=0; i<sportList.length; i++){
            mSportData.add(new Sport(sportList[i],sportInfo[i], sportImageResources.getResourceId(i, 0)));
        }

        mAdapter.notifyDataSetChanged();
        sportImageResources.recycle();
    }
}