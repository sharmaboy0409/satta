package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class YearList {
    @SerializedName("Year_Id")
    public String year_Id;
    @SerializedName("year")
    public String year;

    public String getYear_Id() {
        return year_Id;
    }

    public void setYear_Id(String year_Id) {
        this.year_Id = year_Id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

