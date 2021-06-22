package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class Daylist {
    @SerializedName("Day_Id")
    public String day_Id;
    @SerializedName("Day")
    public String day;
    public String ciurrentday;

    public String getCiurrentday() {
        return ciurrentday;
    }

    public String setCiurrentday(String ciurrentday) {
        this.ciurrentday = ciurrentday;
        return ciurrentday;
    }

    public String getDay_Id() {
        return day_Id;
    }

    public void setDay_Id(String day_Id) {
        this.day_Id = day_Id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
