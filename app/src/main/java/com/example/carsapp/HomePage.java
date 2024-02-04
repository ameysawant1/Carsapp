package com.example.carsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    private ArrayList<popularcarsmodel> arrPopularCars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RecyclerView popularCarsRecyclerView = findViewById(R.id.popularcars);
        RecyclerView popularCarsRecyclerView2 = findViewById(R.id.popularcars2);

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
    }
}
