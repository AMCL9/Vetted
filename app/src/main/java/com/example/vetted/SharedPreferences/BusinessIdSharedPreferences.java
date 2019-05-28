package com.example.vetted.SharedPreferences;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.vetted.BusinessDetailsModels.Hours;
import com.example.vetted.modells.Businesses;
import com.example.vetted.modells.Categories;
import com.example.vetted.modells.Coordinates;
import com.google.android.gms.maps.model.LatLng;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusinessIdSharedPreferences {

    public static final String TAG = "NULL?";
    public static final String SHARED_PREF_KEY = "Shared Preferences Key";
    public static final String ID_KEY = "ID";
    public static final String TEXT_KEY = "text";
    public static final String LATITUDE_KEY = "latitude";
    public static final String LONGITUDE_KEY = "longitude";
    public static final String USER_INPUT = "userinput";
    public static final String NAME_KEY = "name";
    public static final String URL_KEY = "url";
    public static final String ALIAS_KEY = "alias";
    public static final String IDENTIFIER_KEY = "identifier";
    public static final String TITLE_KEY = "title";
    public static final String CLOSED_KEY = "is closed";
    public static final String OPEN_HOUR_KEY = "open hour";
    public static final String CLOSED_HOUR_KEY = "hours closed";
    public static final String DAY_KEY = "day key";
    public static final String RATING_KEY ="rating key";
    public static final String PRICE_KEY = "price key";


    private final SharedPreferences sharedPreferences;

    public BusinessIdSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveUserLatLon(double lat, double lon){
        sharedPreferences.edit()
                .putString(LATITUDE_KEY, Double.toString(lat))
                .putString(LONGITUDE_KEY, Double.toString(lon))
                .apply();
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
        Log.d(TAG, "saveUserLocation: " +sharedPreferences.getString(LATITUDE_KEY,"0.0"));
    }


    public void saveBusinessText(String text, double lat, double lon) {
        sharedPreferences.edit()
                .putString(TEXT_KEY, text)
                .putString(LATITUDE_KEY,Double.toString(lat))
                .putString(LONGITUDE_KEY, Double.toString(lon))
                .apply();
        Log.d(TAG, "saveBusinessText: " + lat);
    }

    public void saveBusinessList (Set <Businesses> businessesSet) {

    }

    public void saveBusinessDetails(String name, String url, String alias, String id, Coordinates coordinates, Categories[] categories, boolean is_closed, Hours[] hours, String rating, String image_url, String rating1, String price) {
        sharedPreferences.edit()
                .putString(NAME_KEY, name)
                .putString(URL_KEY, url)
                .putString(ALIAS_KEY, alias)
                .putString(IDENTIFIER_KEY, id)
                .putString(LATITUDE_KEY, String.valueOf(coordinates.getLatitude()))
                .putString(LONGITUDE_KEY, String.valueOf(coordinates.getLongitude()))
                .putString(TITLE_KEY, categories[0].getTitle())
                .putBoolean(CLOSED_KEY, is_closed)
                .putString(OPEN_HOUR_KEY, hours[0].getOpen()[0].getStart())
                .putString(CLOSED_HOUR_KEY, hours[0].getOpen()[0].getEnd())
                .putString(DAY_KEY, hours[0].getOpen()[0].getDay())
//                .putString("imageurl", image_url)
                .putString(RATING_KEY, rating)
                .putString(PRICE_KEY, price)
                .apply();

        /**
         *HashSet<String> set=new HashSet();
         **/
    }

    public void saveUserInput(String input) {
        sharedPreferences.edit()
                .putString(USER_INPUT, input)
                .apply();
    }

}





