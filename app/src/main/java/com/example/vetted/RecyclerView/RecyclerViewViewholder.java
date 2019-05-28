package com.example.vetted.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.modells.Businesses;

import java.util.List;


public class RecyclerViewViewholder extends RecyclerView.ViewHolder {

    private TextView name, price, rating, address;

    String businessName;
    String businessNumber;
    Fragmentinterface fragmentinterface;




    private Fragmentinterface listener;

    public RecyclerViewViewholder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.names);
        price = itemView.findViewById(R.id.price);
        address =itemView.findViewById(R.id.address);
        fragmentinterface = (Fragmentinterface) itemView.getContext();
    }


    public void onBind(final Businesses business ) {
        Log.d("Data", "onBind: " + business.getName());
        name.setText(business.getName());
        price.setText(business.getPrice());
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
                fragmentinterface.showDetailsFragment();
            }
        });


    }








}
