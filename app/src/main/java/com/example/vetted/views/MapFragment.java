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

import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.example.vetted.modells.Businesses;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MapFragment extends Fragment implements OnMapReadyCallback {
 
    private double lat;
    private double lon;
    private String name;

    public static final String BUSINESSES = "businesses";
    SupportMapFragment mapFragment;
    private BusinessIdSharedPreferences businessIdSharedPreferences;
    private Fragmentinterface mListener;
    private List<Businesses> getBusinesses = new ArrayList<>();


    public MapFragment() {}

    public static MapFragment newInstance(ArrayList<Businesses> termRelatedBusinesses) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(BUSINESSES, termRelatedBusinesses);

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
            getBusinesses = getArguments().getParcelableArrayList(BUSINESSES);

            }
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragmentinterface) {
            mListener = (Fragmentinterface) context;
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


}
