package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityShopperView1 extends AppCompatActivity {

    static String username; //will be passed from previous activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_view1);

        Intent receiverIntent = getIntent(); //These lines receive the string from previous activity
        username = receiverIntent.getStringExtra("KEY_USERNAME"); //AND update username to match

        TextView msgWelcome = (TextView) findViewById(R.id.textViewWelcomeTestShopper); //THESE LINES ARE PURELY FOR TESTING
        msgWelcome.setText("Welcome " + username + "!");                                //FEEL FREE TO REMOVE LATER ! :-)
    }
}