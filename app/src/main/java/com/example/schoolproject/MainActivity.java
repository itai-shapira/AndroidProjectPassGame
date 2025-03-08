package com.example.schoolproject;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btUserDetails;
    Button btUsers;
    Button btIntroActivity;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btUserDetails = findViewById(R.id.btUserDetails);
        btUsers = findViewById(R.id.btUsers);
        btIntroActivity = findViewById(R.id.btIntroActivity);
        tvWelcome = findViewById(R.id.tvWelcome);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        tvWelcome.setText("Welcome " + sharedPreferences.getString("username", "DefaultName"));


        btIntroActivity.setOnClickListener(new View.OnClickListener() {
            // Logs out and navigates to the Intro screen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(intent);
            }
        });
        btUserDetails.setOnClickListener(new View.OnClickListener() {
            // Navigates to the User Details screen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserDetailsActivity.class);
                startActivity(intent);
            }
        });

        btUsers.setOnClickListener(new View.OnClickListener() {
            // Navigates to the Users screen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UsersActivity.class);
                startActivity(intent);
            }
        });
    }
}