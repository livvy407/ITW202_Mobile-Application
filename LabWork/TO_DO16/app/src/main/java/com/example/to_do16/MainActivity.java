package com.example.to_do16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mWordList=new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0 ; i<20 ; i++){
            mWordList.addLast("word"+ i);
        }
        mRecyclerView=findViewById(R.id.recycleview);
        mAdapter=new WordListAdapter(this,mWordList);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager obj=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(obj);
        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize=mWordList.size();
                mWordList.addLast("+Word"+wordListSize);
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                mRecyclerView.smoothScrollToPosition(wordListSize);

            }
        });
    }
}