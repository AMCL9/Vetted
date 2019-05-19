package com.example.vetted.BusinessDetailsModels;

public class Hours {

    public Hours(boolean is_open_now, String hours_type, Open [] open) {
        this.is_open_now = is_open_now;
        this.hours_type = hours_type;
        this.open = open;
    }

    private boolean is_open_now;

    private String hours_type;

    private Open[] open;

    public boolean getIs_open_now() {
        return is_open_now;
    }

    public void setIs_open_now(boolean is_open_now) {
        this.is_open_now = is_open_now;
    }

    public String getHours_type() {
        return hours_type;
    }

    public void setHours_type(String hours_type) {
        this.hours_type = hours_type;
    }

    public Open[] getOpen() {
        return open;
    }

    public void setOpen(Open[] open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "ClassPojo [is_open_now = " + is_open_now + ", hours_type = " + hours_type + ", open = " + open + "]";
    }
}


