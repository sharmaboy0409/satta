package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class MonthList {
    @SerializedName("monthid")
    public String month_Id;
    @SerializedName("month")
    public String month;

    public String getMonth_Id() {
        return month_Id;
    }

    public void setMonth_Id(String month_Id) {
        this.month_Id = month_Id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
