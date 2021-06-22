package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.models.Inputdata;

import java.util.List;


    public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {
        Context context;
        private List<Inputdata> OrderData;



        private List<Inputdata> useraddressesList;

        public TimeAdapter(Context context, List<Inputdata> orderData) {
            this.context = context;
            OrderData = orderData;
            this.useraddressesList=OrderData;
        }




        @NonNull
        @Override
        public   TimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_time,parent,false);
            TimeAdapter.MyViewHolder myViewHolder=new TimeAdapter.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull TimeAdapter.MyViewHolder holder, final int position) {
            holder.name.setText(useraddressesList.get(position).getInputdata());


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

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.txt_time);


            }
        }
    }




