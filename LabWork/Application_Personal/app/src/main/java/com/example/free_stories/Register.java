package com.example.free_stories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText mName, mEmail, mPassword, mConfirm;
    Button mbutton3;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseUser firebaseUser;
    String name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = (EditText) findViewById(R.id.name);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mConfirm = (EditText) findViewById(R.id.confirm);
        mbutton3 = (Button) findViewById(R.id.button3);
        fAuth = FirebaseAuth.getInstance();

        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateName() | !validateEmail() | !validatePassword()){
                    return;
                }
                else{
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("user");
                    String name = mName.getText().toString().trim();
                    String email = mEmail.getText().toString().trim();
                    String password = mPassword.getText().toString().trim();
                    HelperClass user1 = new HelperClass(name,email,password);
                    reference.child(name).setValue(user1);
                    fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener((task -> {
                        if(!task.isSuccessful()) {
                            Toast.makeText(Register.this, "Account not Registered. Please check your details.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            FirebaseUser user = fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnCompleteListener(Register.this, new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(Register.this, "Verification link has been sent to your Email. Please check your Email.", Toast.LENGTH_SHORT).show();
                                    Intent registerIntent = new Intent(getApplicationContext(), MainActivity.class);
                                    mName.setText("");
                                    mEmail.setText("");
                                    mPassword.setText("");
                                    mConfirm.setText("");
                                    startActivity(registerIntent);
                                }
                            });
                        }
                    }));
                }
            }
        });
    }

    private boolean validateName() {
        String val = mName.getText().toString().trim();
        if(val.isEmpty()){
            mName.setError("Name is required.");
            mName.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateEmail(){
        String val = mEmail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            mEmail.setError("Email is required.");
            mEmail.requestFocus();
            return false;
        }
       else if(!val.matches(checkEmail)){
            mEmail.setError("Please enter valid Email Address");
            mEmail.requestFocus();
            return false;
       }
        return true;
    }

    public boolean validatePassword(){
        String val = mPassword.getText().toString().trim();
        String val1 = mConfirm.getText().toString().trim();
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                        "(?=\\S+$)" +            // no white spaces
                        ".{4,}" +                // at least 4 characters
                        "$");

        if(val.isEmpty()){
            mPassword.setError("Password is required.");
            mPassword.requestFocus();
        }
        else if(val1.isEmpty()){
            mConfirm.setError("Confirm password is empty.");
            mConfirm.requestFocus();
        }
        else if(val.length() < 8){
            mPassword.setError("Password must be of atleast 6 character.");
            mPassword.requestFocus();
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(val).matches()){
            mPassword.setError("Password is weak.");
            mPassword.requestFocus();
            return false;
        }
        else if(!val.equals(val1)){
            mConfirm.setError("Confirm Password does not match.");
            mConfirm.requestFocus();
            return false;
        }
        return true;
    }
}
