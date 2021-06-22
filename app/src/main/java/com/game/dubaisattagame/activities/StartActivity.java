package com.game.dubaisattagame.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.game.dubaisattagame.R;
import com.game.dubaisattagame.adpter.DateAdapter;
import com.game.dubaisattagame.adpter.Inputdatatapter;
import com.game.dubaisattagame.adpter.Spinnerdata;
import com.game.dubaisattagame.constant.Apiservice;
import com.game.dubaisattagame.constant.api;
import com.game.dubaisattagame.models.BidData;
import com.game.dubaisattagame.models.BidList;
import com.game.dubaisattagame.models.Dateed;
import com.game.dubaisattagame.models.Final;
import com.game.dubaisattagame.models.InputNodata;
import com.game.dubaisattagame.models.Inputdata;
import com.game.dubaisattagame.models.MarqueeData;
import com.game.dubaisattagame.models.MarqueeList;
import com.game.dubaisattagame.models.PrizeList;
import com.game.dubaisattagame.models.Result;
import com.game.dubaisattagame.models.ResultData;
import com.game.dubaisattagame.models.SharedPreferenceLIB;
import com.game.dubaisattagame.models.luckey_prizeData;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView recyclerView,recyspi;
    private  ArrayList<Inputdata> inputList;
    private ArrayList<InputNodata> inputnoList;
    private TextView txtdate,txttime,txtno1,txtno2,txtno3,txtno4,txtno5,txtno6;
    private SharedPreferenceLIB sharedPreferenceLIB;
    private  TextView txtMarquee,txtbidF,txtbidS;
    private String time;
    Final finaldata;
    List<Dateed> dateedlist;
    private ImageView imgrefresh;
    private String month;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //SharedPreferenceLIB.onBackPressSave(getApplicationContext(),"MainActivity");

        getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#FAFAFA\">" + getString(R.string.app_name) + "</font>")));
        button=findViewById(R.id.btnresult);

        recyclerView=findViewById(R.id.recyinput);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView .setLayoutManager(horizontalLayoutManager);
        recyclerView .setHasFixedSize(true);

        sharedPreferenceLIB=new SharedPreferenceLIB(getApplicationContext());


        Calendar c = Calendar.getInstance();


        String[]monthName={"January","February","March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        month=monthName[c.get(Calendar.MONTH)];
        c.add(Calendar.MONTH, -1);
        String monthpre = monthName[c.get(Calendar.MONTH)];

        //[]yearName={2020,2021,2022,2023,2024,2025};
        //year=yearName[c.get(Calendar.YEAR)];
        year=c.get(Calendar.YEAR);
        if (month!=null)
        {
            Data();
        }


        txtdate=findViewById(R.id.txtdate);
        txttime=findViewById(R.id.txttime);
        txtbidF=findViewById(R.id.txtbidF);
        txtbidS=findViewById(R.id.txtbidS);
        txtno1=findViewById(R.id.txtno1);
        txtno2=findViewById(R.id.txtno2);
        txtno3=findViewById(R.id.txtno3);
        txtno4=findViewById(R.id.txtno4);
        txtno5=findViewById(R.id.txtno5);
        txtno6=findViewById(R.id.txtno6);
        imgrefresh=findViewById(R.id.imgrefresh);
        imgrefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent = new Intent(getApplicationContext(), StartActivity.class);
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(restartIntent);//finish Activity.

            }
        });
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());
       // SimpleDateFormat dft = new SimpleDateFormat(" HH:mm");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

        time = simpleDateFormat.format(c.getTime());
       // String formattedDatet = dft.format(c.getTime());
        txtdate.setText(" "+formattedDate);
        txttime.setText(" "+time);

        txtMarquee = (TextView) findViewById(R.id.marqueeText);
        MarqueeData();
        BidData();
        PrizeListData();

        // Now we will call setSelected() method
        // and pass boolean value as true





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                sharedPreferenceLIB.YearSave("2021");
                sharedPreferenceLIB.MonthSave("june");
            }
        });
    }
    private void Data()
    {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<ResultData> call = service.getResultDataBy(month,String.valueOf(year));//by hataya
        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                if (response.isSuccessful())
                {
                    List<Result> resultList=response.body().getResult();

                    if (resultList!=null) {
                        for (int i = 0; i < resultList.size(); i++) {
                           finaldata = resultList.get(i).getaFinal();
                            dateedlist = resultList.get(i).getaFinal().getDateed();
                            //resultList.add(dateedlist);
                        }

                    }
                    Inputdatatapter inputdatatapter=new Inputdatatapter(getApplicationContext(),resultList );
                    recyclerView.setAdapter(inputdatatapter);
                }
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {

            }
        });
    }

    public void Apicall2(){
        String url="";
        RequestQueue queue=  Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>  map= new HashMap<String, String>();
                map.put("month",month);
                map.put("","");
                return map;

            }
        };

        queue.add(jsonObjectRequest);
    }

    private void BidData()
    {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<BidData> call = service.getBidData();
        call.enqueue(new Callback<BidData>() {
            @Override
            public void onResponse(Call<BidData> call, Response<BidData> response) {
                if (response.isSuccessful())
                {
                    List<BidList> bidList =response.body().getBidList();
                    if (bidList!=null) {
                        for (int i = 0; i < bidList.size(); i++) {
                            txtbidF.setText(bidList.get(0).getNumber());
                            txtbidS.setText(bidList.get(0).getNumber1());
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<BidData> call, Throwable t) {

            }
        });

    }
    private void PrizeListData() {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<luckey_prizeData> call = service.getluckey_prizeData();
        call.enqueue(new Callback<luckey_prizeData>() {
            @Override
            public void onResponse(Call<luckey_prizeData> call, Response<luckey_prizeData> response) {
                if (response.isSuccessful())
                {
                    List<PrizeList> prizeList=response.body().getPrizeList();
                    if (prizeList!=null)
                    {
                        txtno1.setText(prizeList.get(0).getNumber1());
                        txtno2.setText(prizeList.get(0).getNumber2());
                        txtno3.setText(prizeList.get(0).getNumber3());
                        txtno4.setText(prizeList.get(0).getNumber4());
                        txtno5.setText(prizeList.get(0).getNumber5());
                        txtno6.setText(prizeList.get(0).getNumber6());


                    }

                }
            }

            @Override
            public void onFailure(Call<luckey_prizeData> call, Throwable t) {

            }
        });
    }

    private void MarqueeData() {
        Apiservice service = api.GetApiClient().create(Apiservice.class);
        Call<MarqueeData> call = service.getMarqueeData();
        call.enqueue(new Callback<MarqueeData>() {
            @Override
            public void onResponse(Call<MarqueeData> call, Response<MarqueeData> response) {

                if (response.isSuccessful())
                {
                    List<MarqueeList> marqueeList=response.body().getMarqueeList();
                    if(marqueeList!=null) {
                        for (int i = 0; i < marqueeList.size(); i++) {
                            txtMarquee.setText(marqueeList.get(i).getMarquee());
                        }
                        txtMarquee.setSelected(true);
                    }

                }
            }

            @Override
            public void onFailure(Call<MarqueeData> call, Throwable t) {

            }
        });
    }




}