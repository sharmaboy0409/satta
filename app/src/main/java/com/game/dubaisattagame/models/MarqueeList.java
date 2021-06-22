package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class MarqueeList {
    public String marquee_Id;
    @SerializedName("Marquee")
    public String marquee;

    public String getMarquee_Id() {
        return marquee_Id;
    }

    public void setMarquee_Id(String marquee_Id) {
        this.marquee_Id = marquee_Id;
    }

    public String getMarquee() {
        return marquee;
    }

    public void setMarquee(String marquee) {
        this.marquee = marquee;
    }
}
