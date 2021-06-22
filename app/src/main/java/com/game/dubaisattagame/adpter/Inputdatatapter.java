package com.game.dubaisattagame.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.game.dubaisattagame.R;
import com.game.dubaisattagame.models.Dateed;
import com.game.dubaisattagame.models.InputNodata;
import com.game.dubaisattagame.models.Inputdata;
import com.game.dubaisattagame.models.Result;

import java.util.List;


    public class Inputdatatapter extends RecyclerView.Adapter<Inputdatatapter.MyViewHolder> {
        Context context;
       // private List<Result> OrderData;
        private  List<Dateed> dateedList;



        private List<Result> resultList;

        public Inputdatatapter(Context context, List<Result> resultList) {
            this.context = context;

            this.resultList=resultList;
        }




        @NonNull
        @Override
        public   Inputdatatapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_imput,parent,false);
            Inputdatatapter.MyViewHolder myViewHolder=new Inputdatatapter.MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull Inputdatatapter.MyViewHolder holder, final int position) {
            holder.name.setText(resultList.get(position).getSlot());
            dateedList=resultList.get(position).getaFinal().getDateed();
            if (dateedList!=null) {
                for (int i=0;i<dateedList.size();i++) {

                    holder.txtno.setText( dateedList.get(i).getRes());
                    holder.name.setText(dateedList.get(i).getSlot());
                   // Toast.makeText(context, "" + dateedList.get(i).getRes(), Toast.LENGTH_LONG).show();
                }
            }
           //holder.txtno.setText(useraddressesList.get(position).getSlot());


        }

        @Override
        public int getItemCount() {
            if (resultList!=null)
            {
                return resultList.size();
            }
            return 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name,txtno;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.txtimput);
                txtno=itemView.findViewById(R.id.txtno);


            }
        }
    }


