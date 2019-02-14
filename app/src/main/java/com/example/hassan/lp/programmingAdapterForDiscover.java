package com.example.hassan.lp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class programmingAdapterForDiscover extends RecyclerView.Adapter<programmingAdapterForDiscover.ProgrammingViewHolder> {

    private ArrayList<FeaturedModelClass> date;
    Context context;

    public programmingAdapterForDiscover(ArrayList<FeaturedModelClass> date, Context context) {
        this.date = date;
        this.context = context;
    }

    //ye nichy waly parent class jo oper wali h usky mehtod hain

    @NonNull
    @Override
    //ProgrammingViewHolder ye nam khud sy add krlia mene
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //is sy phly list item layout discover ko bnaya ta jo k zrori ta
        LayoutInflater layoutinflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutinflater.inflate(R.layout.list_item_layout_discover, viewGroup, false);

        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ProgrammingViewHolder Holder, int i) {
       final FeaturedModelClass modelClass = date.get(i);
        Holder.textView.setText(modelClass.getName());
        Holder.img.setImageResource(modelClass.getImageChanger());
        Holder.btn.setText(modelClass.getBtnText());

        Holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, modelClass.getBtnText()+" called.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return date.size();
    }


    //ak new class bnaygy ismy khud sy
    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textView;
        Button btn;

        //ider image ,txt view ko access kr rhy h
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.<ImageView>findViewById(R.id.imginDiscoverResource);
            textView= itemView.<TextView>findViewById(R.id.txtinDiscoverResource);
            btn= itemView.<Button>findViewById(R.id.btn);

        }
    }


}
