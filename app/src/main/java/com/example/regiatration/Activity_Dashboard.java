package com.example.regiatration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.*;

public class Activity_Dashboard extends AppCompatActivity {

    TextView tvFirstName, tvSecondName, tvEmail, tvPhone;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_dashboard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Initializing
        tvFirstName = findViewById(R.id.tvFirstName);
        tvSecondName = findViewById(R.id.tvSecondName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    User user = dataSnapshot.getValue(User.class);

                    if (user != null) {
                        tvFirstName.setText(user.getFirstName());
                        tvSecondName.setText(user.getSecondName());
                        tvEmail.setText(user.getEmail());
                        tvPhone.setText(user.getPhone());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(Activity_Dashboard.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}