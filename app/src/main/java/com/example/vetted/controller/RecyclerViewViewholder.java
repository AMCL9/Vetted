package com.example.vetted.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vetted.R;
import com.example.vetted.modells.Businesses;
import com.example.vetted.views.RecyclerViewFragment;

public class RecyclerViewViewholder extends RecyclerView.ViewHolder {

    private TextView name;
    private RecyclerViewFragment.OnFragmentInteractionListener listener;

    public RecyclerViewViewholder(@NonNull View itemView, RecyclerViewFragment.OnFragmentInteractionListener listener) {
        super(itemView);
        this.listener = listener;
        name = itemView.findViewById(R.id.names);
    }

    public void onBind(final Businesses objects, final RecyclerViewFragment.OnFragmentInteractionListener listener){
        name.setText(objects.getName());

    }
}
