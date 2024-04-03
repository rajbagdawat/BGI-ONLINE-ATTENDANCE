package com.example.bgi.mainSubLayout;

import static android.widget.AdapterView.*;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.ListAdapter;
import com.example.bgi.Models.UserModel;
import com.example.bgi.Models.UserModel1;
import com.example.bgi.Models.UsersAdapter;
import com.example.bgi.R;
import com.example.bgi.SignUp;
import com.example.bgi.User;
import com.example.bgi.Userr_Activity;
import com.example.bgi.databinding.ActivityRecycleSubjectLayoutBinding;
import com.example.bgi.ui.Login.Login_Activity;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RecycleSubjectLayout extends AppCompatActivity {


    TextView showdate, setd_sub, setd_year;
    ImageView sldate;
    FirebaseFirestore firestore;
    FirebaseDatabase database;
    DatabaseReference db;
    CheckBox checkBox;
    ListView listView;
    int[] imageId = {R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r};
    String[] stuname = {"Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav", "Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama", "Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav", "Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama"};
    String[] stuenroll = {"0834CS201001", "0834CS201002", "0834CS201003", "0834CS201004", "0834CS201005", "0834CS201006", "0834CS201007", "0834CS201008", "0834CS201009", "0834CS201010", "0834CS201011", "0834CS201012", "0834CS201013", "0834CS201014", "0834CS201015", "0834CS201016", "0834CS201017", "0834CS201018", "0834CS201019", "0834CS201020", "0834CS201021", "0834CS201022", "0834CS201023", "0834CS201024", "0834CS201025", "0834CS201026", "0834CS201027", "0834CS201028", "0834CS201029", "0834CS201030", "0834CS201031", "0834CS201032", "0834CS201033", "0834CS201034", "0834CS201035", "0834CS201036", "0834CS201037", "0834CS201038", "0834CS201039", "0834CS201040", "0834CS201041", "0834CS201042", "0834CS201043", "0834CS201044"};
    String[] stuphone = {"0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000"};
    String[] stuaddress = {"XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ"};

    //    private CheckboxCheckedListner checkedlistner;
    int y, m, d;
    ActivityRecycleSubjectLayoutBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycleSubjectLayoutBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_recycle_subject_layout);
        setContentView(binding.getRoot());
        checkBox = findViewById(R.id.checkBox);

        String m1 = "1", m2 = "2", m3 = "3", m4 = "4", m5 = "5", m6 = "6", m7 = "7";
        setd_sub = (TextView) findViewById(R.id.subject_data);
        setd_year = (TextView) findViewById(R.id.yeardata_semdata);

        if (m1.equals(getIntent().getStringExtra("m1"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_one"));
        } else if (m2.equals(getIntent().getStringExtra("m2"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_two"));
        } else if (m3.equals(getIntent().getStringExtra("m3"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_three"));
        } else if (m4.equals(getIntent().getStringExtra("m4"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_four"));
        } else if (m5.equals(getIntent().getStringExtra("m5"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_five"));
        } else if (m6.equals(getIntent().getStringExtra("m6"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_six"));
        } else if (m7.equals(getIntent().getStringExtra("m7"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_seven"));
        }

//            TextView setd_sub=(TextView) findViewById(R.id.subject_data);
//            TextView setd_year=(TextView) findViewById(R.id.yeardata_semdata);
//            setd_sub.setText(getIntent().getStringExtra("subd_sub_two"));
//            setd_year.setText(getIntent().getStringExtra("sub_year")+" "+getIntent().getStringExtra("subd_sec"));


        showdate = findViewById(R.id.show_date);
        sldate = findViewById(R.id.calendericon);

        Calendar c = Calendar.getInstance();

        sldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DATE);

                DatePickerDialog g = new DatePickerDialog(RecycleSubjectLayout.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        showdate.setText(d + "/" + m + "/" + y);

//                        ArrayList<UserModel1> userModel1ArrayList = new ArrayList<>();
//
//                        UsersAdapter adapter = new UsersAdapter(userModel1ArrayList,getApplicationContext());
//
//
//                        ArrayList<User> userArrayList = null;
//                        for (int i = 0; i < imageId.length; i++) {
//                            User user = new User(stuname[i], stuenroll[i], stuphone[i], stuaddress[i], imageId[i]);
//                            userArrayList.add(user);
//                        }
//                        ListAdapter listAdapter = new ListAdapter(RecycleSubjectLayout.this, userArrayList);
//                        binding.listview.setAdapter(listAdapter);
//
////
//
//                        binding.listview.setClickable(true);
//                        binding.listview.setOnItemClickListener(new OnItemClickListener() {
//                            @Override
//                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                Intent i = new Intent(RecycleSubjectLayout.this, Userr_Activity.class);
//                                i.putExtra("name", stuname[position]);
//                                i.putExtra("enroll", stuenroll[position]);
//                                i.putExtra("phone", stuphone[position]);
//                                i.putExtra("address", stuaddress[position]);
//                                i.putExtra("image", imageId[position]);
//                                binding.listview.getAdapter().getItem(position);
//                                startActivities(new Intent[]{i});
//
//                            }
//                        });
//                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                            @Override
//                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                String itemSelected = "Selected items : \n";
//                                for(int i=0;i<binding.listview.getCount();i++){
////                                    if(checkBox.isChecked()) {
////                                        itemSelected += checkBox.getId() + "\n";
////                                    }
//                                }
//                                Toast.makeText(RecycleSubjectLayout.this, itemSelected, Toast.LENGTH_SHORT).show();

//                            }
//                        });
                    }
                }, y, m, d);
                g.show();
            }
        });
        TextView submitdata = findViewById(R.id.submit_button_overall);
        submitdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmitData();
            }
        });

    }

    public void back(View view) {
        Intent intent = new Intent(this, MainSubjectLayout.class);
        startActivities(new Intent[]{intent});
    }

    public void SubmitData() {
//        users.put("firstname","easy");
        Map<String, Object> users = new HashMap<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("user").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            //        db.collection("user").document("subjectname").addSnapshotListener()
            @Override
            public void onSuccess(DocumentReference documentReference) {
//                String yeardata = setd_year.getText().toString();
//                String semdata = setd_sub.getText().toString();
//                String datedata = showdate.getText().toString();
//                TextView datetxt =  (TextView)findViewById(R.id.datetxt);
//                String datename = datetxt.getText().toString();
//                users.put(y)
//                users.put(yeardata,semdata);
//                users.put(datename,datedata);
//                Intent intent = new Intent(RecycleSubjectLayout.this, Choose_Student_Teacher.class);
//                startActivities(new Intent[]{intent});

//                checkBox.isChecked()
//                binding.listview.setOnItemSelectedListener(new OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        for (int i = 0; i < listView.getAdapter().getCount(); i++) {
////                                    if (checkBox.isChecked()) {
//                            if (checkBox.isChecked()) {
//                                Toast.makeText(RecycleSubjectLayout.this, position+ " Is Selected ",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                int id = item.getItemId();
//                if(id == R.id.item_done){
//                    String itemSelected = "Selected items : \n";
//                    for(int i=0;i<binding.listview.getCount();i++){
//                        if(binding.listview.isItemChecked(i)){
//                            itemSelected += binding.listview.getItemAtPosition(i) + "\n";
//                            itemSelected += binding.listview.getSelectedItem() + "\n";
////                            itemSelected += stuname[i]+ stuenroll[i];
//                        }
//                    }
//                    Toast.makeText(RecycleSubjectLayout.this, itemSelected, Toast.LENGTH_SHORT).show();
//                }
//                });
//                binding.listview.getAdapter().getItem(position);
//                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item_done){
            String itemSelected = "Selected items : \n";
            for(int i=0;i<listView.getCount();i++){
                if(listView.isItemChecked(i)){
                    itemSelected += listView.getItemAtPosition(i) + "\n";
                }
            }
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
