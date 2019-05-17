package com.example.vetted.BusinessDetailsModels;

public class Special_hours {

    public Special_hours() {
    }

    private String date;

    private boolean is_overnight;

    private String start;

    private String end;

    private boolean is_closed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public boolean getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    @Override
    public String toString() {
        return "ClassPojo [date = " + date + ", is_overnight = " + is_overnight + ", start = " + start + ", end = " + end + ", is_closed = " + is_closed + "]";
    }
}

