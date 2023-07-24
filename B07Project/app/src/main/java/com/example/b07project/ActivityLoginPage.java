package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import com.google.firebase.database.*;

public class ActivityLoginPage extends AppCompatActivity {

    //FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        //db = FirebaseDatabase.getInstance("https://b07-project-3237a-default-rtdb.firebaseio.com/");
    }

    public void onClickSignupPage(View view) {
        Button button = (Button) findViewById(R.id.buttonSignupPage);
        button.setOnClickListener(new View.OnClickListener() {
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

    public void onClickLoginShopper(View view) {

        // do the following only if user exists and password is right
        // to do

        Button button = (Button) findViewById(R.id.buttonLoginShopper);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopperView1();
            }
        });
    }

    public void openShopperView1() {
        Intent intent = new Intent(this, ActivityShopperView1.class);
        startActivity(intent);
    }

    public void onClickLoginOwner(View view) {
        // do the following only if user exists and password is right
        // to do

        Button button = (Button) findViewById(R.id.buttonLoginOwner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOwnerView1();
            }
        });
    }

    public void openOwnerView1() {
        Intent intent = new Intent(this, ActivityOwnerView1.class);
        startActivity(intent);
    }
}