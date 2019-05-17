package com.example.vetted;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.vetted.AutoComplete.AutoComplete;
import com.example.vetted.BusinessDetailsModels.BusinessDetailWrapper;
import com.example.vetted.BusinessReviews.ReviewWrapper;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.modells.BusinessSearch;
import com.example.vetted.network.RetrofitSingleton;
import com.example.vetted.network.YelpServiceCall;
import com.example.vetted.views.DetailsFragment;
import com.example.vetted.views.MainFragment;
import com.example.vetted.views.MapFragment;
import com.example.vetted.views.RecyclerViewFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Fragmentinterface {
    private static int SPLASH_TIME_OUT = 4000;
    int played = 1;
    ImageView imageView;
    private final String TAG = "BARKBARK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        imageView = findViewById(R.id.splash_gif);



       if (savedInstanceState == null) {
           AsyncTask<Void, Void, Void> task = new LoadingTask (this);
           task.execute();
       }


        callBusinessSearch();
       callBusinessDetails();
       callAutoCorrect();
       callReviews();
    }


    private void callBusinessSearch() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        YelpServiceCall yelpServiceAPI = retrofit.create(YelpServiceCall.class);
        final Call<BusinessSearch> businessSearchCall = yelpServiceAPI.getBusinessSearch("delis",-73.935242,40.730610);
        businessSearchCall.enqueue(new Callback<BusinessSearch>() {
            @Override
            public void onResponse(Call<BusinessSearch> call, Response<BusinessSearch> response) {
                Log.d(TAG, "onResponse: " + response.body());

            }


            @Override
            public void onFailure(Call<BusinessSearch> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    private void callBusinessDetails() {
        RetrofitSingleton.getInstance().create(YelpServiceCall.class).getBusinessDetails("WavvLdfdP6g8aZTtbBQHTw").enqueue(new Callback<BusinessDetailWrapper>() {
            @Override
            public void onResponse(Call<BusinessDetailWrapper> call, Response<BusinessDetailWrapper> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<BusinessDetailWrapper> call, Throwable t) {
                Log.d(TAG, "onFailure:" +t.getMessage());

            }
        });

    }

    private void callAutoCorrect() {
        RetrofitSingleton.getInstance().create(YelpServiceCall.class).getResults().enqueue(new Callback<AutoComplete>() {
            @Override
            public void onResponse(Call<AutoComplete> call, Response<AutoComplete> response) {
                Log.d(TAG, "onResponse:" +response.body());

            }

            @Override
            public void onFailure(Call<AutoComplete> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    private void callReviews() {
        RetrofitSingleton.getInstance().create(YelpServiceCall.class).getReviews().enqueue(new Callback<ReviewWrapper>() {
            @Override
            public void onResponse(Call<ReviewWrapper> call, Response<ReviewWrapper> response) {
                Log.d(TAG, "onResponse: " +response.body());

            }

            @Override
            public void onFailure(Call<ReviewWrapper> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

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
    public void showMapFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MapFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void showRecyclerViewFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, RecyclerViewFragment.newInstance())
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

    private class  LoadingTask extends AsyncTask<Void, Void, Void> {
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
                        Glide.with(MainActivity.this)
                                .load(R.drawable.vettedlogo)
                                .fitCenter()
                                .into(imageView);
                        fragmentinterface.showMainFragment();

                    }
                },SPLASH_TIME_OUT);



            }
        }
    }


}
