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
import com.example.vetted.BusinessDetailsModels.Hours;
import com.example.vetted.BusinessReviews.ReviewWrapper;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.example.vetted.modells.BusinessSearch;
import com.example.vetted.modells.Businesses;
import com.example.vetted.modells.Coordinates;
import com.example.vetted.network.AnimalBusinessRepository;
import com.example.vetted.network.RetrofitSingleton;
import com.example.vetted.network.YelpServiceCall;
import com.example.vetted.views.DetailsFragment;
import com.example.vetted.views.MainFragment;
import com.example.vetted.views.MapFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Fragmentinterface, ActivityCompat.OnRequestPermissionsResultCallback {

    int played = 1;
    ImageView imageView;
    private SharedPreferences sharedPreferences;
    private BusinessIdSharedPreferences businessIdSharedPreferences;
    private Location lastLocation;
    public static double longitude, latitude;
    public static double userLat, userLon = 0.0;
    private static String userInput = "";
    private final String TAG = "BARKBARK";
    public static final String LIST = "list";
    public static final String CATEGORIES = "petservices";
    public static ArrayList<Businesses> termRelateBusinesses;
    private ArrayList<Businesses> newBusinesses = new ArrayList<>();
    Coordinates coordinates;
    private AnimalBusinessRepository animalBusinessRepository = new AnimalBusinessRepository();
    public static final int PERMISSIONS_REQUEST_LOCATION = 99;
    private static int SPLASH_TIME_OUT = 4000;
    private String specificBusinessId =" ";


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



            callAutoCorrect();
            callReviews("WavvLdfdP6g8aZTtbBQHTw");

        }
    }


    public void callBusinessSearch() {

        animalBusinessRepository.getAllBusinesses(userInput, userLat, userLon, CATEGORIES, new Callback<BusinessSearch>() {

            @Override
            public void onResponse(@NonNull Call<BusinessSearch> call, @NonNull Response<BusinessSearch> response) {
                Log.d(TAG, "Business Search onResponse: " + response.body().getBusinesses().get(0));
                BusinessSearch businessSearch = response.body();

                Log.d(TAG, "lat "+userLat);
                Log.d(TAG, "lon "+ userLon);
                Log.d(TAG, "onResponse: "+userInput);


                if (businessSearch != null) {
                    ArrayList <Businesses> businessList = businessSearch.getBusinesses();

                    newBusinesses.addAll(businessList);
                    Log.d(TAG, "onResponse: " + newBusinesses.get(5).getName());
                    Log.d(TAG, "onResponse: " +newBusinesses.get(2).getName());
                }
                showMapFragment(newBusinesses);

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
    animalBusinessRepository.getBusinessDetails(businessId, new Callback<BusinessDetailWrapper>() {
        @Override
        public void onResponse(Call<BusinessDetailWrapper> call, Response<BusinessDetailWrapper> response) {
                        Log.d(TAG, "Business Details onResponse: " + response.body());
                        BusinessDetailWrapper businessDetailWrapper = response.body();
                        if (businessDetailWrapper != null) {
                            Log.d(TAG, "onResponse: "+businessDetailWrapper.getReview_count());
                           String image = businessDetailWrapper.getImage_url();
                           String [] otherImages = businessDetailWrapper.getPhotos();
                           String name = businessDetailWrapper.getName();
                           String alias = businessDetailWrapper.getAlias();
                           String phoneNumber = businessDetailWrapper.getPhone();
                           String rating = businessDetailWrapper.getRating();
                           Hours[] hours =businessDetailWrapper.getHours();
                           Boolean open = hours[0].getIs_open_now();
                           String price = businessDetailWrapper.getPrice();
                           String url = businessDetailWrapper.getUrl();

                            showDetailsFragment(image,otherImages,name,alias,phoneNumber,
                                    rating, open, price, url);


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
                .getResults("delis", 40.730610,-73.935242 )
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
    public void showMapFragment(ArrayList<Businesses> termRelatedBusinesses) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MapFragment.newInstance(termRelatedBusinesses))
                .addToBackStack(null)
                .commit();

    }



    @Override
    public void showDetailsFragment(String image, String [] otherImages, String name,
                                    String alias, String phoneNumber, String rating,
                                    Boolean open, String price, String url) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailsFragment.newInstance(image, otherImages,name,
                                                                            alias, phoneNumber, rating,
                                                                            open, price, url))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void passBusinessSearch() {
        callBusinessSearch();

    }

    @Override
    public void passBusiDetails() {
        callBusinessDetails(specificBusinessId);

    }

    @Override
    public String passID(String id) {
        specificBusinessId = id;
        return specificBusinessId;

    }

    @Override
    public String update(String passTerm) {
        userInput = passTerm;
        return userInput;

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
                    fpc.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                lastLocation = location;
                                longitude = lastLocation.getLongitude();
                                Log.d(TAG, "FPConSuccess: "+lastLocation.getLatitude());
                                Log.d(TAG, "FPConSuccess: "+lastLocation.getLongitude());
                                latitude = lastLocation.getLatitude();
                                getLat(latitude);
                                getLon(longitude);



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

       private double getLat (final double lat) {
        userLat = lat;

            return userLat;
       }
       private double getLon(final double lon) {
        userLon =lon;
        return userLon;
       }
   }



