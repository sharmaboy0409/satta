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
import com.game.dubaisattagame.models.YearList;
import com.game.dubaisattagame.models.Years;

import java.util.List;


    public class YearAdpter extends RecyclerView.Adapter<YearAdpter.MyViewHolder> {
        Context context;
        private List<YearList> OrderData;
        public int mSelectedItem = -1;



        private List<YearList> useraddressesList;
        private Fragment currentFragment;
        public YearAdpter(Context context, List<YearList> orderData) {
            this.context = context;
            OrderData = orderData;
            this.useraddressesList=OrderData;
        }




        @NonNull
        @Override
        public  YearAdpter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_date,parent,false);
            YearAdpter.MyViewHolder myViewHolder=new YearAdpter.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull YearAdpter.MyViewHolder holder, final int position) {
            holder.name.setText(useraddressesList.get(position).getYear());
            holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton rb=(RadioButton)holder.itemView.findViewById(checkedId);
                    Intent intent = new Intent("custom-message");
                    intent.putExtra("Yearname", useraddressesList.get(position).getYear());
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

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            RadioButton radiobutton;
            RadioGroup radioGroup;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                radiobutton=itemView.findViewById(R.id.radiobutton);
                radioGroup=itemView.findViewById(R.id.radiogroup);
                name=itemView.findViewById(R.id.txtdate);
            }
        }
    }


