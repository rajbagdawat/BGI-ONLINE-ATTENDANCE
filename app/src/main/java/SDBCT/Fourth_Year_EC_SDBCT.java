package SDBCT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bgi.R;
import com.example.bgi.SDBCE_activity;

public class Fourth_Year_EC_SDBCT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_year_ec);
    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }
}