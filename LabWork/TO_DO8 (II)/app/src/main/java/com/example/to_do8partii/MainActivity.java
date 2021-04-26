package com.example.to_do8partii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tview = findViewById(R.id.textView1);
        Intent intent = getIntent();
        Uri message = intent.getData();
        if(message != null){
            String msg = message.toString();
            tview.setText(msg);
        }
    }
}