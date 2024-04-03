package SDBCT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bgi.R;
import com.example.bgi.SDBCE_activity;

public class First_Year_CS_SDBCT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year_cs_sdbct);

//        CardView c1  = findViewById(R.id.CS_A_1sty_cs);
//        c1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(First_Year_CS_SDBCT.this, Home.class);
//                startActivities(new Intent[]{intent });
//            }
//        });
//        CardView c2 = findViewById(R.id.CS_B_1sty_cs);
//        c2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(First_Year_CS_SDBCT.this, Settings.class);
//                startActivities(new Intent[]{intent });
//            }
//        });
    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }


}