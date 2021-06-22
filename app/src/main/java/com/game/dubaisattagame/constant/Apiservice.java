package com.game.dubaisattagame.constant;

import com.game.dubaisattagame.models.BidData;
import com.game.dubaisattagame.models.DayData;
import com.game.dubaisattagame.models.MarqueeData;
import com.game.dubaisattagame.models.Monthdata;
import com.game.dubaisattagame.models.ResultData;
import com.game.dubaisattagame.models.SlotData;
import com.game.dubaisattagame.models.YearData;
import com.game.dubaisattagame.models.luckey_prizeData;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Apiservice {
    @POST("year.php")
    Call<YearData> getYearData();
    @POST("month.php")
    Call<Monthdata> getMonthData();
    @POST("slot.php")
    Call<SlotData> getSlotData(@Query("all")String all);

    @POST("bid.php")
    Call<BidData> getBidData();
    @POST("luckey_prize.php")
    Call<luckey_prizeData> getluckey_prizeData();
    @POST("marquee.php")
    Call<MarqueeData> getMarqueeData();
    @POST("day.php")
    Call<DayData> getDayData();
    @POST("result.php")
    Call<ResultData> getResultData(@Query("month")String month,@Query("year")String year);
    @POST("result.php")
    Call<ResultData> getResultDataBy(@Query("month")String month,@Query("year")String year);
}
