package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.models.Dateed;
import com.game.dubaisattagame.models.Daylist;
import com.game.dubaisattagame.models.Inputdata;
import com.game.dubaisattagame.models.Result;

import java.util.List;


    public class DateAdapter extends RecyclerView.Adapter<DateAdapter.MyViewHolder> {
        Context context;
        private List<Dateed> OrderData;
        List<Result> resultList;
        private List<Dateed> useraddressesList;
        int pos;
        private List<Daylist> orderedlist;
        private  String slotday;

        public DateAdapter(Context context, List<Dateed> orderData, List<Result> resultList,List<Daylist> orderedlist,int pos) {
            this.context = context;
            OrderData = orderData;
            this.resultList=resultList;
            this.useraddressesList=OrderData;
            this.orderedlist=orderedlist;
            this.pos=pos;
        }




        @NonNull
        @Override
        public   DateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_data_date,parent,false);
            DateAdapter.MyViewHolder myViewHolder=new DateAdapter.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull DateAdapter.MyViewHolder holder, final int position) {
            holder.txt_time.setText(OrderData.get(position).res);


            slotday=resultList.get(0).slotday;


           if (resultList.size()!=0) {

               if (Integer.parseInt(orderedlist.get(position).getDay())==pos+1) {
                  // holder.txt_time.setText(useraddressesList.get(position).getRes());

                   //holder.txt_time.setVisibility(View.VISIBLE);
                    //Toast.makeText(context, "hee" + resultList.get(position).getSlotday() + pos+position, Toast.LENGTH_LONG).show();
                }
            }
            Log.d("zzz1", "onResponse: 233  ="+orderedlist.size());
            Log.d("zzz1", "onResponse: 233  ="+orderedlist.get(20).getDay());
            Log.d("zzz1", "onResponse: 233  ="+slotday);

            /* for (int a=0; a<OrderData.size() ; a++ ){
                 if (orderedlist.get(a).getDay().toString().equals(slotday)) {
                     holder.txt_time.setText(OrderData.get(position).res);
                    }

                }*/


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
            TextView name,txt_time;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.txt_date);
                txt_time=itemView.findViewById(R.id.txt_time);



            }
        }
    }




