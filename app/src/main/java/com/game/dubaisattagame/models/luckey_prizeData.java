package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class luckey_prizeData {
    @SerializedName("StatusID")
    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("PrizeList")
    public List<PrizeList> PrizeList;

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

    public List<com.game.dubaisattagame.models.PrizeList> getPrizeList() {
        return PrizeList;
    }

    public void setPrizeList(List<com.game.dubaisattagame.models.PrizeList> prizeList) {
        PrizeList = prizeList;
    }
}
