package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class Dateed {
    @SerializedName("res")
    public String res;
    @SerializedName("slot")
    public String slot;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Dateed{" +
                "res='" + res + '\'' +
                '}';
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
