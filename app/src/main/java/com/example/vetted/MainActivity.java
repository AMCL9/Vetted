package com.example.vetted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vetted.FragmentController.Fragmentinterface;

public class MainActivity extends AppCompatActivity implements Fragmentinterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showMainFragment() {

    }
}
