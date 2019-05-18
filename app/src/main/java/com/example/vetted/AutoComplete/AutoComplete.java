package com.example.vetted.AutoComplete;

public class AutoComplete {

    private Terms[] terms;

    private Categories[] categories;

    private BusinessesSimple[] businesses;

    public AutoComplete(Terms[] terms, Categories[] categories, BusinessesSimple[] businesses) {
        this.terms = terms;
        this.categories = categories;
        this.businesses = businesses;
    }

    public Terms[] getTerms() {
        return terms;
    }

    public Categories[] getCategories() {
        return categories;
    }

    public BusinessesSimple[] getBusinesses() {
        return businesses;
    }

    @Override
    public String toString() {
        return "ClassPojo [terms = " + terms + ", categories = " + categories + ", businesses = " + businesses + "]";
    }
}
