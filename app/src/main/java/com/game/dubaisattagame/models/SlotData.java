package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SlotData {
    @SerializedName("StatusID")

    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("SloList")
    public List<SloList> SloList;

    public List<com.game.dubaisattagame.models.SloList> getSloList() {
        return SloList;
    }

    public void setSloList(List<com.game.dubaisattagame.models.SloList> sloList) {
        SloList = sloList;
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


}
