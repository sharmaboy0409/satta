package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class SloList {
    @SerializedName("Slot_Id")
    public String slot_Id;
    @SerializedName("Slot")
    public String slot;
    @SerializedName("Number")
    public String number;
    @SerializedName("Year")
    public String year;
    @SerializedName("Month")
    public String month;

    public String getSlot_Id() {
        return slot_Id;
    }

    public void setSlot_Id(String slot_Id) {
        this.slot_Id = slot_Id;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
