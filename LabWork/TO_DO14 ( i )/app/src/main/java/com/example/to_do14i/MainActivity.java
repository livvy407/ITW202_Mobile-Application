package com.example.to_do14i;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.to_do14i.MESSAGE";
    public static final String LOG = MainActivity.class.getName();
    private ImageView mDonut, mIceCream, mFroyo;
    FloatingActionButton floatingActionButton;
    String list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDonut = (ImageView)findViewById(R.id.Donut);
        mIceCream = (ImageView)findViewById(R.id.IceCream);
        mFroyo = (ImageView)findViewById(R.id.Froyo);

        Toolbar toolbar = findViewById(R.id.toollbar);
        setSupportActionBar(toolbar);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OrderedActivity.class);
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });
    }

    public void Donut(View view) {
        String donut = "You ordered a donut";
        list = donut;
        Toast.makeText(this,"You ordered a donut",Toast.LENGTH_SHORT).show();
    }

    public void IceCream(View view) {
        String ice = "You ordered a ice cream";
        list = ice;
        Toast.makeText(this,"You ordered a ice cream",Toast.LENGTH_SHORT).show();
    }

    public void Froyo(View view) {
        String froyo = "You ordered a froyo";
        list = froyo;
        Toast.makeText(this,"You ordered a froyo",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.Order:
                Intent intent = new Intent(getApplicationContext(),OrderedActivity.class);
                intent.putExtra("list", list);
                startActivity(intent);
                return true;

            case R.id.Status:
                displayToast("You selected Status");
                return true;

            case R.id.Favourite:
                displayToast("You Selected Favourite");
                return true;

            case R.id.Contact:
                displayToast("You Selected Contact");
                return true;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void displayToast(String pick_up) {
        Toast.makeText(getApplicationContext(),pick_up,Toast.LENGTH_LONG).show();
    }
}