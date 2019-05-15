package com.example.vetted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.views.DetailsFragment;
import com.example.vetted.views.MainFragment;
import com.example.vetted.views.MapFragment;
import com.example.vetted.views.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity implements Fragmentinterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

git

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
