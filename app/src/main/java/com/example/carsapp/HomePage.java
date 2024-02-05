package com.example.carsapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;

    private ArrayList<popularcarsmodel> arrPopularCars = new ArrayList<>();
    private RecyclerView popularCarsRecyclerView;
    private RecyclerView popularCarsRecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        popularCarsRecyclerView = findViewById(R.id.popularcars);
        popularCarsRecyclerView2 = findViewById(R.id.popularcars2);

        // Set up the layout manager for the first RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularCarsRecyclerView.setLayoutManager(layoutManager);

        // Set up a new layout manager for the second RecyclerView
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularCarsRecyclerView2.setLayoutManager(layoutManager2);

        // Create sample data for popular cars
        popularcarsmodel popularCar1 = new popularcarsmodel(R.drawable.car, "Rs100", "Model X", "Mumbai");
        popularcarsmodel popularCar2 = new popularcarsmodel(R.drawable.car2, "Rs150", "Model Y", "Delhi");
        popularcarsmodel popularCar3 = new popularcarsmodel(R.drawable.car3, "Rs120", "Model Z", "Bangalore");

        // Add popular cars to the list
        arrPopularCars.add(popularCar1);
        arrPopularCars.add(popularCar2);
        arrPopularCars.add(popularCar3);

        // Create and set the adapter
        PopularCarsAdapter adapter = new PopularCarsAdapter(arrPopularCars);
        popularCarsRecyclerView.setAdapter(adapter);
        popularCarsRecyclerView2.setAdapter(adapter);

        // Set onClickListener for location icon
        ImageButton locationButton = findViewById(R.id.locationicon);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check and request location permission
                checkLocationPermission();
            }
        });
    }

    private void checkLocationPermission() {
        // Check if the app has location permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, proceed with location updates
            requestLocationUpdates();
        } else {
            // Request location permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    private void requestLocationUpdates() {
        // Implement location update logic here
        // You can use the code from the previous response to handle location updates
        // Make sure to handle onResume and onPause for starting and stopping location updates
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Location permission granted, proceed with location updates
                requestLocationUpdates();
            } else {
                // Location permission denied
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
