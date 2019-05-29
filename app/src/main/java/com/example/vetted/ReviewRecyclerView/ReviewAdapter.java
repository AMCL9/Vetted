package com.example.vetted.ReviewRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.vetted.BusinessReviews.Reviews;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {

    private ArrayList <Reviews> businessReviews;
    Fragmentinterface fragmentinterface;

    public ReviewAdapter (ArrayList <Reviews> businessReviews) {
        this.businessReviews = businessReviews;
    }
    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ReviewViewHolder reviewViewHolder = new ReviewViewHolder((LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.review_itemview, viewGroup, false)));
        return reviewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder reviewViewHolder, int i) {
        reviewViewHolder.onBind(businessReviews.get(i));


    }



    @Override
    public int getItemCount() {
        return businessReviews.size();
    }
    public void setReviews(ArrayList<Reviews> businessReviews) {
        this.businessReviews = businessReviews;
        notifyDataSetChanged();
    }
}
