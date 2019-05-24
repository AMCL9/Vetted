package com.example.vetted.network;

import android.support.annotation.NonNull;

import com.example.vetted.BusinessDetailsModels.BusinessDetailWrapper;
import com.example.vetted.modells.BusinessSearch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class AnimalBusinessRepository {
    private YelpServiceCall yelpService;

    public AnimalBusinessRepository() {
        yelpService = RetrofitSingleton.getInstance()
                .create(YelpServiceCall.class);
    }

    public void getBusinessDetails(@NonNull String businessId, @NonNull Callback<BusinessDetailWrapper> callback) {
        yelpService.getBusinessDetails(businessId)
                .enqueue(callback);
    }

    public void getAllBusinesses(@NonNull String searchTerm, double latitude, double longitude, String categories, @NonNull Callback<BusinessSearch> callback) {


        yelpService.getBusinessSearch(searchTerm, latitude, longitude, categories)
                .enqueue(callback);

    }


}
