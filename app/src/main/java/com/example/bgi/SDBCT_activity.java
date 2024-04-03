package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import SDBCT.First_Year_CS_SDBCT;

public class SDBCT_activity extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4,textView5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdbct);
        textView1 = findViewById(R.id.ComputerScienceSDBCT);
//        textView2 = findViewById(R.id.InformationTecno);
//        textView3 = findViewById(R.id.ElectronicComm);
//        textView4 = findViewById(R.id.Mechanical);
//        textView5 = findViewById(R.id.MBA);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
//        textView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog2();
//            }
//        });
//        textView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog3();
//            }
//        });
//        textView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog4();
//            }
//        });
//        textView5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog5();
//            }
//        });
//

    }
    public void back(View view){
        Intent intent = new Intent(this  , MainActivity.class);
        startActivities(new Intent[]{intent});
    }

    private void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_cs_sdbce);
        CardView c1 = dialog.findViewById(R.id.firstycs);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , First_Year_CS_SDBCT.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c2 = dialog.findViewById(R.id.secondycs);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Second_Year_CS_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c3 = dialog.findViewById(R.id.thirdycs);

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Third_Year_CS_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c4 = dialog.findViewById(R.id.fourthycs);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Fourth_Year_CS_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
//
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    private void showDialog2(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_it_sdbce);

        CardView c1 = dialog.findViewById(R.id.firstyit);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , First_Year_IT_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c2 = dialog.findViewById(R.id.secondyit);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Second_Year_IT_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c3 = dialog.findViewById(R.id.thirdyit);

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Third_Year_IT_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c4 = dialog.findViewById(R.id.fourthyit);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Fourth_Year_IT_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    private void showDialog3(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_ec_sdbce);

        CardView c1 = dialog.findViewById(R.id.firstyec);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , First_Year_EC_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c2 = dialog.findViewById(R.id.secondyec);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Second_Year_EC_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c3 = dialog.findViewById(R.id.thirdyec);

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Third_Year_EC_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c4 = dialog.findViewById(R.id.fourthyec);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Fourth_Year_EC_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    private void showDialog4(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_me_sdbce);
        CardView c1 = dialog.findViewById(R.id.firstyme);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , First_Year_ME_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c2 = dialog.findViewById(R.id.secondyme);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Second_Year_ME_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c3 = dialog.findViewById(R.id.thirdyme);

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Third_Year_ME_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c4 = dialog.findViewById(R.id.fourthyme);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Fourth_Year_ME_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    private void showDialog5(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_mba_sdbce);
        CardView c1 = dialog.findViewById(R.id.firstymba);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , First_Year_MBA_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        CardView c2 = dialog.findViewById(R.id.secondymba);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDBCT_activity.this  , Second_Year_MBA_SDBCE.class);
                startActivities(new Intent[]{intent});
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
