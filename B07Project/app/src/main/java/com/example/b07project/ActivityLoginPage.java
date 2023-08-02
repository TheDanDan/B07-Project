package com.example.b07project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityLoginPage extends AppCompatActivity {

    FirebaseDatabase db;
    static String username; // used for passing username between activities

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        db = FirebaseDatabase.getInstance("https://b07-project-3237a-default-rtdb.firebaseio.com/");

        Button loginShopperButton = findViewById(R.id.buttonLoginShopper);
        loginShopperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLoginShopper(view);
            }
        });

        Button loginOwnerButton = findViewById(R.id.buttonLoginOwner);
        loginOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLoginOwner(view);
            }
        });
    }

    public void onClickSignupPage(View view) {
        openActivity(ActivityAccountType.class);
    }

    public void onClickLoginShopper(View view) {
        DatabaseReference ref = db.getReference();
        EditText userUsername = findViewById(R.id.editTextUsername);
        EditText userPassword = findViewById(R.id.editTextPassword);
        username = userUsername.getText().toString(); // NOTE: username updates the static variable
        String password = userPassword.getText().toString(); // parse both username and password into strings

        // get a snapshot of the database that checks if the given username exists (and extend to password for ease)
        DatabaseReference query = ref.child("Shoppers").child(username).child("password");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists() && password.equals(snapshot.getValue())) { // if username is valid AND password matches
                    openActivity(ActivityShopperView1.class); // proceed to next screen
                } else {
                    writeInvalid(); // otherwise give message that something is wrong
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void onClickLoginOwner(View view) {
        DatabaseReference ref = db.getReference();
        EditText userUsername = findViewById(R.id.editTextUsername);
        EditText userPassword = findViewById(R.id.editTextPassword);
        username = userUsername.getText().toString(); // NOTE: username updates the static variable
        String password = userPassword.getText().toString(); // parse both username and password into strings

        // get a snapshot of the database that checks if the given username exists (and extend to password for ease)
        DatabaseReference query = ref.child("Owners").child(username).child("password");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists() && password.equals(snapshot.getValue())) { // if username is valid AND password matches
                    openActivity(ActivityOwnerView1.class); // proceed to next screen
                } else {
                    writeInvalid(); // otherwise give message that something is wrong
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void openActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.putExtra("KEY_USERNAME", username); // pass static username to next
        startActivity(intent);
    }

    public void writeInvalid() {
        TextView msgError = findViewById(R.id.textViewErrorMsg);
        msgError.setText("*Invalid Username or Password");
    }
}