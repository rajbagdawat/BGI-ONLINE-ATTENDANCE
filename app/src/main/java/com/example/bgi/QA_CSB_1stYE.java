package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bgi.databinding.ActivityQaCsa1stYeBinding;
import com.example.bgi.databinding.ActivityQaCsb1stYeBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class QA_CSB_1stYE extends AppCompatActivity {


    TextView showdate;
    ImageView sldate;
    int y,m,d;
    ActivityQaCsb1stYeBinding binding;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa_csb1st_ye);
        binding =  ActivityQaCsb1stYeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showdate = findViewById(R.id.show_date);
        sldate = findViewById(R.id.calendericon);

        Calendar c = Calendar.getInstance();
        sldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DATE);

                DatePickerDialog g = new DatePickerDialog(QA_CSB_1stYE.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        showdate.setText(d+"/"+m+"/"+y);

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

                        ListAdapter listAdapter = new ListAdapter(QA_CSB_1stYE.this, userArrayList);

                        binding.listview.setAdapter(listAdapter);
                        binding.listview.setClickable(true);
                        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent i = new Intent(QA_CSB_1stYE.this, Userr_Activity.class);
                                i.putExtra("name", stuname[position]);
                                i.putExtra("enroll", stuenroll[position]);
                                i.putExtra("phone", stuphone[position]);
                                i.putExtra("address", stuaddress[position]);
                                i.putExtra("image", imageId[position]);
                                startActivities(new Intent[]{i});

                            }
                        });

                    }
                },y,m,d);
                g.show();
            }
        });


    }
    public void back(View view){
        Intent intent = new Intent(this  , First_Year_CS_SDBCE.class);
        startActivities(new Intent[]{intent});
    }

}