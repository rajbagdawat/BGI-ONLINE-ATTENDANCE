package com.example.bgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {
    public ListAdapter(Context context, ArrayList<User> userArrayList){
        super(context,R.layout.list_item,userArrayList);
    }
    @Override
     public View getView(int position,  View convertView,ViewGroup parent) {
        User user = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
      ImageView stuimageView = convertView.findViewById(R.id.stuimageView);
      TextView stuName = convertView.findViewById(R.id.stuName);
      TextView stuEnroll = convertView.findViewById(R.id.stuEnroll);

      stuimageView.setImageResource(user.imageId);
      stuName.setText(user.name);
      stuEnroll.setText(user.enrollno);

        return convertView;
    }
}
