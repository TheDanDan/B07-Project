package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.*;

public class ActivityLoginPage extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        db = FirebaseDatabase.getInstance("https://b07-project-3237a-default-rtdb.firebaseio.com/");
    }

    public void onClickSignupPage(View view) {
        Button buttonCreate = (Button) findViewById(R.id.buttonSignupPage);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAccountType();
            }
        });
    }

    public void openActivityAccountType() {
        Intent intent = new Intent(this, ActivityAccountType.class);
        startActivity(intent);
    }

    public void onClickLogin(View view) {
        // to do
    }
}