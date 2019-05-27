package com.example.vetted.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.MainActivity;
import com.example.vetted.R;
import com.example.vetted.modells.Businesses;

import java.util.List;


public class RecyclerViewViewholder extends RecyclerView.ViewHolder {

    private TextView name, price, rating, address;


    public static List<Businesses> termResults = MainActivity.termRelateBusinesses;

    private Fragmentinterface listener;

    public RecyclerViewViewholder(@NonNull View itemView, Fragmentinterface listener) {
        super(itemView);
        this.listener = listener;
        name = itemView.findViewById(R.id.names);



    }


    public void onBind(final Businesses objects, final Fragmentinterface listener) {
        name.setText(termResults.get(0).getId());
        price.setText(getPrice(termResults));
        rating.setText(String.format(Double.toString(getRating(termResults))));
        address.setText(getLocation(termResults));

    }

    public String getName(List<Businesses> termResults) {
        String name ="";
        for (Businesses b : termResults) {
            name =b.getName();


        } return name; }


    public String getLocation(List<Businesses> termResults) {
        String fullAddress = "";
        String address1;
        String address2;
        String address3;
        String city;
        String state;
        String zipCode;
        for (Businesses b : termResults) {


            address1 = b.getLocation().getAddress1();


            address2 = b.getLocation().getAddress2();


            address3 = b.getLocation().getAddress3();


            city = b.getLocation().getCity();
            state = b.getLocation().getState();
            zipCode = b.getLocation().getZip_code().toString();

            fullAddress = address1 + address2 + address3 + city + state + zipCode;
        }
        return fullAddress;
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
