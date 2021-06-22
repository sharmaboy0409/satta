package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class BidList {
    @SerializedName("bid_Id")
    public String bid_Id;
    @SerializedName("Number")
    public String Number;
    @SerializedName("Number1")
    public String Number1;

    public String getNumber1() {
        return Number1;
    }

    public void setNumber1(String number1) {
        Number1 = number1;
    }

    public String getBid_Id() {
        return bid_Id;
    }

    public void setBid_Id(String bid_Id) {
        this.bid_Id = bid_Id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
