package com.game.dubaisattagame.models;

import com.google.gson.annotations.SerializedName;

public class PrizeList {
    @SerializedName("Prize_Id")
    public String prize_Id;
    @SerializedName("Number1")
    public String number1;
    @SerializedName("Number2")
    public String number2;
    @SerializedName("Number3")
    public String number3;
    @SerializedName("Number4")
    public String number4;
    @SerializedName("Number5")
    public String number5;
    @SerializedName("Number6")
    public String number6;

    public String getPrize_Id() {
        return prize_Id;
    }

    public void setPrize_Id(String prize_Id) {
        this.prize_Id = prize_Id;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getNumber4() {
        return number4;
    }

    public void setNumber4(String number4) {
        this.number4 = number4;
    }

    public String getNumber5() {
        return number5;
    }

    public void setNumber5(String number5) {
        this.number5 = number5;
    }

    public String getNumber6() {
        return number6;
    }

    public void setNumber6(String number6) {
        this.number6 = number6;
    }
}
