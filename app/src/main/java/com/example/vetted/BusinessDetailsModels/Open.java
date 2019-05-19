package com.example.vetted.BusinessDetailsModels;

public class Open {

    public Open(String start, String end, String day) {
        this.start = start;
        this.end = end;
        this.day = day;
    }

    private boolean is_overnight;

    private String start;

    private String end;

    private String day;

    public boolean getIs_overnight() {
        return is_overnight;
    }

    public void setIs_overnight(boolean is_overnight) {
        this.is_overnight = is_overnight;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "ClassPojo [is_overnight = " + is_overnight + ", start = " + start + ", end = " + end + ", day = " + day + "]";
    }
}
