package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.bgi.databinding.ActivityCsAlistViewBinding;
import com.example.bgi.databinding.ActivitySdbceSecondYcsAlistViewBinding;
import com.example.bgi.databinding.ActivitySdbceSecondYcsBlistViewBinding;
import com.example.bgi.databinding.ActivitySecondYearBinding;

import java.util.ArrayList;

public class SDBCE_SecondY_CS_A_ListView extends AppCompatActivity {


    ActivitySdbceSecondYcsAlistViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdbce_second_ycs_alist_view);
        binding =  ActivitySdbceSecondYcsAlistViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r,R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r,R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r,R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r};
        String[] stuname = {"Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav","Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama","Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav","Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama"};
        String[] stuenroll = {"0834CS201001", "0834CS201002", "0834CS201003", "0834CS201004", "0834CS201005", "0834CS201006", "0834CS201007", "0834CS201008", "0834CS201009", "0834CS201010", "0834CS201011","0834CS201012", "0834CS201013", "0834CS201014", "0834CS201015", "0834CS201016", "0834CS201017", "0834CS201018", "0834CS201019", "0834CS201020", "0834CS201021", "0834CS201022","0834CS201023", "0834CS201024", "0834CS201025", "0834CS201026", "0834CS201027", "0834CS201028", "0834CS201029", "0834CS201030", "0834CS201031", "0834CS201032", "0834CS201033","0834CS201034", "0834CS201035", "0834CS201036", "0834CS201037", "0834CS201038", "0834CS201039", "0834CS201040", "0834CS201041", "0834CS201042", "0834CS201043", "0834CS201044"};
        String[] stuphone = {"0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000","0000000000","0000000000", "0000000000"};
        String[] stuaddress = {"XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ","XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ","XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ","XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ"};

        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++) {
            User user = new User(stuname[i], stuenroll[i], stuphone[i], stuaddress[i], imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(SDBCE_SecondY_CS_A_ListView.this, userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SDBCE_SecondY_CS_A_ListView.this, Userr_Activity.class);
                i.putExtra("name", stuname[position]);
                i.putExtra("enroll", stuenroll[position]);
                i.putExtra("phone", stuphone[position]);
                i.putExtra("address", stuaddress[position]);
                i.putExtra("image", imageId[position]);
                startActivities(new Intent[]{i});
            }
        });
    }
    public void back(View view){
        Intent intent = new Intent(this  , SDBCE_activity.class);
        startActivities(new Intent[]{intent});
    }

}