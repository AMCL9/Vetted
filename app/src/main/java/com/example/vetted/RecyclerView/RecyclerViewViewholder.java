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
        fragmentinterface = (Fragmentinterface) itemView.getContext();
    }


    public void onBind(final Businesses business ) {
        Log.d("Data", "onBind: " + business.getName());
        name.setText(business.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentinterface.showDetailsFragment();
            }
        });


    }

    public String getName(List<Businesses> termResults) {
        String name ="";
        for (Businesses b : termResults) {
            name =b.getName();


        } return name; }


    public String getLocation(List<Businesses> termResults) {
      return termResults.toString();
    }

    public String getPrice (List <Businesses> termResults) {
    String price = "";
    for (Businesses b : termResults) {
        price = b.getPrice();
    } return price;

    }

    public Double getRating (List <Businesses> termResults) {
        Double rating = 0.0;
        for (Businesses b :termResults) {
            rating = b.getRating();
        } return rating;
    }


}
