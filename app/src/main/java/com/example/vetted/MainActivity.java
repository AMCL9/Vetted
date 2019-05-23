package com.example.vetted;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.vetted.AutoComplete.AutoComplete;
import com.example.vetted.BusinessDetailsModels.BusinessDetailWrapper;
import com.example.vetted.BusinessReviews.ReviewWrapper;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.example.vetted.controller.RecyclerViewViewholder;
import com.example.vetted.modells.BusinessSearch;
import com.example.vetted.modells.Businesses;
import com.example.vetted.modells.Coordinates;
import com.example.vetted.network.RetrofitSingleton;
import com.example.vetted.network.YelpServiceCall;
import com.example.vetted.views.DetailsFragment;
import com.example.vetted.views.MainFragment;
import com.example.vetted.views.MapFragment;
import com.example.vetted.views.RecyclerViewFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Fragmentinterface, ActivityCompat.OnRequestPermissionsResultCallback {

    int played = 1;
    ImageView imageView;
    private SharedPreferences sharedPreferences;
    private BusinessIdSharedPreferences businessIdSharedPreferences;
    private Location lastLocation;
    private double longitude;
    private double latitude;
    private static String userInput = "";
    private static String passTerm = "";
    public static Double businessLat = 0.0;
    public static Double businessLong = 0.0;
    public static final String CATEGORIES = "petservices";
    public static ArrayList<Businesses> termRelateBusinesses;
    List<String> termArray = new ArrayList<>();
    Coordinates coordinates;
    /**
     * after we search we have to pass the term they've searched to the mainactivity from the mainfragment and input it for the search
     */

    private final String TAG = "BARKBARK";
    public static final int PERMISSIONS_REQUEST_LOCATION = 99;
    private static int SPLASH_TIME_OUT = 4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(BusinessIdSharedPreferences.SHARED_PREF_KEY, MODE_PRIVATE);
        businessIdSharedPreferences = new BusinessIdSharedPreferences(sharedPreferences);

        getSupportActionBar().hide();
        imageView = findViewById(R.id.splash_gif);
        getCurrentLocation();

        if (savedInstanceState == null) {
            AsyncTask<Void, Void, Void> task = new LoadingTask(this);
            task.execute();
        }


    }

    public void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
        } else {


            callBusinessDetails("WavvLdfdP6g8aZTtbBQHTw");
            callAutoCorrect();
            callReviews("WavvLdfdP6g8aZTtbBQHTw");

        }
    }


    public void callBusinessSearch() {

        Retrofit retrofit = RetrofitSingleton.getInstance();
        YelpServiceCall yelpServiceAPI = retrofit.create(YelpServiceCall.class);
        final Call<BusinessSearch> businessSearchCall = yelpServiceAPI.getBusinessSearch(passTerm,  longitude, latitude, CATEGORIES);
        businessSearchCall.enqueue(new Callback<BusinessSearch>() {
            @Override
            public void onResponse(@NonNull Call<BusinessSearch> call, @NonNull Response<BusinessSearch> response) {
                Log.d(TAG, "Business Search onResponse: " + response.body().getBusinesses().get(0));
                BusinessSearch businessSearch = response.body();


                if (businessSearch != null) {
                    List<Businesses> businessList = businessSearch.getBusinesses();
                    for (Businesses b : businessList) {
                        termRelateBusinesses = new ArrayList<>();

                        Log.d(TAG, "onResponse: " + b.getCoordinates().getLatitude().toString());
                        Log.d(TAG, "onResponse: " +b.getCoordinates().getLongitude().toString());
                        // if you check the logcat, you will see there the latitude for this business.
//
//                        businessIdSharedPreferences.saveBusinessID(identity, businessLat, businessLong);
                        termRelateBusinesses.add(b);
                        RecyclerViewViewholder.termResults.add(b);

                        Log.d(TAG, "BOSSY onResponse: " + RecyclerViewViewholder.termResults.get(0).getName());



                        Log.d(TAG, "business term list onResponse: " + termRelateBusinesses.get(0).getName());
                        /**
                         * going to use this list for the recycler view. we must also find a way to use a particular identity to make other network
                         * calls
                         */
                    }
                }

            }


            @Override
            public void onFailure(Call<BusinessSearch> call, Throwable t) {
                Log.d(TAG, "Business Search onFailure: " + t.getMessage());

            }
        });
    }

    /**
     * Need to pass in business ID from Business Search. Each business has a unique identifier.
     * Example: WavvLdfdP6g8aZTtbBQHTw
     *
     * @param businessId
     */
    private void callBusinessDetails(final String businessId) {
        RetrofitSingleton.getInstance()
                .create(YelpServiceCall.class)
                .getBusinessDetails(businessId)
                .enqueue(new Callback<BusinessDetailWrapper>() {
                    @Override
                    public void onResponse(Call<BusinessDetailWrapper> call, Response<BusinessDetailWrapper> response) {
                        Log.d(TAG, "Business Details onResponse: " + response.body());
                        BusinessDetailWrapper businessDetailWrapper = response.body();
                        if (businessDetailWrapper != null) {
                            businessIdSharedPreferences.saveBusinessDetails(
                                    businessDetailWrapper.getName(),
                                    businessDetailWrapper.getUrl(),
                                    businessDetailWrapper.getAlias(),
                                    businessDetailWrapper.getId(),
                                    businessDetailWrapper.getCoordinates(),
                                    businessDetailWrapper.getCategories(),
                                    businessDetailWrapper.getIs_closed(),
                                    businessDetailWrapper.getHours(),
                                    businessDetailWrapper.getRating(),

                                    businessDetailWrapper.getImage_url(),
                                    businessDetailWrapper.getRating(),
                                    businessDetailWrapper.getPrice());
//
                        }
                    }

                    @Override
                    public void onFailure(Call<BusinessDetailWrapper> call, Throwable t) {
                        Log.d(TAG, "Business Details onFailure:" + t.getMessage());

                    }
                });

    }

    private void callAutoCorrect() {
        RetrofitSingleton.getInstance()
                .create(YelpServiceCall.class)
                .getResults("delis", -73.935242, 40.730610)
                .enqueue(new Callback<AutoComplete>() {
                    @Override
                    public void onResponse(Call<AutoComplete> call, Response<AutoComplete> response) {
                        Log.d(TAG, "Autocomplete onResponse:" + response.body());

                    }

                    @Override
                    public void onFailure(Call<AutoComplete> call, Throwable t) {
                        Log.d(TAG, "Autocomplete onFailure: " + t.getMessage());

                    }
                });
    }

    /**
     * Requires business identifier. Gotten from Business Search
     * Example: WavvLdfdP6g8aZTtbBQHTw
     *
     * @param businessId
     */
    private void callReviews(String businessId) {
        RetrofitSingleton.getInstance()
                .create(YelpServiceCall.class)
                .getReviews(businessId)
                .enqueue(new Callback<ReviewWrapper>() {
                    @Override
                    public void onResponse(Call<ReviewWrapper> call, Response<ReviewWrapper> response) {
                        Log.d(TAG, "Reviews onResponse: " + response.body());

                    }

                    @Override
                    public void onFailure(Call<ReviewWrapper> call, Throwable t) {
                        Log.d(TAG, "Reviews onFailure: " + t.getMessage());

                    }
                });
    }

    @Override
    public void showMainFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .commit();

    }

    @Override
    public void showMapFragment(ArrayList<Businesses> termRelateBusinesses) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MapFragment.newInstance(termRelateBusinesses))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void showRecyclerViewFragment(ArrayList<Businesses> businessesList) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, RecyclerViewFragment.newInstance(businessesList))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void showDetailsFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailsFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void passBusinessSearch() {
        callBusinessSearch();

    }

    @Override
    public void passID(String id) {

    }

    @Override
    public String update(String passTerm) {
        return passTerm;

    }


    private class LoadingTask extends AsyncTask<Void, Void, Void> {
        Fragmentinterface fragmentinterface;
        private int count = 0;


        public LoadingTask(Fragmentinterface fragmentinterface) {
            this.fragmentinterface = fragmentinterface;


        }

        @Override
        protected void onPreExecute() {

            Glide.with(MainActivity.this)
                    .load(R.drawable.lagifgrande)
                    .into(imageView);
            count++;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            if (count == played) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        Glide.with(MainActivity.this)

                                .load(R.drawable.vetted)
                                .placeholder(R.drawable.vetted)
                                .into(imageView);
                        fragmentinterface.showMainFragment();

                    }
                }, SPLASH_TIME_OUT);


            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_LOCATION:
                if ((grantResults.length > 0) && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    final FusedLocationProviderClient fpc = LocationServices.getFusedLocationProviderClient(this);

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat
                            .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    fpc.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                lastLocation = location;
                                longitude = lastLocation.getLongitude();
                                Log.d(TAG, "onSuccess: "+lastLocation.getLatitude());
                                Log.d(TAG, "onSuccess: "+lastLocation.getLongitude());
                                latitude = lastLocation.getLatitude();
                                businessIdSharedPreferences.saveUserLocation(latitude, longitude);



                            } else {
                                Toast.makeText(MainActivity.this, "No Location Shown", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
                    Toast.makeText(this, "You need to grant access to your location for this app to run", Toast.LENGTH_LONG).show();
                }
        }
    }

   private String getUserInput () {
       sharedPreferences = getSharedPreferences(BusinessIdSharedPreferences.SHARED_PREF_KEY, MODE_PRIVATE);
       if (sharedPreferences != null) {
           userInput = sharedPreferences.getString(BusinessIdSharedPreferences.USER_INPUT, " ");


       }
       return userInput;

   }


}
