package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bgi.mainSubLayout.Choose_Student_Teacher;
import com.example.bgi.mainSubLayout.StudentLogin;

public class Forgotstudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotstudent);
        TextView loginst = findViewById(R.id.loginasstudent);
        loginst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgotstudent.this , StudentLogin.class);
                startActivities(new Intent[]{intent});

            }
        });
        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(Forgotstudent.this , StudentLogin.class);
                startActivities(new Intent[]{intent});
            }
        });
    }
}