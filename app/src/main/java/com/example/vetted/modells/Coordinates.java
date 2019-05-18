package com.example.vetted.modells;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordinates{
  @SerializedName("latitude")
  @Expose
  private Double latitude;
  @SerializedName("longitude")
  @Expose
  private Double longitude;
  public Coordinates(){
  }
  public Coordinates(Double latitude,Double longitude){
   this.latitude=latitude;
   this.longitude=longitude;
  }
  public void setLatitude(Double latitude){
   this.latitude=latitude;
  }
  public Double getLatitude(){
   return latitude;
  }
  public void setLongitude(Double longitude){
   this.longitude=longitude;
  }
  public Double getLongitude(){
   return longitude;
  }
}