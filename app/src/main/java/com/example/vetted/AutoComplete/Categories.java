package com.example.vetted.AutoComplete;

public class Categories {

    private String alias;

    private String title;

    public Categories(String title, String alias) {
        this.alias = alias;
        this.title = title;
    }

    public String getAlias ()
    {
        return alias;
    }

    public String getTitle ()
    {
        return title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [alias = "+alias+", title = "+title+"]";
    }
}

