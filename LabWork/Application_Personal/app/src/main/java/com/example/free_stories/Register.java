package com.example.free_stories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText mName, mEmail, mPassword, mConfirm;
    Button mbutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = (EditText)findViewById(R.id.editText3);
        mEmail = (EditText)findViewById(R.id.editText4);
        mPassword = (EditText)findViewById(R.id.editText5);
        mConfirm = (EditText)findViewById(R.id.editText6);
        mbutton3 = (Button)findViewById(R.id.button3);

        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String name = mName.getText().toString().trim();
                 String email = mEmail.getText().toString().trim();
                 String password = mPassword.getText().toString().trim();
                 String confirm_password = mConfirm.getText().toString().trim();

                 if(TextUtils.isEmpty(email)){
                     mEmail.setError("Email is Required.");
                 }
            }
        });
    }

}