package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarqueeData {
    @SerializedName("StatusID")
    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("MarqueeList")
    public List<MarqueeList> marqueeList;

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

    public List<MarqueeList> getMarqueeList() {
        return marqueeList;
    }

    public void setMarqueeList(List<MarqueeList> marqueeList) {
        this.marqueeList = marqueeList;
    }
}
