package com.example.vetted.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Switch;

import com.bumptech.glide.Glide;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.example.vetted.modells.Businesses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment implements SearchView.OnQueryTextListener {
    private Button mapFragmentButton;
    private SearchView searchView;
    private ImageView imageView;
    BusinessIdSharedPreferences businessIdSharedPreferences;
    private SharedPreferences sharedPreferences;


    public static final String LIST_PARAM = "list";
    public List<Businesses> businessesList = new ArrayList<>();

    private Fragmentinterface mListener;

    public MainFragment() {

    }


    public static MainFragment newInstance(List <Businesses> termRelatedBusinesses) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle ();
        args.putSerializable(LIST_PARAM, (Serializable) termRelatedBusinesses);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            businessesList = (List<Businesses>) getArguments().getSerializable(LIST_PARAM);


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
        Switch switchtoggle = view.findViewById(R.id.switch1);
        imageView = view.findViewById(R.id.animal_main_view);
        mapFragmentButton = view.findViewById(R.id.go);
        mapFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mListener.showMapFragment((ArrayList<Businesses>) businessesList);


            }
        });
        Glide.with(this)
                .load(R.drawable.finalvettedtransroundcopy)
                .fitCenter()
                .circleCrop()
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
        businessIdSharedPreferences.saveUserInput(query);
        return false;
    }

    /**
     * do we amend, hospital or clinic to our search term here?
     * @param newText
     * @return
     */

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }



}
