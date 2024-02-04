package com.example.carsapp;

public class popularcarsmodel {
    int carimage;
    String carname, carprice, carlocation;

    public popularcarsmodel(int carimage, String carname, String carprice, String carlocation) {
        this.carname = carname;
        this.carprice = carprice;
        this.carlocation = carlocation;
        this.carimage = carimage;
    }

    public int getCarImageResource() {
        return carimage;
    }

    public String getCarName() {
        return carname;
    }

    public String getCarPrice() {
        return carprice;
    }

    public String getCarLocation() {
        return carlocation;
    }
}
