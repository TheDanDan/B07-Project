package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ActivityAccountType extends AppCompatActivity {
    TextView textView2;

    EditText usernameInput;
    EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);

        usernameInput = (EditText) findViewById(R.id.editTextUsernameSignup);
        passwordInput = (EditText) findViewById(R.id.editTextPasswordSignup);
    }

    public void onClickCreateShopper(View view) {
        // to do
        // open ref Shopper
        // put products under user in the firebase
        // Retrieve the username and password input

        textView2.setText(usernameInput.getText());
        System.out.println("Button clicked");

    }

    public void onClickCreateOwner(View view) {
        // to do
        // open ref to Owner
    }

    // adding ppl method
}