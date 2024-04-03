package com.example.bgi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.databinding.ActivityFirstYearCsBinding;
import com.example.bgi.mainSubLayout.MainSubjectLayout;
import com.example.bgi.mainSubLayout.Recycle_view_main;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class First_Year_CS_SDBCE extends AppCompatActivity {


    ActivityFirstYearCsBinding binding;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year_cs);
        CardView c1  = findViewById(R.id.CS_A_1sty_cs);
        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String value1="c1";
                Intent intent = new Intent(First_Year_CS_SDBCE.this, MainSubjectLayout.class);
                bundle.putString("c",value1);
                intent.putExtras(bundle);
//                intent1.putExtra("c1",value1);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c2 = findViewById(R.id.CS_B_1sty_cs);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
                String value2="c2";
                TextView cs = findViewById(R.id.csbtextview);
                Intent intent = new Intent(First_Year_CS_SDBCE.this, MainSubjectLayout.class);
                bundle.putString("c",value2);
                String csb = cs.getText().toString();
                bundle.putString("csb",csb);
                intent.putExtras(bundle);
                startActivities(new Intent[]{intent });
            }
        });

        CardView c3  = findViewById(R.id.CS_A_1sty_2Sem_cs);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle3 = new Bundle();
                String value3="c3";
                Intent intent = new Intent(First_Year_CS_SDBCE.this, MainSubjectLayout.class);
//                intent.putExtra("c3",value3);
                bundle.putString("c",value3);
                TextView cs = findViewById(R.id.secondsemcsatextview);
                String csa = cs.getText().toString();
                bundle.putString("csa",csa);
                intent.putExtras(bundle);
                startActivities(new Intent[]{intent });
            }
        });
        CardView c4 = findViewById(R.id.CS_B_1sty_2Sem_cs);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle4 = new Bundle();
                String value4="c4";
                Intent intent = new Intent(First_Year_CS_SDBCE.this, MainSubjectLayout.class);
                bundle.putString("c",value4);
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