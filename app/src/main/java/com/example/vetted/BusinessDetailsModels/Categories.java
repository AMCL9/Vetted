package com.example.vetted.BusinessDetailsModels;

public class Categories {

    public Categories() {
    }

    private String alias;

    private String title;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ClassPojo [alias = " + alias + ", title = " + title + "]";
    }
}


