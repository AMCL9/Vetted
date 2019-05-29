package com.example.vetted.RecyclerView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.modells.Businesses;


public class PetBusinessViewholder extends RecyclerView.ViewHolder {

    private TextView name, reviewcount, rating, address;

    String businessName;
    String businessNumber;
    Fragmentinterface fragmentinterface;




    private Fragmentinterface listener;

    public PetBusinessViewholder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.names);
        reviewcount = itemView.findViewById(R.id.review_count);
        address =itemView.findViewById(R.id.address);
        fragmentinterface = (Fragmentinterface) itemView.getContext();
    }


    public void onBind(final Businesses business ) {
        Log.d("Data", "onBind: " + business.getName());
        name.setText(business.getName());
        reviewcount.setText(new StringBuilder()
                .append("Reviews:")
                .append(business.getReview_count()).toString());

        address.setText(new StringBuilder()
                .append(business.getLocation().getAddress1())
                .append(business.getLocation().getAddress2())
                .append(business.getLocation().getCity())
                .append(business.getLocation().getCity())
                .append(business.getLocation().getState())
                .append(business.getLocation().getZip_code()).toString());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passId = business.getId();
                fragmentinterface.passID(passId);
                fragmentinterface.passBusiDetails();

            }
        });


    }








}
