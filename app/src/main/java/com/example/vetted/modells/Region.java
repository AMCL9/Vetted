package com.example.vetted.modells;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region{
  @SerializedName("center")
  @Expose
  private Center center;
  public Region(){
  }
  public Region(Center center){
   this.center=center;
  }
  public void setCenter(Center center){
   this.center=center;
  }
  public Center getCenter(){
   return center;
  }
}