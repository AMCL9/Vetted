package com.example.vetted.modells;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BusinessSearch{
  @SerializedName("total")
  @Expose
  private Integer total;
  @SerializedName("region")
  @Expose
  private Region region;
  @SerializedName("businesses")
  @Expose
  private List<Businesses> businesses;

  public BusinessSearch(Integer total,Region region,List<Businesses> businesses){
   this.total=total;
   this.region=region;
   this.businesses=businesses;
  }
  public void setTotal(Integer total){
   this.total=total;
  }
  public Integer getTotal(){
   return total;
  }
  public void setRegion(Region region){
   this.region=region;
  }
  public Region getRegion(){
   return region;
  }
  public void setBusinesses(List<Businesses> businesses){
   this.businesses=businesses;
  }
  public List<Businesses> getBusinesses(){
   return businesses;
  }
}