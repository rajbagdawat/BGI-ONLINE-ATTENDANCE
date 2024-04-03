//package com.example.bgi.Models;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.bgi.R;
//import com.example.bgi.Userr_Activity;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class Teacher_adpater {
//    ArrayList<UserModel> userModeArrayList;
//    ArrayList<String> datastudentList = new ArrayList<String>();
//    ArrayList<String> student_data;
//    Context context;
//
//       public Teacher_adpater(ArrayList<UserModel> userModeArrayList , Context context){
//           this.userModeArrayList = userModeArrayList;
//           this.context = context;
//       }
//    public ArrayList<String> getStudent_data() {
//        return student_data;
//    }
//
//    public ArrayList<String> getDatastudentList() {
//        return datastudentList;
//    }
//
//    public void setDatastudentList(ArrayList<String> datastudentList) {
//        this.datastudentList = datastudentList;
//    }
//
//    public Teacher_adpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_users,parent,false);
//
//        return new Teacher_adpater.ViewHolder(view);
//    }
//
//    public void onBindViewHolder(@NonNull Teacher_adpater.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        UserModel userModel = userModeArrayList.get(position);
//        Picasso.get().load(userModel.getProfilepic()).placeholder(R.drawable.stpic).into(holder.image);
//    }
////        holder.studentName.setText(userModel.getName());
////        holder.enrollNo.setText(userModel.getEnroll());
//
////        holder.checkBox_id.setText(userModel1.getCheckbox());
////        holder.checkBox_id.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                if (holder.checkBox_id.isChecked()) {
////                    datastudentList.add(userModeArrayList.get(position).getName());
////                } else {
////
////                    datastudentList.remove(userModeArrayList.get(position).getName());
////                }
////                Toast.makeText(context.getApplicationContext(), datastudentList + "\n" + "\n", Toast.LENGTH_SHORT).show();
////            }
////        });
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context, Userr_Activity.class);
////////                 intent.putExtra("ischecked", "done");
//////                intent.putExtra("profilepic", userModel.getProfilepic());
//////                intent.putExtra("name", userModel.getName());
//////                intent.putExtra("enroll", userModel.getId());
//////                intent.putExtra("mobileno", userModel.getMobileno());
//////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//////                context.startActivities(new Intent[]{intent});
////            }
////        });
//
//
//
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView image;
//        TextView studentName , enrollNo;
//        CheckBox checkBox_id;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            image = itemView.findViewById(R.id.stpic);
//            studentName = itemView.findViewById(R.id.stName);
//            enrollNo = itemView.findViewById(R.id.stEnroll);
//            checkBox_id = itemView.findViewById(R.id.checkBox_id);
//        }
//    }
//
//}
//
