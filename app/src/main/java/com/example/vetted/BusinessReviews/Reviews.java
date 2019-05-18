package com.example.vetted.BusinessReviews;

public class Reviews {
    private String rating;

    private String time_created;

    private String id;

    private String text;

    private User user;

    private String url;

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
}
