package com.example.vetted.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.example.vetted.modells.Businesses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainFragment extends Fragment implements SearchView.OnQueryTextListener {
    private Button mapFragmentButton;
    private SearchView searchView;
    private ImageView imageView;
    private TextView textView;
    BusinessIdSharedPreferences businessIdSharedPreferences;
    private static final String TAG = "WHY ARE U NULL?";

    public ArrayList<Businesses> businessesList;
    public static final String LIST_PARAM = "list";


    private Fragmentinterface mListener;

    public MainFragment() {

    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            businessIdSharedPreferences = new BusinessIdSharedPreferences(getActivity().getSharedPreferences(businessIdSharedPreferences.USER_INPUT, Context.MODE_PRIVATE));
            businessesList = getArguments().getParcelableArrayList(LIST_PARAM);


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
        Switch switchtoggle = view.findViewById(R.id.switch1);
        imageView = view.findViewById(R.id.animal_main_view);
        mapFragmentButton = view.findViewById(R.id.go);
        mapFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.showMapFragment(businessesList);


            }
        });
        Glide.with(this)
                .load(R.drawable.finalvettedtransroundcopy)
                .fitCenter()
                .circleCrop()
                .into(imageView);
        searchView.setOnQueryTextListener(this);
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
        query = searchView.getQuery().toString();
        if (query.length() > 0) {
            businessIdSharedPreferences.saveUserInput(query);

            Log.d(TAG, "onQueryTextSubmit: " + query);
        }
        return false;
    }

    /**
     * do we amend, hospital or clinic to our search term here?
     *
     * @param newText
     * @return
     */


    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


}
