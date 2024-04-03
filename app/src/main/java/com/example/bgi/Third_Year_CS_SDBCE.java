package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bgi.databinding.ActivityFirstYearCsBinding;
import com.example.bgi.mainSubLayout.MainSubjectLayout;

public class Third_Year_CS_SDBCE extends AppCompatActivity {

    Bundle bundle = new Bundle();
//    ActivityFirstYearCsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_year_cs);
        CardView c1  = findViewById(R.id.CS_A_3sty_5Sem_cs);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1="t1";
                Intent intent = new Intent(Third_Year_CS_SDBCE.this, MainSubjectLayout.class);
                bundle.putString("c",value1);
                intent.putExtras(bundle);
//                intent1.putExtra("c1",value1);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c2 = findViewById(R.id.CS_B_3sty_5Sem_cs);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
                String value2="t2";
                Intent intent = new Intent(Third_Year_CS_SDBCE.this, MainSubjectLayout.class);
                bundle.putString("c",value2);
                intent.putExtras(bundle);
                TextView cs = findViewById(R.id.csbtextview);
                bundle.putString("c",value2);
                String csb = cs.getText().toString();
                bundle.putString("csb",csb);
                intent.putExtras(bundle);
                startActivities(new Intent[]{intent });
            }
        });

        CardView c3  = findViewById(R.id.CS_A_3sty_6Sem_cs);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle3 = new Bundle();
                String value3="t3";
                Intent intent = new Intent(Third_Year_CS_SDBCE.this, MainSubjectLayout.class);
//                intent.putExtra("c3",value3);
                bundle.putString("c",value3);
                intent.putExtras(bundle);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c4 = findViewById(R.id.CS_B_3sty_6Sem_cs);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle4 = new Bundle();
                String value4="t4";
                Intent intent = new Intent(Third_Year_CS_SDBCE.this, MainSubjectLayout.class);
                bundle.putString("c",value4);
                intent.putExtras(bundle);
                TextView cs = findViewById(R.id.csbtextview);
                bundle.putString("c",value4);
                String csb = cs.getText().toString();
                bundle.putString("csb",csb);
                intent.putExtras(bundle);
//                intent.putExtra("c4",value4);
                startActivities(new Intent[]{intent });
            }
        });




    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }


}