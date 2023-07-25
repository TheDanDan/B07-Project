package com.example.b07project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

public class ActivityAccountType extends AppCompatActivity {
    TextView textView;

    EditText usernameInput;
    EditText passwordInput;
    Button btnInsertData;
    DatabaseReference ref;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);
    }

    public void onClickCreateShopper(View view) {
        usernameInput = (EditText) findViewById(R.id.editTextUsernameSignup);
        passwordInput = (EditText) findViewById(R.id.editTextPasswordSignup);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("Shoppers");

        btnInsertData = findViewById(R.id.buttonCreateShopper);

        // getting username and password to a string
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertShopper();
            }
        });

    }

    private void insertShopper() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(ActivityAccountType.this, "You must enter a username or password!", Toast.LENGTH_SHORT).show();
            return;
        }
        checkExists(username);
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ref.child(username).child("password").setValue(password);
                Toast.makeText(ActivityAccountType.this, "Your account has been made!", Toast.LENGTH_SHORT).show();
                usernameInput.getText().clear();
                passwordInput.getText().clear();
                return;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ActivityAccountType.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClickCreateOwner(View view) {
        usernameInput = (EditText) findViewById(R.id.editTextUsernameSignup);
        passwordInput = (EditText) findViewById(R.id.editTextPasswordSignup);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("Owners");

        btnInsertData = findViewById(R.id.buttonCreateOwner);

        // getting username and password to a string
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertOwner();
            }
        });
    }

    private void insertOwner() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(ActivityAccountType.this, "You must enter a username or password!", Toast.LENGTH_SHORT).show();
            return;
        }

        checkExists(username);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ref.child(username).child("password").setValue(password);
                Toast.makeText(ActivityAccountType.this, "Your account has been made!", Toast.LENGTH_SHORT).show();
                usernameInput.getText().clear();
                passwordInput.getText().clear();
                return;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ActivityAccountType.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkExists(String username) {
        ref.orderByKey().equalTo(username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Toast.makeText(ActivityAccountType.this, "Your account already exists!", Toast.LENGTH_SHORT).show();
                    throw new RuntimeException();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ActivityAccountType.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

