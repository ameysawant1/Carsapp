package com.example.carsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Use a Handler to delay the execution of code
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the OnboardingActivity after the specified delay
                Intent onboardingIntent = new Intent(SplashActivity.this, OnboardingActivity.class);
                startActivity(onboardingIntent);

                // Finish the current activity to prevent going back to the splash screen
                finish();
            }
        }, 3000); // Delay for 3000 milliseconds (3 seconds)
    }
}
