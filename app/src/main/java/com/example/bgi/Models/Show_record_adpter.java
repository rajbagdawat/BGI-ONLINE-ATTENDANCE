package com.example.bgi.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgi.R;
import com.example.bgi.Show_records;

import java.util.ArrayList;

public class Show_record_adpter extends RecyclerView.Adapter<Show_record_adpter.ViewHolder>{

   public static ArrayList<UserModel1> stlist;
    Context context;

    public Show_record_adpter(ArrayList<UserModel1> arrayList,Context context) {
        this.stlist = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_records,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Show_records sr = new Show_records();
//         name =   sr.getStudentdata();
//        Picasso.get().load(userModel1.getProfilepic()).placeholder(R.drawable.stpic).into(holder.stupic);
//        holder.stuname.setText(name.get(position));
//        holder.stuname.setText(name.toString());

        holder.stuname.setText(stlist.get(position).getStuname());
    }

    @Override
    public int getItemCount() {
        return stlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView stupic;
        TextView stuname , stuenroll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stupic = itemView.findViewById(R.id.stuimageView);
            stuname = itemView.findViewById(R.id.stuName);
            stuenroll = itemView.findViewById(R.id.stuEnroll);

        }
    }
}
