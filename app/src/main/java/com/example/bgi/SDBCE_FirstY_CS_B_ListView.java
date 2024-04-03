package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.bgi.databinding.ActivityCsAlistViewBinding;
import com.example.bgi.databinding.ActivityCsBlistViewBinding;
import com.example.bgi.databinding.ActivityFirstYearCsSdbctBinding;

import java.util.ArrayList;

public class SDBCE_FirstY_CS_B_ListView extends AppCompatActivity {

    ActivityCsBlistViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_blist_view);
        binding = ActivityCsBlistViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CardView c1  = findViewById(R.id.ComputerGraphicsCSB_FYE);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this, Computer_Graphics_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c2 = findViewById(R.id.MachineLrnCSB_FYE);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this, MachineLrn_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c3 = findViewById(R.id.ComputerNetCSB_FYE);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this,ComputerNet_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });

        CardView c4 = findViewById(R.id.ProjectMg_CSB_FYE);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this,ProjectMg_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c5 = findViewById(R.id.DataAn_CSB_FYE);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this,DataAy_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c6 = findViewById(R.id.QA_CSB_FYE);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this,QA_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c7 = findViewById(R.id.JavaLab_CSB_FYE);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this,Java_CSB_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c8 = findViewById(R.id.Communication_CSB_FYE);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_B_ListView.this,Communi_CSB_1stYE .class);
                startActivities(new Intent[]{intent });
            }
        });

    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }


}