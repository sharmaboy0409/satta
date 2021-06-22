package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Monthdata {
    private String monthname;
    @SerializedName("StatusID")

    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("MonthList")
    public List<MonthList> MonthList;

    public List<MonthList> getMonthList() {
        return MonthList;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }



    public void setMonthList(List<com.game.dubaisattagame.models.MonthList> monthList) {
        MonthList = monthList;
    }

    public Monthdata(String monthname) {
        this.monthname = monthname;
    }

    public String getMonthname() {
        return monthname;
    }

    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }
}
