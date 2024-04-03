package com.example.bgi.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bgi.R;
import com.example.bgi.Userr_Activity;
import com.example.bgi.mainSubLayout.Recycle_view_main;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    ArrayList<UserModel1> userModel1ArrayList;
    ArrayList<UserModel> userModelArrayList;
    public static ArrayList<String> datastudentList = new ArrayList<String>();
    public static ArrayList<String> enrolldatastudentList = new ArrayList<String>();
    ArrayList<String> student_data;
    Context context;


    public UsersAdapter(ArrayList<UserModel1> userModel1ArrayList,Context context1) {
        this.userModel1ArrayList = userModel1ArrayList;
        this.context = context1;
    }

//    public UsersAdapter(ArrayList<UserModel> userModelArrayList,Context context) {
//        this.userModelArrayList = userModelArrayList;
//        this.context = context;
//    }

    public ArrayList<UserModel1> getUserModel1ArrayList() {
        return userModel1ArrayList;
    }

    public void setUserModel1ArrayList(ArrayList<UserModel1> userModel1ArrayList) {
        this.userModel1ArrayList = userModel1ArrayList;
    }

    public ArrayList<String> getStudent_data() {
        return enrolldatastudentList;
    }

    public UsersAdapter() {
        getStudent_data();
    }


    public ArrayList<String> getDatastudentList() {

//        getDatastudentList().clear();
        return datastudentList;
    }

    public void setDatastudentList(ArrayList<String> datastudentList) {
        this.datastudentList = datastudentList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.sample_show_users,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
      UserModel1 userModel1 = userModel1ArrayList.get(position);
//      UserModel userModel = userModelArrayList.get(position);

         Picasso.get().load(userModel1.getProfilepic()).placeholder(R.drawable.stpic).into(holder.image);
//         Picasso.get().load(userModel.getProfilepic()).placeholder(R.drawable.stpic).into(holder.image);
         holder.studentName.setText(userModel1.getName());
         holder.enrollNo.setText(userModel1.getEnroll());

         holder.checkBox_id.setText(userModel1.getCheckbox());
         holder.checkBox_id.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

         if(holder.checkBox_id.isChecked()){
             datastudentList.add(userModel1ArrayList.get(position).getName()+" \n("+userModel1ArrayList.get(position).getEnroll()+")");
         }else {
             datastudentList.remove(userModel1ArrayList.get(position).getName());
         }

            }
         });
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, Userr_Activity.class);
//                 intent.putExtra("ischecked", "done");
                 intent.putExtra("profilepic", userModel1.getProfilepic());
                 intent.putExtra("name", userModel1.getName());
                 intent.putExtra("enroll", userModel1.getEnroll());
                 intent.putExtra("mobileno", userModel1.getMobileno());
                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivities(new Intent[]{intent});
             }
         });



    }



    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return userModel1ArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView studentName , enrollNo;
        CheckBox checkBox_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.stpic);
            studentName = itemView.findViewById(R.id.stName);
            enrollNo = itemView.findViewById(R.id.stEnroll);
           checkBox_id = itemView.findViewById(R.id.checkBox_id);
        }
    }
}
