package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class First_Year_IT_SDBCE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year_it);
    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }
}