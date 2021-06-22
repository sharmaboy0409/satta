package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YearData {
    @SerializedName("StatusID")

    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("YearList")
    public List<YearList> yearList;

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

    public List<YearList> getYearList() {
        return yearList;
    }

    public void setYearList(List<YearList> yearList) {
        this.yearList = yearList;
    }
}
