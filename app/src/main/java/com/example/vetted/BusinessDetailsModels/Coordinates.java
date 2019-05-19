package com.example.vetted.BusinessDetailsModels;


import java.util.HashSet;
import java.util.Set;

public class Coordinates {

    public Coordinates() {


    }

    private String latitude;

    private String longitude;

    public Set<String> getLatAndLong() {
        Set <String> latAndLong = new HashSet<>();
        latAndLong.add(getLatitude());
        latAndLong.add(getLongitude());
        return latAndLong;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ClassPojo [latitude = " + latitude + ", longitude = " + longitude + "]";
    }
}
