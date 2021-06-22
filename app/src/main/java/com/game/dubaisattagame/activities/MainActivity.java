package com.game.dubaisattagame.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.adpter.DateAdapter;
import com.game.dubaisattagame.adpter.DayAdapter2;
import com.game.dubaisattagame.adpter.DayAdpter;
import com.game.dubaisattagame.adpter.DayAdpterF;
import com.game.dubaisattagame.adpter.MonthAdapter;
import com.game.dubaisattagame.adpter.SlotAdapter;
import com.game.dubaisattagame.adpter.TimeAdapter;
import com.game.dubaisattagame.adpter.YearAdpter;
import com.game.dubaisattagame.constant.Apiservice;
import com.game.dubaisattagame.constant.api;
import com.game.dubaisattagame.models.Dateed;
import com.game.dubaisattagame.models.DayData;
import com.game.dubaisattagame.models.Daylist;
import com.game.dubaisattagame.models.Final;
import com.game.dubaisattagame.models.MonthList;
import com.game.dubaisattagame.models.Result;
import com.game.dubaisattagame.models.ResultData;
import com.game.dubaisattagame.models.SharedPreferenceLIB;
import com.game.dubaisattagame.models.SloList;
import com.game.dubaisattagame.models.SlotData;
import com.game.dubaisattagame.models.YearData;
import com.game.dubaisattagame.models.Inputdata;
import com.game.dubaisattagame.models.Monthdata;
import com.game.dubaisattagame.models.YearList;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<YearList> yearsArrayList;
    private List<MonthList> monthLists;
    private List<Daylist> dayList;
    private RecyclerView recmonth,recyear,recydate,rec_slot,rec_result;
    private RecyclerView recytimem,recdaym, recdaymf,  recydaym1, recydaym2, recydaym3;
    private LinearLayout linyear,linmonth;
    private MonthAdapter monthAdapter;
    private YearAdpter yearAdpter;
    private TextView txtmontj,txtyear,txtmonth,txt_month_datam;
    private String month,year,monthpre;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private String monthid,all;
    private int month_id;
    private Apiservice service;
    private SharedPreferenceLIB sharedPreferenceLIB;
    private List<SloList> SloList;
    private List<Result> resultList;
    private List<String> dayListpr;
    private String thisDate,slotday;
    private int year1;
    List<Dateed> dateedlist;
    private Final finaldata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDateFormat currentDate = new SimpleDateFormat("dd");
        Date todayDate = new Date();
         thisDate = currentDate.format(todayDate);
         dayListpr=new ArrayList<>();



        recydate =  findViewById(R.id.recdateit);
        rec_slot =  findViewById(R.id.rec_slot);
        rec_result =  findViewById(R.id.rec_result);
        recydaym1 =  findViewById(R.id.recdaym1);
        recydaym2 =  findViewById(R.id.recdaym2);
        recydaym3 =  findViewById(R.id.recdaym3);
        recdaymf =  findViewById(R.id.recdaym);
        recdaym =  findViewById(R.id. recdateitm);
        recytimem =  findViewById(R.id.rectimem);
        txtmonth =  findViewById(R.id.txt_month_data);

        sharedPreferenceLIB=new SharedPreferenceLIB(getApplicationContext());




        LinearLayoutManager horizontaldate
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recydate.setLayoutManager(horizontaldate);
        recydate.setHasFixedSize(true);

        LinearLayoutManager recslot
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rec_slot.setLayoutManager(recslot);
        rec_slot.setHasFixedSize(true);

        LinearLayoutManager recresult
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rec_result.setLayoutManager(recresult);
        rec_result.setHasFixedSize(true);





        LinearLayoutManager horizontaltimem
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recytimem.setLayoutManager(horizontaltimem);
        recytimem.setHasFixedSize(true);
        LinearLayoutManager horizontalday
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recdaym.setLayoutManager(horizontalday);
        recdaym.setHasFixedSize(true);
        LinearLayoutManager horizontaldaymf
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recdaymf.setLayoutManager(horizontaldaymf);
        recdaymf.setHasFixedSize(true);
        LinearLayoutManager horizontaldaym1
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recydaym1.setLayoutManager(horizontaldaym1);
        recydaym1.setHasFixedSize(true);
        LinearLayoutManager horizontaldaym3
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recydaym3.setLayoutManager(horizontaldaym3);
        recydaym3.setHasFixedSize(true);
        LinearLayoutManager horizontaldaym2
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recydaym2.setLayoutManager(horizontaldaym2);
        recydaym2.setHasFixedSize(true);
        service = api.GetApiClient().create(Apiservice.class);

        linmonth = findViewById(R.id.linmonth);
        linyear = findViewById(R.id.linyeari);
        txtyear=findViewById(R.id.txtyear);
        txtmontj=findViewById(R.id.txtmonth);
        txt_month_datam=findViewById(R.id.txt_month_datam);

        linyear.setOnClickListener(this);
        linmonth.setOnClickListener(this);

        YearDataserver();
        MonthDataserver();

        Calendar c = Calendar.getInstance();


        String[]monthName={"January","February","March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
         month=monthName[c.get(Calendar.MONTH)];
        c.add(Calendar.MONTH, -1);
        String monthpre = monthName[c.get(Calendar.MONTH)];
       String[]yearName={"2021","2022"};
         year1=c.get(Calendar.YEAR);

         if (month!=null)
         {
             DayData();
         }
       //txtyear.setText(yearName.toString());
         txtyear.setText(String.valueOf(year1));
        all=sharedPreferenceLIB.YearFetch();
        txtmontj.setText(month);
        txtmonth.setText(month);
        txt_month_datam.setText(monthpre);
        c.clear();
        c.add(Calendar.MONTH, -1);

        if (month!=null)
        {
            ResultDataserver();
        }

        if(year!=null){
            YearDataserver();
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));


    }
    public void ApiCall() {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<ResultData> call = service.getResultDataBy("june","2021");
        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                if (response.isSuccessful())
                {
                    resultList=response.body().getResult();
                    if (resultList!=null) {
                        for (int i=0;i<resultList.size();i++)
                        {
                            finaldata = resultList.get(i).getaFinal();
                            dateedlist=finaldata.getDateed();
                            slotday=resultList.get(i).getSlotday();
                        }

                       DayAdpter dayapatper = new DayAdpter(getApplicationContext(), dayList,dateedlist,resultList);
                        recydate.setAdapter(dayapatper);//yaha se Day adapter  ke through upper wali date aa rhi

                        Log.d("aaa", "onResponse: "+resultList.size());
                        Log.d("aaa", "onResponse: "+dayList.get(10).getDay().toString());
                        Log.d("aaa", "onResponse: "+finaldata);
                        Log.d("aaa", "onResponse: "+slotday);
                        Log.d("aaa", "onResponse: "+dateedlist);

                      // Toast.makeText(getApplicationContext(),"AAA"+resultList,Toast.LENGTH_LONG).show();


                    }

                }
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {

            }
        });
    }


    private void YearDataserver()
    {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<YearData> call = service.getYearData();
        call.enqueue(new Callback<YearData>() {
            @Override
            public void onResponse(Call<YearData> call, Response<YearData> response) {
                if (response.isSuccessful())
                {

                    if (yearsArrayList!=null) {
                        yearsArrayList = response.body().getYearList();
                        year = yearsArrayList.get(0).getYear();
                    }
                }

                //YearAdpter yearAdpter= new YearAdpter(getApplicationContext(),yearsArrayList);
                //recyear.setAdapter(yearAdpter);
            }

            @Override
            public void onFailure(Call<YearData> call, Throwable t) {

            }
        });
    }

    private void MonthDataserver()
    {
        Call<Monthdata> call = service.getMonthData();
        call.enqueue(new Callback<Monthdata>() {
           @Override
           public void onResponse(Call<Monthdata> call, Response<Monthdata> response) {
               if (response.isSuccessful())
               {
                  monthLists=response.body().getMonthList();
                  if (monthLists!=null) {
                      month = monthLists.get(0).getMonth();
                  }

               }

           }

           @Override
           public void onFailure(Call<Monthdata> call, Throwable t) {

           }
       });
    }

    private void slotDataServer2(){
        Call<SlotData> call = service.getSlotData(month);
        call.enqueue(new Callback<SlotData>() {
            @Override
            public void onResponse(Call<SlotData> call, Response<SlotData> response) {
                if (response.isSuccessful()){
                    SloList=response.body().SloList;
                    if (SloList!=null){
                        ArrayList<String> integerList = new ArrayList();
                        Map<String, SloList> studentsByName = new HashMap<>();
                        for (SloList s : SloList) {
                            studentsByName.put(s.getSlot_Id(), s);
                            integerList.add((s.getSlot_Id()));
                            integerList.add((s.getSlot()));
                            Log.e("tag", "interlist" + studentsByName.toString());

                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<SlotData> call, Throwable t) {

            }
        });
    }

    private void SlotDataserver() {
       /* Call<SlotData> call = service.getSlotData(month);
        call.enqueue(new Callback<SlotData>() {
            @Override
            public void onResponse(Call<SlotData> call, Response<SlotData> response) {
                if (response.isSuccessful())
                {
                    SloList=response.body().getSloList();
                    if (SloList!=null) {
                       ArrayList<String> integerList = new ArrayList();

                        Map<String, SloList> studentsByName = new HashMap<>();
                         for (SloList s : SloList) {
                          studentsByName.put(s.getSlot_Id(), s);
                            integerList.add((s.getSlot_Id()));
                            integerList.add((s.getSlot()));
                          Log.e("tag", "interlist" + studentsByName.toString());

                       }


                       ArrayList<String> integerList1 = new ArrayList();

                    Map<String, Result> studentsByName1 = new HashMap<>();
                       for (Result s : resultList) {
                            studentsByName1.put(s.getSlot_Id(), s);
                           integerList1.add((s.getSlot_Id()));
                           integerList1.add((s.getResult()));
                             Log.e("tag", "interlist" + studentsByName.toString());

                       }
                      integerList1.removeAll(integerList);
                        integerList.retainAll(integerList1);
                        Toast.makeText(getApplicationContext(), "taresultg" + integerList, Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(), "taresultg" + integerList1, Toast.LENGTH_LONG).show();
                    }

                    if (SloList.size()!=0) {



                      // CompareData(SloList, resultList);

                        Log.e("tag", "interlist");
                        List<Integer> integerList1=new ArrayList<>();
                        SloList mOResultObj =new SloList();

                       Toast.makeText(getApplicationContext(), "tag" + integerList1, Toast.LENGTH_LONG).show();

                        Map<Integer, Result> Resultbyslot = new HashMap<>();
                        for (Result s : resultList) {
                          Resultbyslot.put(Integer.parseInt(s.getSlot_Id()), s);
                           // Log.e("tag", "interlist" + studentsByName.toString());

                      }


                   }



                     for(SloList mOResultObj:SloList){
                         // ntegerList.add(Integer.parseInt(mOResultObj.getSlot_Id()));
                        }

                        List<Integer> integerList1= new ArrayList();
                        for(Result mOResultObj:resultList){
                           integerList1.add(Integer.parseInt(mOResultObj.getSlot_Id()));
                       }
                      // integerList.retainAll(integerList1);





                }

            @Override
            public void onFailure(Call<SlotData> call, Throwable t) {

            }*/

    }


    private void ResultDataserver() {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<ResultData> call = service.getResultDataBy(month,String.valueOf(year1));
        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                if (response.isSuccessful())
                {
                     resultList=response.body().getResult();
                     if (resultList!=null) {
                         for(int i=0;i<resultList.size();i++) {
                             Final finaldata = resultList.get(i).getaFinal();
                             if (finaldata!=null) {
                                 dateedlist = finaldata.getDateed();
                                 SlotAdapter slotAdapter=new SlotAdapter(getApplicationContext(),dateedlist);
                                 rec_slot.setAdapter(slotAdapter);

                             }

                         }

                     }

                }
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {

            }
        });
    }



    private void DayData()
    {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<DayData> call = service.getDayData();
        call.enqueue(new Callback<DayData>() {
            @Override
            public void onResponse(Call<DayData> call, Response<DayData> response) {
                if (response.isSuccessful())
                {

                    dayList=response.body().getDaylist();
                    if (dayList!=null) {
                        ApiCall();

                    }
                }
            }

            @Override
            public void onFailure(Call<DayData> call, Throwable t) {

            }
        });

    }
    private void DayDataF()
    {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<DayData> call = service.getDayData();
        call.enqueue(new Callback<DayData>() {
            @Override
            public void onResponse(Call<DayData> call, Response<DayData> response) {
                if (response.isSuccessful())
                {
                    dayList=response.body().getDaylist();
                    DayAdpterF timeAdapter=new DayAdpterF(getApplicationContext(),dayList);
                    recydate.setAdapter(timeAdapter);
                }
            }

            @Override
            public void onFailure(Call<DayData> call, Throwable t) {

            }
        });

    }
    private void DayData2()
    {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<DayData> call = service.getDayData();
        call.enqueue(new Callback<DayData>() {
            @Override
            public void onResponse(Call<DayData> call, Response<DayData> response) {
                if (response.isSuccessful())
                {
                    dayList=response.body().getDaylist();
                    DayAdapter2 timeAdapter=new DayAdapter2(getApplicationContext(),dayList);
                    recydate.setAdapter(timeAdapter);

                }
            }

            @Override
            public void onFailure(Call<DayData> call, Throwable t) {

            }
        });

    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            month = intent.getStringExtra("monthname");
            year = intent.getStringExtra("Yearname");
            all=intent.getStringExtra("monthname");
            all=intent.getStringExtra("Yearname");

            if (month!=null) {
                txtmontj.setText(month);
                txtmonth.setText(month);
                Call<ResultData> call = service.getResultData(month,String.valueOf(year1));
                call.enqueue(new Callback<ResultData>() {
                    @Override
                    public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                        if (response.isSuccessful())
                        {
                            List<Result> resultList=response.body().getResult();
                            if(resultList.size()==0) {
                                for (int i = 0; i < resultList.size(); i++) {
                                    Final finaldata = resultList.get(i).getaFinal();
                                    List<Dateed> dateed = finaldata.getDateed();
                                  // DateAdapter slotAdapter = new DateAdapter(getApplicationContext(),resultList,resultList.size(), dateed);
                                    //rec_result.setAdapter(slotAdapter);
                                    SlotAdapter slotAdapter1 = new SlotAdapter(getApplicationContext(),dateed);
                                    rec_slot.setAdapter(slotAdapter1);

                                }


                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<ResultData> call, Throwable t) {

                    }
                });

            }
            dialog.dismiss();

            monthid = intent.getStringExtra("monthid");
            if (monthid!=null)
            {
                month_id=Integer.parseInt(monthid);

            }
            if (year!=null)
            {

                txtyear.setText(year);

                Call<ResultData> call = service.getResultData(month,year);
                call.enqueue(new Callback<ResultData>() {
                    @Override
                    public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                        if (response.isSuccessful())
                        {
                            List<Result> resultList=response.body().getResult();
//                            DateAdapter slotAdapter=new DateAdapter(getApplicationContext(),resultList);
//                            rec_result.setAdapter(slotAdapter);
//                            SlotAdapter slotAdapter1=new SlotAdapter(getApplicationContext(),resultList);
//                            rec_slot.setAdapter(slotAdapter1);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResultData> call, Throwable t) {

                    }
                });

            }
                    if (month_id == 2) {
                        DayData2();
                    } else if (month_id == 3) {
                        DayDataF();
                    } else {
                        DayData();

                    }
                }

    };

        private void AlertboxMonth(View view) {
         builder
                    = new AlertDialog.Builder(view.getContext());

            final View customLayout
                    = getLayoutInflater()
                    .inflate(
                            R.layout.item_recy_date,
                            null);
            builder.setView(customLayout);
            recmonth = customLayout.findViewById(R.id.recydate);
            LinearLayoutManager horizontalLayoutManager
                    = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recmonth.setLayoutManager(horizontalLayoutManager);
            recmonth.setHasFixedSize(true);
           monthAdapter= new MonthAdapter(getApplicationContext(), monthLists);
           recmonth.setAdapter(monthAdapter);
            builder.setNegativeButton("", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });


            // add a button
            builder
                    .setPositiveButton(
                            "",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {


                                }

                            });
             dialog
                    = builder.create();
            dialog.show();


        }

        private void Alertboxyear(View view) {
            AlertDialog.Builder builder
                    = new AlertDialog.Builder(view.getContext());
            final View customLayout
                    = getLayoutInflater()
                    .inflate(
                            R.layout.itemyear_rey,
                            null);
            builder.setView(customLayout);
            recyear = customLayout.findViewById(R.id.recyyeari);
            LinearLayoutManager horizontalLayoutManager
                    = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyear.setLayoutManager(horizontalLayoutManager);
            recyear.setHasFixedSize(true);

            String[]yearp={"2001","2022"};



           // yearAdpter = new YearAdpter(getApplicationContext(), yearsArrayList1);
            yearAdpter  = new YearAdpter(getApplicationContext(), yearsArrayList);
            recyear.setAdapter(yearAdpter);

            builder.setNegativeButton("", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setPositiveButton(
                            "",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {


                                }

                            });
          dialog = builder.create();
            dialog.show();
        }



        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.linmonth:
                    AlertboxMonth(v);
                    break;
                case R.id.linyeari:
                    Alertboxyear(v);
                    break;
            }
        }



}


