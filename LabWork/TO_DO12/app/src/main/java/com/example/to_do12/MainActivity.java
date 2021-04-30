package com.example.to_do12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ImageView mDonut, mIceCream, mFroyo;
    private FloatingActionButton mCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDonut = (ImageView)findViewById(R.id.Donut);
        mIceCream = (ImageView)findViewById(R.id.IceCream);
        mFroyo = (ImageView)findViewById(R.id.Froyo);
    }

    public void Call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:17753724"));
        startActivity(callIntent);
    }

    public void Donut(View view) {
        Toast.makeText(this,"You have ordered Donut.", Toast.LENGTH_SHORT).show();
    }

    public void IceCream(View view) {
        Toast.makeText(this,"You have ordered Ice Cream.", Toast.LENGTH_SHORT).show();
    }

    public void Froyo(View view) {
        Toast.makeText(this,"You have ordered Froyo.", Toast.LENGTH_SHORT).show();
    }
}