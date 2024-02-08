package com.example.carsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class HomePage extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;

    private final ArrayList<popularcarsmodel> arrPopularCars = new ArrayList<>();
    private TextView greetingTextView;
    private GridView carIconsGridView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.loan) {
            // Open LoanActivity when loan menu item is clicked
            startActivity(new Intent(this, LoanActivity.class));
            return true;
        } else if (id == R.id.home) {
            // Handle Home item click
            return true;
        } else if (id == R.id.compare) {
            // Handle Compare item click
            return true;
        } else if (id == R.id.menu) {
            // Handle Menu item click
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RecyclerView popularCarsRecyclerView = findViewById(R.id.popularcars);
        RecyclerView popularCarsRecyclerView2 = findViewById(R.id.popularcars2);
        greetingTextView = findViewById(R.id.greetings);
        carIconsGridView = findViewById(R.id.carIconsGridView); // Added GridView

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

        // Set the greeting text with emoji
        setGreetingText();

        // Set up car icons for the user to choose from
        setupCarIcons();
    }

    private void setGreetingText() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        // Determine the greeting based on the time
        String greeting;
        if (hourOfDay >= 0 && hourOfDay < 12) {
            greeting = "Good Morning";
        } else if (hourOfDay >= 12 && hourOfDay < 18) {
            greeting = "Good Afternoon";
        } else if (hourOfDay >= 18 && hourOfDay < 24) {
            greeting = "Good Evening";
        } else {
            greeting = "Good Night";
        }

        // Set the greeting text with emoji
        String emoji = getEmojiByUnicode(0x1F604); // Unicode for smiling face
        greetingTextView.setText(greeting + " " + emoji);
    }

    private void setupCarIcons() {
        // Create sample data for car icons
        Integer[] carIcons = {R.drawable.car, R.drawable.car2, R.drawable.car3};

        // Create and set the adapter for car icons
        CarIconsAdapter carIconsAdapter = new CarIconsAdapter(this, carIcons);
        GridView gridView = findViewById(R.id.carIconsGridView);
        gridView.setAdapter(carIconsAdapter);

        // Set item click listener for the GridView
        carIconsGridView.setOnItemClickListener((parent, view, position, id) -> {
            int selectedCarIcon = carIcons[position];

            Toast.makeText(this, "Selected Car Icon: " + selectedCarIcon, Toast.LENGTH_SHORT).show();
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

    private String getEmojiByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }
}
