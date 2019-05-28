package com.example.vetted.views;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vetted.R;


public class DetailsFragment extends Fragment {
    public static final String IMAGE = "image";
    public static final String OTHERIMAGES = "otherimages";
    public static final String NAME = "name";
    public static final String ALIAS = "alias";
    public static final String PHONENUMBER = "phonenumber";
    public static final String RATING = "rating";
    public static final String OPEN = "open";
    public static final String PRICE = "price";
    public static final String URL = "url";

    String businessImage = "";
    //    String[] extraBusinessImages =;
    String businessName = "";
    String businessAlias = "";
    String businessPhoneNumber = "";
    String businessRating = "";
    boolean isBusinessOpen = false;
    String businessPrice = "";
    String businessURL = "";

    private TextView businessNameView, aliasView, numberView,
            urlView, ratingView, openView, priceView;
    private ImageView businessImageView;

    private RecyclerView reviewRecyclerView;

    public DetailsFragment() {

    }


    public static DetailsFragment newInstance(String image, String[] otherImages, String name,
                                              String alias, String phoneNumber, String rating,
                                              Boolean open, String price, String url) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE, image);
        args.putStringArray(OTHERIMAGES, otherImages);
        args.putString(NAME, name);
        args.putString(ALIAS, alias);
        args.putString(PHONENUMBER, phoneNumber);
        args.putString(RATING, rating);
        args.putBoolean(OPEN, open);
        args.putString(PRICE, price);
        args.putString(URL, url);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            businessAlias = getArguments().getString(ALIAS);
            businessImage = getArguments().getString(IMAGE);
//            extraBusinessImages = getArguments().getStringArray(OTHERIMAGES);
            businessName = getArguments().getString(NAME);
            businessPhoneNumber = getArguments().getString(PHONENUMBER);
            businessRating = getArguments().getString(RATING);
            isBusinessOpen = getArguments().getBoolean(OPEN);
            businessPrice = getArguments().getString(PRICE);
            businessURL = getArguments().getString(URL);

            Log.d("ouchiee", "onCreate: " + businessName);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        businessNameView = view.findViewById(R.id.business_name);
        aliasView = view.findViewById(R.id.alias);
        numberView = view.findViewById(R.id.number);
        ratingView = view.findViewById(R.id.rating);
        priceView = view.findViewById(R.id.price);
        urlView = view.findViewById(R.id.url);
        businessNameView.setText(businessName);
        aliasView.setText(businessAlias);
        numberView.setText(businessPhoneNumber);
        ratingView.setText(businessRating);
        priceView.setText(businessPrice);
        urlView.setText(businessURL);
        if (isBusinessOpen) {
            openView.findViewById(R.id.open);

        }
    }
}
