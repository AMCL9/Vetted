package com.example.vetted.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetted.R;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;


public class MapFragment extends Fragment implements OnMapReadyCallback {
 
    private double lat;
    private double lon;
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    SupportMapFragment mapFragment;
    private BusinessIdSharedPreferences businessIdSharedPreferences;
    private OnFragmentInteractionListener mListener;


    public MapFragment() {}

    public static MapFragment newInstance(double lat, double lon) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putDouble(LATITUDE, lat);
        args.putDouble(LONGITUDE, lon);
        fragment.setArguments(args);
/**
 * we will probably need to put other things into the bundle as we build other ways to navigate
 * to the map aside from the main fragment
 */
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            String latParam = getArguments().getString(LATITUDE);
            String lonParam = getArguments().getString(LONGITUDE);

            lat = Double.parseDouble(Objects.requireNonNull(latParam));
            lon = Double.parseDouble(Objects.requireNonNull(lonParam));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {

            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, mapFragment).commit();
            mapFragment = SupportMapFragment.newInstance();

        }
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coordinate = new LatLng(lat, lon);
        LatLng getLocation = new LatLng(lat, lon);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);
        CameraUpdate center = CameraUpdateFactory.newLatLng(coordinate);
        googleMap.addMarker(new MarkerOptions().position(getLocation).title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(getLocation));
        googleMap.moveCamera(center);
        googleMap.moveCamera(zoom);

        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
