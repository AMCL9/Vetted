package com.example.vetted.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetted.R;
import com.example.vetted.modells.Businesses;

import java.util.ArrayList;
import java.util.List;


public class PetBusinessAdapter extends RecyclerView.Adapter<PetBusinessViewholder> {
    private List<Businesses> businesses;


    public PetBusinessAdapter(ArrayList<Businesses> businesses) {
        this.businesses = businesses;
    }

    public void setBusinesses(ArrayList<Businesses> businesses) {
        this.businesses = businesses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PetBusinessViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.business_itemview, viewGroup, false);
        return new PetBusinessViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetBusinessViewholder recyclerViewViewholder, int i) {
        recyclerViewViewholder.onBind(businesses.get(i));
    }

    @Override
    public int getItemCount() {
        return businesses.size();
    }
}
