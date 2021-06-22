package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class Dayresult {
    @SerializedName("days")
    public String days;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
