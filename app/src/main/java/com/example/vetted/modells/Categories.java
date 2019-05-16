package com.example.vetted.modells;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories{
  @SerializedName("alias")
  @Expose
  private String alias;
  @SerializedName("title")
  @Expose
  private String title;
  public Categories(){
  }
  public Categories(String alias,String title){
   this.alias=alias;
   this.title=title;
  }
  public void setAlias(String alias){
   this.alias=alias;
  }
  public String getAlias(){
   return alias;
  }
  public void setTitle(String title){
   this.title=title;
  }
  public String getTitle(){
   return title;
  }
}