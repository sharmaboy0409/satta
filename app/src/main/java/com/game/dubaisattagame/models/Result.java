package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("Result_Id")
    public String result_Id;
    @SerializedName("slot")
    public String slot;
    @SerializedName("Result")
    public String result;
    @SerializedName("Slot Id")
    public String slot_Id;
    public String result_id;
    public String slot_id;
    @SerializedName("date")
    public String date;
    @SerializedName("slotday")
    public String slotday;

    public String getSlotday() {
        return slotday;
    }

    public void setSlotday(String slotday) {
        this.slotday = slotday;
    }

    @SerializedName("final")
    public Final aFinal;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Final getaFinal() {
        return aFinal;
    }

    public void setaFinal(Final aFinal) {
        this.aFinal = aFinal;
    }

    public String getSlot_Id() {
        return slot_Id;
    }

    public void setSlot_Id(String slot_Id) {
        this.slot_Id = slot_Id;
    }

    public String getResult_Id() {
        return result_Id;
    }

    public void setResult_Id(String result_Id) {
        this.result_Id = result_Id;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result_Id='" + result_Id + '\'' +
                ", slot='" + slot + '\'' +
                ", result='" + result + '\'' +
                ", slot_Id='" + slot_Id + '\'' +
                ", result_id='" + result_id + '\'' +
                ", slot_id='" + slot_id + '\'' +
                ", date='" + date + '\'' +
                ", slotday='" + slotday + '\'' +
                ", aFinal=" + aFinal +
                '}';
    }
}
