package com.example.vetted.BusinessReviews;

public class ReviewWrapper {
    private String total;

    private String[] possible_languages;

    private Reviews[] reviews;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String[] getPossible_languages ()
    {
        return possible_languages;
    }

    public void setPossible_languages (String[] possible_languages)
    {
        this.possible_languages = possible_languages;
    }

    public Reviews[] getReviews ()
    {
        return reviews;
    }

    public void setReviews (Reviews[] reviews)
    {
        this.reviews = reviews;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", possible_languages = "+possible_languages+", reviews = "+reviews+"]";
    }
}

