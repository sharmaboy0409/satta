package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultData {
    @SerializedName("StatusID")

    public String statusID;
    @SerializedName("StatusMessage")
    public String statusMessage;
    @SerializedName("result")
    public List<Result> Result;

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

    public List<com.game.dubaisattagame.models.Result> getResult() {
        return Result;
    }

    public void setResult(List<com.game.dubaisattagame.models.Result> result) {
        Result = result;
    }
}
