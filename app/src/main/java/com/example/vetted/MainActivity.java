package com.example.vetted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        retrofitCall();

    }

    private void retrofitCall() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        YelpServiceCall yelpServiceAPI = retrofit.create(YelpServiceCall.class);
        final Call<BusinessSearch> businessSearchCall = yelpServiceAPI.getBusinessSearch("delis",-73.935242,40.730610);
        businessSearchCall.enqueue(new Callback<BusinessSearch>() {
            @Override
            public void onResponse(Call<BusinessSearch> call, Response<BusinessSearch> response) {

            }

            @Override
            public void onFailure(Call<BusinessSearch> call, Throwable t) {

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


}
