package com.example.vetted.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vetted.MainActivity;
import com.example.vetted.R;
import com.example.vetted.modells.Businesses;
import com.example.vetted.views.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecyclerViewViewholder extends RecyclerView.ViewHolder {

    private TextView name;
    public static List<Businesses> termResults = new ArrayList<>();
    private RecyclerViewFragment.OnFragmentInteractionListener listener;

    public RecyclerViewViewholder(@NonNull View itemView, RecyclerViewFragment.OnFragmentInteractionListener listener) {
        super(itemView);
        this.listener = listener;
        name = itemView.findViewById(R.id.names);


    }


    public void onBind(final Businesses objects, final RecyclerViewFragment.OnFragmentInteractionListener listener){
        name.setText(termResults.get(0).getId());

    }
}
