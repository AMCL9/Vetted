package com.example.vetted.modells;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Businesses implements Parcelable {
  @SerializedName("distance")
  @Expose
  private Double distance;
  @SerializedName("image_url")
  @Expose
  private String image_url;
  @SerializedName("rating")
  @Expose
  private Double rating;
  @SerializedName("coordinates")
  @Expose
  private Coordinates coordinates;
  @SerializedName("review_count")
  @Expose
  private Integer review_count;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("display_phone")
  @Expose
  private String display_phone;
  @SerializedName("phone")
  @Expose
  private Long phone;
  @SerializedName("price")
  @Expose
  private String price;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("alias")
  @Expose
  private String alias;
  @SerializedName("location")
  @Expose
  private Location location;
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("categories")
  @Expose
  private List<Categories> categories;
  @SerializedName("is_closed")
  @Expose
  private Boolean is_closed;


  public Businesses(){
  }

    protected Businesses(Parcel in) {
        if (in.readByte() == 0) {
            distance = null;
        } else {
            distance = in.readDouble();
        }
        image_url = in.readString();
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readDouble();
        }
        if (in.readByte() == 0) {
            review_count = null;
        } else {
            review_count = in.readInt();
        }
        url = in.readString();
        display_phone = in.readString();
        if (in.readByte() == 0) {
            phone = null;
        } else {
            phone = in.readLong();
        }
        price = in.readString();
        name = in.readString();
        alias = in.readString();
        id = in.readString();
        byte tmpIs_closed = in.readByte();
        is_closed = tmpIs_closed == 0 ? null : tmpIs_closed == 1;
    }

    public static final Creator<Businesses> CREATOR = new Creator<Businesses>() {
        @Override
        public Businesses createFromParcel(Parcel in) {
            return new Businesses(in);
        }

        @Override
        public Businesses[] newArray(int size) {
            return new Businesses[size];
        }
    };

    public void setDistance(Double distance){
   this.distance=distance;
  }
  public Double getDistance(){
   return distance;
  }
  public void setImage_url(String image_url){
   this.image_url=image_url;
  }
  public String getImage_url(){
   return image_url;
  }
  public void setRating(Double rating){
   this.rating=rating;
  }
  public Double getRating(){
   return rating;
  }
  public void setCoordinates(Coordinates coordinates){
   this.coordinates=coordinates;
  }
  public Coordinates getCoordinates(){
   return coordinates;
  }
  public void setReview_count(Integer review_count){
   this.review_count=review_count;
  }
  public Integer getReview_count(){
   return review_count;
  }
  public void setUrl(String url){
   this.url=url;
  }
  public String getUrl(){
   return url;
  }
  public void setDisplay_phone(String display_phone){
   this.display_phone=display_phone;
  }
  public String getDisplay_phone(){
   return display_phone;
  }
  public void setPhone(Long phone){
   this.phone=phone;
  }
  public Long getPhone(){
   return phone;
  }
  public void setPrice(String price){
   this.price=price;
  }
  public String getPrice(){
   return price;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setAlias(String alias){
   this.alias=alias;
  }
  public String getAlias(){
   return alias;
  }
  public void setLocation(Location location){
   this.location=location;
  }
  public Location getLocation(){
   return location;
  }
  public void setId(String id){
   this.id=id;
  }
  public String getId(){
   return id;
  }
  public void setCategories(List<Categories> categories){
   this.categories=categories;
  }
  public List<Categories> getCategories(){
   return categories;
  }
  public void setIs_closed(Boolean is_closed){
   this.is_closed=is_closed;
  }
  public Boolean getIs_closed(){
   return is_closed;
  }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (distance == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(distance);
        }
        dest.writeString(image_url);
        if (rating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(rating);
        }
        if (review_count == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(review_count);
        }
        dest.writeString(url);
        dest.writeString(display_phone);
        if (phone == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(phone);
        }
        dest.writeString(price);
        dest.writeString(name);
        dest.writeString(alias);
        dest.writeString(id);
        dest.writeByte((byte) (is_closed == null ? 0 : is_closed ? 1 : 2));
    }
}