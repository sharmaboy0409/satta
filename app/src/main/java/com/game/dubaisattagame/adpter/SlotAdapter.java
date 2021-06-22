package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.models.Dateed;
import com.game.dubaisattagame.models.InputNodata;
import com.game.dubaisattagame.models.Result;
import com.game.dubaisattagame.models.SloList;

import java.util.List;


    public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.MyViewHolder> {
        Context context;
        private List<Dateed> OrderData;



        private List<Dateed> useraddressesList;

        public SlotAdapter(Context context, List<Dateed> orderData) {
            this.context = context;
            OrderData = orderData;
            this.useraddressesList=OrderData;
        }




        @NonNull
        @Override
        public   SlotAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.slot_item,parent,false);
            SlotAdapter.MyViewHolder myViewHolder=new SlotAdapter.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull SlotAdapter.MyViewHolder holder, final int position) {
            holder.txt_time.setText( useraddressesList.get(position).getSlot());
           // holder.txt_data.setText(useraddressesList.get(position).getNumber());


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
            TextView txt_time,txt_data;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                txt_time=itemView.findViewById(R.id.txt_time);
                txt_data=itemView.findViewById(R.id.txt_data);


            }
        }
    }


