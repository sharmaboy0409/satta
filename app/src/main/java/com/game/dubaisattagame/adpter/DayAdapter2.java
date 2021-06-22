package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.models.Daylist;

import java.util.List;





    public class DayAdapter2 extends RecyclerView.Adapter<DayAdapter2.MyViewHolder> {
        Context context;
        private List<Daylist> OrderData;



        private List<Daylist> useraddressesList;

        public DayAdapter2(Context context, List<Daylist> orderData) {
            this.context = context;
            OrderData = orderData;
            this.useraddressesList=OrderData;
        }




        @NonNull
        @Override
        public   DayAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_date_data,parent,false);
            DayAdapter2.MyViewHolder myViewHolder=new DayAdapter2.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull DayAdapter2.MyViewHolder holder, final int position) {
            holder.name.setText(useraddressesList.get(position).getDay());


        }

        @Override
        public int getItemCount() {
            if (useraddressesList!=null)
            {
                return 30;
            }
            return 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.txt_date);


            }
        }
    }




