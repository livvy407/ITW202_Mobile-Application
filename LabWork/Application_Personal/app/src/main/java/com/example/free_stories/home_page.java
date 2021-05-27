package com.example.free_stories;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class home_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mDrawerlayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.dashboardtoolbar);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, toolbar, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navigation_view);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_share:
                startActivity(new Intent(getApplicationContext(), share.class));
                break;

            case R.id.nav_rateus:
                startActivity(new Intent(getApplicationContext(), rateus.class));
                break;

            case R.id.nav_aboutus:
                startActivity(new Intent(getApplicationContext(), aboutus.class));
                break;

            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(), logout.class));
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void motive(View view) {
        startActivity(new Intent(home_page.this, motivational.class));
    }
}