package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Final {
    @SerializedName("dateed")
    public List<Dateed> dateed;
    @SerializedName("dayresult")
    public List<Dayresult> dayresult;


    public List<Dateed> getDateed() {
        return dateed;
    }

    public void setDateed(List<Dateed> dateed) {
        this.dateed = dateed;
    }

    public List<Dayresult> getDayresult() {
        return dayresult;
    }

    public void setDayresult(List<Dayresult> dayresult) {
        this.dayresult = dayresult;
    }

    @Override
    public String toString() {
        return "Final{" +
                "dateed=" + dateed +
                ", dayresult=" + dayresult +
                '}';
    }
}
