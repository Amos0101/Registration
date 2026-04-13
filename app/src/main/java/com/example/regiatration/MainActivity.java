package com.example.regiatration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    // Declare variables (class level)
    EditText firstName, secondName, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Mapping XML IDs to Java variables
        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
    }

    public void handleRegister(View view){

        String fName = firstName.getText().toString().trim();
        String sName = secondName.getText().toString().trim();
        String emailVal = email.getText().toString().trim();
        String phoneVal = phone.getText().toString().trim();

        // Basic validation
        if (fName.isEmpty() || sName.isEmpty() || emailVal.isEmpty() || phoneVal.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(fName, sName, emailVal, phoneVal);

        // Save to Firebase
        databaseReference.child(fName).setValue(user);

        Toast.makeText(this, "Saved to Firebase", Toast.LENGTH_SHORT).show();
    }

    public void handleCancel(View view){
        firstName.setText("");
        secondName.setText("");
        email.setText("");
        phone.setText("");

        Toast.makeText(this,"Form cleared",Toast.LENGTH_SHORT).show();

    }

    public void handleLogin(View view){
        Toast.makeText(this,"Go to login",Toast.LENGTH_SHORT).show();
    }





}

