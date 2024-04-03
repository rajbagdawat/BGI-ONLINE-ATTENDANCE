package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bgi.databinding.ActivityUserrBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class Userr_Activity extends AppCompatActivity {

    ActivityUserrBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
    public void back(View view){
        Intent intent = new Intent(this  , MainActivity.class);
        startActivities(new Intent[]{intent});
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserrBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_userr);
        setContentView(binding.getRoot());
//        Intent intent = this.getIntent();
//        if(intent != null){
//            String name = intent.getStringExtra("name");
//            String enroll = intent.getStringExtra("enroll");
//            String phone = intent.getStringExtra("phone");
//            String stAddress = intent.getStringExtra("Adress");
//            int imageId = intent.getIntExtra("imageid", R.drawable.r);


            database = FirebaseDatabase.getInstance();
            auth = FirebaseAuth.getInstance();
            String teacherId = auth.getUid();
            String studentpic = getIntent().getStringExtra("profilepic");
            String studentname = getIntent().getStringExtra("name");
            String studentenroll = getIntent().getStringExtra("enroll");
            String studentmobile = getIntent().getStringExtra("mobileno");
//        Toast.makeText(this,studentname,Toast.LENGTH_LONG).show();

            Picasso.get().load(studentpic).placeholder(R.drawable.stpic).into(binding.imageId);
            binding.stuname.setText(studentname);
            binding.stuenroll.setText(studentenroll);
            binding.stuphone.setText(studentmobile);
//        }

    }

}
