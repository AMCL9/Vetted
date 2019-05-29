package com.example.vetted.ReviewRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vetted.BusinessReviews.Reviews;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    private TextView id, userReview, userRating,  timeCreated;
    Fragmentinterface fragmentinterface;

    public ReviewViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.review_id);
        userReview = itemView.findViewById(R.id.review_text);
        userRating = itemView.findViewById(R.id.rating);
        timeCreated = itemView.findViewById(R.id.time_created);
        fragmentinterface = (Fragmentinterface) itemView.getContext();


    }
    public void onBind (final Reviews review) {
        id.setText(new StringBuilder().append("ID: ").append(review.getId()).toString());
        userReview.setText(review.getText());
        userRating.setText(new StringBuilder().append("Rating").append(review.getRating()).toString());
        timeCreated.setText(new StringBuilder().append("time/date").append(review.getTime_created()).toString());

    }


}
