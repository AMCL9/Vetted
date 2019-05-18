package com.example.vetted.AutoComplete;

public class Terms {
    private String text;

    public Terms(String text) {
        this.text = text;
    }

    public String getText ()
    {
        return text;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+"]";
    }
}

