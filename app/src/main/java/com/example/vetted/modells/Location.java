package com.example.vetted.modells;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location{
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("address3")
  @Expose
  private String address3;
  @SerializedName("address2")
  @Expose
  private String address2;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("address1")
  @Expose
  private String address1;
//  @SerializedName("display_address")
//  @Expose
//  private List<Display_address> display_address;
//  private Object display_address;
  @SerializedName("state")
  @Expose
  private String state;
  @SerializedName("zip_code")
  @Expose
  private Integer zip_code;
  public Location(){
  }

  public void setCountry(String country){
   this.country=country;
  }
  public String getCountry(){
   return country;
  }
  public void setAddress3(String address3){
   this.address3=address3;
  }
  public String getAddress3(){
   return address3;
  }
  public void setAddress2(String address2){
   this.address2=address2;
  }
  public String getAddress2(){
   return address2;
  }
  public void setCity(String city){
   this.city=city;
  }
  public String getCity(){
   return city;
  }
  public void setAddress1(String address1){
   this.address1=address1;
  }
  public String getAddress1(){
   return address1;
  }
//  public void setDisplay_address(Object display_address){
//   this.display_address=display_address;
//  }
//  public Object getDisplay_address(){
//   return display_address;
//  }
  public void setState(String state){
   this.state=state;
  }
  public String getState(){
   return state;
  }
  public void setZip_code(Integer zip_code){
   this.zip_code=zip_code;
  }
  public Integer getZip_code(){
   return zip_code;
  }
}