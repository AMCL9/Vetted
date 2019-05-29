package com.example.vetted.BusinessReviews;

import android.os.Parcel;
import android.os.Parcelable;

public class Reviews implements Parcelable {
    private String rating;

    private String time_created;

    private String id;

    private String text;

    private User user;

    private String url;

    protected Reviews(Parcel in) {
        rating = in.readString();
        time_created = in.readString();
        id = in.readString();
        text = in.readString();
        url = in.readString();
    }

    public static final Creator<Reviews> CREATOR = new Creator<Reviews>() {
        @Override
        public Reviews createFromParcel(Parcel in) {
            return new Reviews(in);
        }

        @Override
        public Reviews[] newArray(int size) {
            return new Reviews[size];
        }
    };

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getTime_created ()
    {
        return time_created;
    }

    public void setTime_created (String time_created)
    {
        this.time_created = time_created;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rating = "+rating+", time_created = "+time_created+", id = "+id+", text = "+text+", user = "+user+", url = "+url+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rating);
        dest.writeString(time_created);
        dest.writeString(id);
        dest.writeString(text);
        dest.writeString(url);
    }
}
