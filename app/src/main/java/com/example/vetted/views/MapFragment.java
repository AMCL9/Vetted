package com.example.vetted.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetted.R;


public class MapFragment extends Fragment {
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";





    private OnFragmentInteractionListener mListener;

    public MapFragment() {

    }


    public static MapFragment newInstance(double lat, double lon) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle;
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

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
