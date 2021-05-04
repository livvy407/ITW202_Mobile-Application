package com.example.to_do13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioButton SameDay, NextDay, PickUp;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered);

        SameDay = (RadioButton)findViewById(R.id.same_day);
        NextDay = (RadioButton)findViewById(R.id.next_day);
        PickUp = (RadioButton)findViewById(R.id.pick_day);
        header = (TextView)findViewById(R.id.message_label);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("list");

        header.setText(msg);

        Spinner spinner = findViewById(R.id.spinner);

        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.item_list, android.R.layout.simple_dropdown_item_1line);
        if(spinner != null){
            spinner.setAdapter(arrayAdapter);
        }
    }

    public void OrderedItem(View view) {
        boolean itemSelect = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.same_day:
            displayToast("Same day messenger delivery.");
            break;

            case R.id.next_day:
            displayToast("Next day ground delivery.");
            break;

            case R.id.pick_day:
            displayToast("Pick up.");
            break;
        }
    }

    private void displayToast(String pick_up) {
        Toast.makeText(getApplicationContext(),pick_up,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        displayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}