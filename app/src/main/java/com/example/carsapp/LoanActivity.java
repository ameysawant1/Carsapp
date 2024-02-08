package com.example.carsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_page);

        // Initialize views
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView9 = findViewById(R.id.textView9);
        TextView textView10 = findViewById(R.id.textView10);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textView11 = findViewById(R.id.textView11);
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        Button button = findViewById(R.id.button);

        // Set text to TextViews
        textView8.setText("Text for TextView8");
        textView9.setText("Text for TextView9");
        textView10.setText("Text for TextView10");
        textView11.setText("Text for TextView11");

        // Set progress to SeekBars
        seekBar.setProgress(50);
        seekBar2.setProgress(25);

        // Set click listener to Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click event
            }
        });
    }
}
