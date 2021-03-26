package com.example.college_dule;

public class Plan {
    private String time;
    private String text;

    Plan(){}
    Plan(String time, String text)
    {
        this.time = time;
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
