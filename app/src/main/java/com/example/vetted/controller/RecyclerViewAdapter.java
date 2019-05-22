package com.example.vetted.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.modells.Businesses;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewholder> {
    List<Businesses> objects;
    private Fragmentinterface listener;

    public RecyclerViewAdapter(List<Businesses> objects, Fragmentinterface listener) {
        this.objects = objects;
        this.listener = listener;
    }

    public void setObjects(List<Businesses> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_itemview, viewGroup, false);
        return new RecyclerViewViewholder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewholder recyclerViewViewholder, int i) {
        recyclerViewViewholder.onBind(objects.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
