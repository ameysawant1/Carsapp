package com.example.carsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if onboarding is already completed
        if (isOnboardingCompleted()) {
            startHomePage();
            finish(); // Finish the onboarding activity to prevent going back to it
        } else {
            // If not completed, show the onboarding layout
            setContentView(R.layout.activity_onboarding);

            Button btnContinueToMain = findViewById(R.id.btnContinueTologin);
            btnContinueToMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Mark onboarding as completed (optional)
                    markOnboardingAsCompleted();

                    // Move to the homepage
                    startHomePage();
                }
            });
        }
    }

    // Check if onboarding is completed by reading a value from SharedPreferences
    private boolean isOnboardingCompleted() {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        return preferences.getBoolean("onboarding_completed", false);
    }

    // Save the completion status to SharedPreferences when onboarding is finished
    private void markOnboardingAsCompleted() {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("onboarding_completed", true);
        editor.apply();
    }

    // Move to the HomePage
    private void startHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
