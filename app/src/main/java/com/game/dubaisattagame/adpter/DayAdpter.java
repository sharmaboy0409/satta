package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.constant.Apiservice;
import com.game.dubaisattagame.constant.api;
import com.game.dubaisattagame.models.Dateed;
import com.game.dubaisattagame.models.Daylist;
import com.game.dubaisattagame.models.Final;
import com.game.dubaisattagame.models.Inputdata;
import com.game.dubaisattagame.models.Result;
import com.game.dubaisattagame.models.ResultData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DayAdpter extends RecyclerView.Adapter<DayAdpter.MyViewHolder> {
         private Context context;
         private List<Daylist> OrderData;

         private List<Daylist> useraddressesList;
         private  String slotday;
         private String date;
         private Final finaldata;

         List<Dateed> dateedlist;
        List<Result> resultList;


        public DayAdpter(Context context, List<Daylist> orderData, List<Dateed> dateedlist,List<Result> resultList) {
            this.context = context;
            OrderData = orderData;
            this.useraddressesList=OrderData;
              this. dateedlist=dateedlist;
              this.resultList=resultList;

        }

        @NonNull
        @Override
        public   DayAdpter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_date_data,parent,false);
            DayAdpter.MyViewHolder myViewHolder=new DayAdpter.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull DayAdpter.MyViewHolder holder, final int position) {
            holder.name.setText(useraddressesList.get(position).getDay());
             date=useraddressesList.get(position).getDay();
             int pos=position;

            for (int i=0;i<dateedlist.size();i++){
                //Log.d("zzz", "onBindViewHolder: " +resultList.get(i).getSlotday());
            }

            if (resultList!=null) {
                for (int i=0;i<resultList.size();i++)
                {
                    finaldata = resultList.get(i).getaFinal();
                    dateedlist=finaldata.getDateed();
                    slotday=resultList.get(i).getSlotday();
                }


                Log.d("aaa1", "onResponse: "+resultList.size());
                Log.d("aaa1", "onResponse: "+useraddressesList.get(position).ciurrentday);
                Log.d("aaa1", "onResponse: "+finaldata);
                Log.d("aaa1", "onResponse: "+slotday);
                Log.d("aaa1", "onResponse: "+dateedlist);
                Log.d("aaa1", "onResponse: 233  ="+OrderData.size());


                if (useraddressesList!=null) {
                    // slotday=resultList.get(position).getSlotday();//yaha se date ke niche data aayega
                    DateAdapter dateAdapter = new DateAdapter(context, dateedlist,resultList,OrderData,pos);
                    // Toast.makeText(context, ""  + position, Toast.LENGTH_LONG).show();
                    holder.recyclerdate.setAdapter(dateAdapter);

                }




                for (int a=0; a<OrderData.size() ; a++ ){

                    if (OrderData.get(a).getDay().toString().equals(slotday)) {
                        //Toast.makeText(context.getApplicationContext(),"all good"+a,Toast.LENGTH_LONG).show();

                        //DateAdapter dateAdapter = new DateAdapter(context, dateedlist,resultList,OrderData,pos);
                        // Toast.makeText(context, ""  + position, Toast.LENGTH_LONG).show();
                        //holder.recyclerdate.setAdapter(dateAdapter);
                       // slotday=resultList.get(position).getSlotday();//yaha se date ke niche data aayega
                      // DateAdapter dateAdapter = new DateAdapter(context, dateedlist,resultList,pos);
                        // Toast.makeText(context, ""  + position, Toast.LENGTH_LONG).show();
                       // holder.recyclerdate.setAdapter(dateAdapter);

                    }

                }
            }



        }

        @Override
        public int getItemCount() {
            if (useraddressesList!=null)
            {
                return useraddressesList.size();
            }
            return 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            private final RecyclerView recyclerdate;
            LinearLayoutManager horizontaltimem
                    = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                name=itemView.findViewById(R.id.txt_date);
                recyclerdate=itemView.findViewById(R.id.rec_Date);
                recyclerdate.setLayoutManager(horizontaltimem);
                recyclerdate.setHasFixedSize(true);


            }


        }

    }

