package com.example.vetted.AutoComplete;

import com.example.vetted.modells.Businesses;

public class AutoComplete {

    public AutoComplete() {
    }

    private Terms[] terms;

    private Categories[] categories;

    private Businesses[] businesses;

    public Terms[] getTerms ()
    {
        return terms;
    }

    public void setTerms (Terms[] terms)
    {
        this.terms = terms;
    }

    public Categories[] getCategories ()
    {
        return categories;
    }

    public void setCategories (Categories[] categories)
    {
        this.categories = categories;
    }

    public Businesses[] getBusinesses ()
    {
        return businesses;
    }

    public void setBusinesses (Businesses[] businesses)
    {
        this.businesses = businesses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [terms = "+terms+", categories = "+categories+", businesses = "+businesses+"]";
    }
}

