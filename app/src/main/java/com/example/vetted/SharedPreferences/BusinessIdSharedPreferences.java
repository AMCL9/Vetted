package com.example.vetted.SharedPreferences;

import android.content.SharedPreferences;

import com.example.vetted.BusinessDetailsModels.Hours;
import com.example.vetted.modells.Categories;
import com.example.vetted.modells.Coordinates;

public class BusinessIdSharedPreferences {
    public static final String SHARED_PREF_KEY = "Shared Preferences Key";
    public static final String ID_KEY = "ID";
    public static final String TEXT_KEY = "text";
    public static final String LATITUDE_KEY = "latitude";
    public static final String LONGITUDE_KEY = "longitude";

    private SharedPreferences sharedPreferences;

    public BusinessIdSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }


    public void saveBusinessID(String identifier, double lat, double lon) {
        sharedPreferences.edit()
                .putString(ID_KEY, identifier)
                .putString(LATITUDE_KEY, Double.toString(lat))
                .putString(LONGITUDE_KEY, Double.toString(lon))
                .apply();


    }

    public void saveUserLocation (double lat, double lon) {
        sharedPreferences.edit()
                .putString(LATITUDE_KEY, Double.toString(lat))
                .putString(LONGITUDE_KEY, Double.toString(lon))
                .apply();
    }

    public void saveBusinessDetails(String name, String url, String alias,
                                    String identifier, Coordinates coordinates,
                                    Categories categories, Boolean isClosed, Hours [] hours,
                                    String image_url, String rating, String price) {
        sharedPreferences.edit()
                .putString("name", name)
                .putString("url", url)
                .putString("alias", alias)
                .putString("identifier", identifier)
                .putString(
                .putString()

                //HashSet<String> set=new HashSet();
    }

    public void saveBusinessText(String text, double lat, double lon) {
        sharedPreferences.edit()
                .putString(TEXT_KEY, text)
                .putString(LATITUDE_KEY,Double.toString(lat))
                .putString(LONGITUDE_KEY, Double.toString(lon))
                .apply();
    }
}

