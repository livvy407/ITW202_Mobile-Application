package com.example.to_do11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mtextview;
    private Button ChangeColor;

    private String []color = {"purple_200", "purple_500", "purple_700", "teal_200", "teal_700",
                                "black", "white", "yellow", "snow", "floralwhite", "gold",
                                "orange", "lightsalmon", "darkorange", "coral", "hotpink",
                                "tomato", "orangered", "deeppink", "fuchdia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextview = (TextView)findViewById(R.id.textview);
        ChangeColor = (Button)findViewById(R.id.button);

        ChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String colorName = color[random.nextInt(20)];

                int ColorResourceName = getResources().getIdentifier(colorName, "color",getApplication().getPackageName());

                int ColorRes = ContextCompat.getColor(getApplicationContext(), ColorResourceName);
                mtextview.setTextColor(ColorRes);
            }
        });
    }
}