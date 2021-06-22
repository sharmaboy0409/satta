package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;


import com.game.dubaisattagame.R;
import com.game.dubaisattagame.models.MonthList;
import com.game.dubaisattagame.models.Monthdata;

import java.util.List;


public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MyViewHolder> {
    Context context;
    private List<MonthList> OrderData;



    private List<MonthList> useraddressesList;
    private Fragment currentFragment;
    public MonthAdapter(Context context, List<MonthList> orderData) {
        this.context = context;
        OrderData = orderData;
        this.useraddressesList=OrderData;
    }




    @NonNull
    @Override
    public   MonthAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_date,parent,false);
       MonthAdapter.MyViewHolder myViewHolder=new MonthAdapter.MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MonthAdapter.MyViewHolder holder, final int position) {
        holder.name.setText(useraddressesList.get(position).getMonth());
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton)holder.itemView.findViewById(checkedId);
                Intent intent = new Intent("custom-message");
                intent.putExtra("monthname", useraddressesList.get(position).getMonth());
                intent.putExtra("monthid", useraddressesList.get(position).getMonth_Id());
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        if (useraddressesList!=null)
        {
            return useraddressesList.size();
        }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder    {
        TextView name;
        RadioButton radiobutton;
        RadioGroup radioGroup;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.txtdate);
            radiobutton=itemView.findViewById(R.id.radiobutton);
            radioGroup=itemView.findViewById(R.id.radiogroup);

        }
    }


}
