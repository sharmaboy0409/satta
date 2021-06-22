package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DayData {
    @SerializedName("StatusID")

    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("DayList")
    public List<Daylist> Daylist;

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

    public List<com.game.dubaisattagame.models.Daylist> getDaylist() {
        return Daylist;
    }

    public void setDaylist(List<com.game.dubaisattagame.models.Daylist> daylist) {
        Daylist = daylist;
    }
}
