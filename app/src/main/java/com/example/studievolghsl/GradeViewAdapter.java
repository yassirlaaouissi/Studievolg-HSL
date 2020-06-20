package com.example.studievolghsl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GradeViewAdapter extends RecyclerView.Adapter<GradeViewAdapter.MyViewHolder> {
    String names[],years[],grades[],types[],ECTS[];
    Context context;

    public GradeViewAdapter(Context ct, String[] s1, String[] s2, String[] s3, String[] s4, String[] s5){
        context = ct;
        names = s1;
        years = s2;
        grades = s3;
        types = s4;
        ECTS = s5;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(names[position]);
        holder.myText2.setText(years[position]);
        holder.myText3.setText(grades[position]);
        holder.myText4.setText(types[position]);
        holder.myText5.setText(ECTS[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2, myText3, myText4, myText5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.vakken_txt);
            myText2 = itemView.findViewById(R.id.jaar_txt);
            myText3 = itemView.findViewById(R.id.Grade_txt);
            myText4 = itemView.findViewById(R.id.TypeOfModule_txt);
            myText5 = itemView.findViewById(R.id.ECTS_txt);
        }
    }
}
