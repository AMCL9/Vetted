package com.example.vetted.SharedPreferences;

import android.content.SharedPreferences;

import com.example.vetted.BusinessDetailsModels.Hours;
import com.example.vetted.modells.Categories;
import com.example.vetted.modells.Coordinates;
import com.google.android.gms.maps.model.LatLng;

import java.util.HashSet;
import java.util.Set;

public class BusinessIdSharedPreferences {
    public static final String SHARED_PREF_KEY = "Shared Preferences Key";
    public static final String ID_KEY = "ID";
    public static final String TEXT_KEY = "text";
    public static final String LATITUDE_KEY = "latitude";
    public static final String LONGITUDE_KEY = "longitude";
    public static final String USER_INPUT = "userinput";

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


    public void saveBusinessText(String text, double lat, double lon) {
        sharedPreferences.edit()
                .putString(TEXT_KEY, text)
                .putString(LATITUDE_KEY,Double.toString(lat))
                .putString(LONGITUDE_KEY, Double.toString(lon))
                .apply();
    }

    public void saveBusinessDetails(String name, String url, String alias, String id, Coordinates coordinates, Categories[] categories, boolean is_closed, Hours[] hours, String rating, String image_url, String rating1, String price) {
        sharedPreferences.edit()
                .putString("name", name)
                .putString("url", url)
                .putString("alias", alias)
                .putString("identifier", id)
                .putString(LATITUDE_KEY, String.valueOf(coordinates.getLatitude()))
                .putString(LONGITUDE_KEY, String.valueOf(coordinates.getLongitude()))
                .putString("title", categories[0].getTitle())
                .putBoolean("closed", is_closed)
                .putString("hour open", hours[0].getOpen()[0].getStart())
                .putString("hour closed", hours[0].getOpen()[0].getEnd())
                .putString("day", hours[0].getOpen()[0].getDay())
//                .putString("imageurl", image_url)
                .putString("rating", rating)
                .putString("price", price);

        /**
         *HashSet<String> set=new HashSet();
         **/
    }

    public void saveUserInput(String input) {
        sharedPreferences.edit()
                .putString(USER_INPUT, input);
    }

}





