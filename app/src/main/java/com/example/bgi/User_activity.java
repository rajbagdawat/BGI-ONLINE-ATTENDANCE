package com.example.bgi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bgi.databinding.ActivityUserBinding;

public class User_activity extends AppCompatActivity {
ActivityUserBinding binding;

    public void back(View view){
        Intent intent = new Intent(this  , MainActivity.class);
        startActivities(new Intent[]{intent});
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_user);
        Intent intent = this.getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            String enroll = intent.getStringExtra("enroll");
            String phone = intent.getStringExtra("phone");
            String stAddress = intent.getStringExtra("Adress");
            int imageId = intent.getIntExtra("imageid", R.drawable.r);

            binding.stuname.setText(name);
            binding.stuenroll.setText(enroll);
            binding.stuphone.setText(phone);
            binding.stuaddress.setText(stAddress);
            binding.profileImage.setImageResource(imageId);

        }

    }

}
