package com.example.vetted.AutoComplete;

public class Terms {
    public Terms() {

    }

    private String text;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+"]";
    }
}

