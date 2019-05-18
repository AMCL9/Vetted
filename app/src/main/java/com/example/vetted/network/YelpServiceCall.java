package com.example.vetted.network;

import com.example.vetted.AutoComplete.AutoComplete;
import com.example.vetted.BusinessDetailsModels.BusinessDetailWrapper;
import com.example.vetted.BusinessReviews.ReviewWrapper;
import com.example.vetted.modells.BusinessSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface YelpServiceCall {

    String token = "mURs8GtRFKdJsKDEuHnqrMxN33vUVSPhMiMggCxYh_4brYNeh6sc9JRbPhQzkkxgoAjnhGvrP3f_Rz6pE1aczFb3_b2ydDR0tABH9tMFhWJxZUhqw3TeHt4Th1LbXHYx";

    @Headers({
            "Authorization:Bearer "  + token})
    @GET("businesses/search")

    Call<BusinessSearch> getBusinessSearch(@Query("term") String term, @Query("longitude") double longitude, @Query("latitude") double latitude);

    @GET("businesses/{id}")
    Call<BusinessDetailWrapper> getBusinessDetails(@Path("id")String id);

    @GET("autocomplete")
    Call<AutoComplete> getResults();

    @GET("businesses/{id}/reviews")
    Call<ReviewWrapper> getReviews();



}