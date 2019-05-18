package com.example.vetted.AutoComplete;

public class BusinessesSimple {

    private String name;

    private String id;

    public BusinessesSimple(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClassPojo [name = " + name + ", id = " + id + "]";
    }
}

