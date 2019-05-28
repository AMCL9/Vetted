package com.example.vetted.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.RecyclerView.PetBusinessAdapter;
import com.example.vetted.modells.Businesses;
import com.example.vetted.network.AnimalBusinessRepository;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;


public class MapFragment extends Fragment implements OnMapReadyCallback {
    private RecyclerView spinnerMenuSelectionRecyclerView;
    ArrayList <Businesses> termRelatedBusinesses = new ArrayList<>();
    ArrayList <Businesses> newBusinesses = new ArrayList<>();
    private PetBusinessAdapter petBusinessAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Fragmentinterface fragmentinterface;

    private static final String LOGTAG = "TAGTAGTAG";
    public static final String BUSINESS_LIST = "businesslist";




    AnimalBusinessRepository animalBusinessRepository;

    public MapFragment() {}

    public static MapFragment newInstance(ArrayList<Businesses> Businesses) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(BUSINESS_LIST, Businesses);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            termRelatedBusinesses = getArguments().getParcelableArrayList(BUSINESS_LIST);
            Log.d("DINGALINGHEAD", "onCreate: " + termRelatedBusinesses.get(0).getName());
            Log.d("WEPA", "onCreate: " + termRelatedBusinesses.toString());



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
            fragmentinterface = (Fragmentinterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnerMenuSelectionRecyclerView = view.findViewById(R.id.business_recyclerView);
        layoutManager = new GridLayoutManager(getContext(),1);
        spinnerMenuSelectionRecyclerView.setLayoutManager(layoutManager);
        petBusinessAdapter = new PetBusinessAdapter(newBusinesses);
        spinnerMenuSelectionRecyclerView.setAdapter(petBusinessAdapter);
        newBusinesses.addAll(termRelatedBusinesses);
        petBusinessAdapter.setBusinesses(newBusinesses);
        spinnerMenuSelectionRecyclerView.setAdapter(petBusinessAdapter);




    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentinterface = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


    }

}
