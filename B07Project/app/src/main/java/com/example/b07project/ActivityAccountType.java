package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAccountType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);
    }

    public void onClickCreateShopper(View view) {
        Button button = (Button) findViewById(R.id.buttonCreateShopper);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateShopper();
            }
        });
    }

    public void openCreateShopper() {
        Intent intent = new Intent(this, ActivityCreateShopper.class);
        startActivity(intent);
    }

    public void onClickCreateOwner(View view) {
        Button button = (Button) findViewById(R.id.buttonCreateOwner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateOwner();
            }
        });
    }
    public void openCreateOwner() {
        Intent intent = new Intent(this, ActivityCreateOwner.class);
        startActivity(intent);
    }

    // adding ppl method
}