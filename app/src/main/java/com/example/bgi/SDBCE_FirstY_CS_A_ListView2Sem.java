package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bgi.databinding.ActivityCsAlistViewBinding;
import com.example.bgi.databinding.ActivitySdbceFirstYcsAlistView2SemBinding;

public class SDBCE_FirstY_CS_A_ListView2Sem extends AppCompatActivity {

    ActivitySdbceFirstYcsAlistView2SemBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivitySdbceFirstYcsAlistView2SemBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_sdbce_first_ycs_alist_view2_sem);
        setContentView(binding.getRoot());

        CardView c1  = findViewById(R.id.ComputerGraphicsCSA_FYE);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this, Computer_Graphics_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c2 = findViewById(R.id.MachineLrnCSA_FYE);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this, MachineLrn_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c3 = findViewById(R.id.ComputerNetCSA_FYE);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this,ComputerNet_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });

        CardView c4 = findViewById(R.id.ProjectMg_CSA_FYE);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this,ProjectMg_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c5 = findViewById(R.id.DataAn_CSA_FYE);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this,DataAy_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c6 = findViewById(R.id.QA_CSA_FYE);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this,QA_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c7 = findViewById(R.id.JavaLab_CSA_FYE);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this,Java_CSA_1stYE.class);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c8 = findViewById(R.id.Communication_CSA_FYE);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCE_FirstY_CS_A_ListView2Sem.this,Communi_CSA_1stYE .class);
                startActivities(new Intent[]{intent });
            }
        });

    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }


}