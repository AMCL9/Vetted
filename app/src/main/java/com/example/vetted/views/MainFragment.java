package com.example.vetted.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;


public class MainFragment extends Fragment implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    private ImageView imageView;


    private String mParam1;
    private String mParam2;

    private Fragmentinterface mListener;

    public MainFragment() {

    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = view.findViewById(R.id.main_fragment_searchview);
        searchView.setOnQueryTextListener(this);
        ToggleButton toggleButton = view.findViewById(R.id.toggle_button);
        imageView = view.findViewById(R.id.animal_main_view);
        Glide.with(this)
                .load(R.drawable.giphy2)
                .fitCenter()
                .into(imageView);
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }



}
