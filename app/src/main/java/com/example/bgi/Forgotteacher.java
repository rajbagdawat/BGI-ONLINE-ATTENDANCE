package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bgi.mainSubLayout.All_login;
import com.example.bgi.mainSubLayout.Choose_Student_Teacher;
import com.example.bgi.mainSubLayout.StudentLogin;

public class Forgotteacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotteacher);
        TextView loginst = findViewById(R.id.loginasteacher);
        loginst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgotteacher.this , All_login.class);
                startActivities(new Intent[]{intent});

            }
        });
        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(Forgotteacher.this , All_login.class);
                startActivities(new Intent[]{intent});
            }
        });
    }
}