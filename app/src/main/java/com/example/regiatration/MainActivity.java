package com.example.regiatration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables (class level)
    EditText firstName, secondName, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapping XML IDs to Java variables
        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
    }

    public void handleRegister(View view){
        String fName = firstName.getText().toString();
        String sName = secondName.getText().toString();
        String emailVal = email.getText().toString();
        String phoneVal = phone.getText().toString();

        Toast.makeText(this, "Register Clicked",Toast.LENGTH_SHORT).show();
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

