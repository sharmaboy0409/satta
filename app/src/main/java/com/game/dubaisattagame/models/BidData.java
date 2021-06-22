package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BidData {
    @SerializedName("StatusID")
    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("BidList")
    public List<BidList> BidList;

    public List<BidList> getBidList() {
        return BidList;
    }

    public void setBidList(List<BidList> bidList) {
        BidList = bidList;
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
