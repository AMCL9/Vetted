package com.example.vetted.BusinessReviews;

public class User {
    private String profile_url;

    private String image_url;

    private String name;

    private String id;

    public String getProfile_url ()
    {
        return profile_url;
    }

    public void setProfile_url (String profile_url)
    {
        this.profile_url = profile_url;
    }

    public String getImage_url ()
    {
        return image_url;
    }

    public void setImage_url (String image_url)
    {
        this.image_url = image_url;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [profile_url = "+profile_url+", image_url = "+image_url+", name = "+name+", id = "+id+"]";
    }
}
