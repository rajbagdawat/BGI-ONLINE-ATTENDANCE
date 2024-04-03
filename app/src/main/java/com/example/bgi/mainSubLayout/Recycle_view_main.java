package com.example.bgi.mainSubLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.Models.UserModel1;
import com.example.bgi.Models.UsersAdapter;
import com.example.bgi.R;
import com.example.bgi.Show_records;
import com.example.bgi.SignUp;
import com.example.bgi.Userr_Activity;
import com.example.bgi.databinding.ActivityRecycleViewMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Recycle_view_main extends AppCompatActivity {
    TextView showdate, setd_sub, setd_year;
    ImageView sldate,showrecords;
    FirebaseFirestore firestore;
    Bundle bundle = new Bundle();

    FirebaseStorage storage;
    FirebaseAuth auth;
    FirebaseDatabase database;
     public static String get_name;
    public static ArrayList<String> data;

    CheckBox checkBox;
    StringBuffer stringBuffer = null;
    ListView listView;
    int[] imageId = {R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r, R.drawable.r};
    String[] stuname = {"Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav", "Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama", "Raj Bagdawat", "Ravi", "Raja", "Rajesh ", "Ramu", "Ravan", "Patel", "Illiya", "Vedant", "Kinara", "Vebhav", "Ravan", "Rajput", "Shubham", "Hitakshi", "Chetan", "Shyam", "Himanshu", "Kala", "Mahesh", "Rajaaa", "Rama"};
    String[] stuenroll = {"0834CS201001", "0834CS201002", "0834CS201003", "0834CS201004", "0834CS201005", "0834CS201006", "0834CS201007", "0834CS201008", "0834CS201009", "0834CS201010", "0834CS201011", "0834CS201012", "0834CS201013", "0834CS201014", "0834CS201015", "0834CS201016", "0834CS201017", "0834CS201018", "0834CS201019", "0834CS201020", "0834CS201021", "0834CS201022", "0834CS201023", "0834CS201024", "0834CS201025", "0834CS201026", "0834CS201027", "0834CS201028", "0834CS201029", "0834CS201030", "0834CS201031", "0834CS201032", "0834CS201033", "0834CS201034", "0834CS201035", "0834CS201036", "0834CS201037", "0834CS201038", "0834CS201039", "0834CS201040", "0834CS201041", "0834CS201042", "0834CS201043", "0834CS201044"};
    String[] stuphone = {"0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000"};
    String[] stuaddress = {"XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ", "XYZ"};
    ArrayList<UserModel1> userModel1ArrayList ;
    //    private CheckboxCheckedListner checkedlistner;
    int y, m, d;
    ProgressDialog progressDialog;
    ArrayList<String> data_studentlist = new ArrayList<>();
    ActivityRecycleViewMainBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_main);
        binding = ActivityRecycleViewMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_recycle_subject_layout);
        setContentView(binding.getRoot());
        checkBox = findViewById(R.id.checkBox);
        progressDialog = new ProgressDialog(Recycle_view_main.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Loading Student Data");

        String m1 = "1", m2 = "2", m3 = "3", m4 = "4", m5 = "5", m6 = "6", m7 = "7";
        String s1 = "s1", s2 = "s2", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6", s7 = "s7";
        String t1 = "t1", t2 = "t2", t3 = "t3", t4 = "t4", t5 = "t5", t6 = "t6", t7 = "t7";
        String f1 = "f1", f2 = "f2", f3 = "f3", f4 = "f4", f5 = "f5", f6 = "f6", f7 = "f7";
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

        if (s1.equals(getIntent().getStringExtra("s1"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_one"));
        } else if (s2.equals(getIntent().getStringExtra("s2"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_two"));
        } else if (s3.equals(getIntent().getStringExtra("s3"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_three"));
        } else if (s4.equals(getIntent().getStringExtra("s4"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_four"));
        } else if (s5.equals(getIntent().getStringExtra("s5"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_five"));
        } else if (s6.equals(getIntent().getStringExtra("s6"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_six"));
        } else if (s7.equals(getIntent().getStringExtra("s7"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_seven"));
        }

        if (t1.equals(getIntent().getStringExtra("t1"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_one"));
        } else if (t2.equals(getIntent().getStringExtra("t2"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_two"));
        } else if (t3.equals(getIntent().getStringExtra("t3"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_three"));
        } else if (t4.equals(getIntent().getStringExtra("t4"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_four"));
        } else if (t5.equals(getIntent().getStringExtra("t5"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_five"));
        } else if (t6.equals(getIntent().getStringExtra("t6"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_six"));
        } else if (t7.equals(getIntent().getStringExtra("t7"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_seven"));
        }

        if (f1.equals(getIntent().getStringExtra("f1"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_one"));
        } else if (f2.equals(getIntent().getStringExtra("f2"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_two"));
        } else if (f3.equals(getIntent().getStringExtra("f3"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_three"));
        } else if (f4.equals(getIntent().getStringExtra("f4"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_four"));
        } else if (f5.equals(getIntent().getStringExtra("f5"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_five"));
        } else if (f6.equals(getIntent().getStringExtra("f6"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_six"));
        } else if (f7.equals(getIntent().getStringExtra("f7"))) {
            setd_year.setText(getIntent().getStringExtra("sub_year") + " " + getIntent().getStringExtra("subd_sec"));
            setd_sub.setText(getIntent().getStringExtra("subd_sub_seven"));
        }

        showdate = findViewById(R.id.show_date);
        sldate = findViewById(R.id.calendericon);
        showrecords = findViewById(R.id.showrecords);

        Calendar c = Calendar.getInstance();

        showrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recycle_view_main.this, Show_records.class);
                startActivities(new Intent[]{intent});
            }
        });

        sldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DATE);

                DatePickerDialog g = new DatePickerDialog(Recycle_view_main.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        progressDialog.show ();
                        showdate.setText(d + ":" + m + ":" + y);
                        database = FirebaseDatabase.getInstance();
//
//                        ArrayList<UserModel1> userModel1ArrayList = new ArrayList<>();
                        userModel1ArrayList = new ArrayList<>();
                        ArrayList<String> Checkeddata = new ArrayList<>();

                        stringBuffer = new StringBuffer();
                        UsersAdapter adapter = new UsersAdapter(userModel1ArrayList,getApplicationContext());
                        binding.Recycleview.setAdapter(adapter);

                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.Recycleview.setLayoutManager(layoutManager);
                        String student_sec_A = getIntent().getStringExtra("1sem_student_data_Sec_A");
//
                        Bundle bundle = getIntent().getExtras();
                        if (bundle != null) {
                            String value = bundle.getString("c");
                            if(value.equals("1st Sem Sec-A")){
//                                Toast.makeText(Recycle_view_main.this,value,Toast.LENGTH_LONG).show();
                                database.getReference().child("1st_year_CS_1sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                 @Override
                                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                                     progressDialog.dismiss();
                                     for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                         UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                         userModel1.getStudentId(dataSnapshot.getKey());
                                         userModel1ArrayList.add(userModel1);

                                     }
                                     adapter.notifyDataSetChanged();
                                 }

                                 @Override
                                 public void onCancelled(@NonNull DatabaseError error) {

                                 }
                             });
                            }
                            else if(value.equals("1st Sem Sec-B")) {
                                database.getReference().child("1st_year_CS_1sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("2nd Sem Sec-A")) {
                                database.getReference().child("1st_year_CS_2sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("2nd Sem Sec-B")) {
                                database.getReference().child("1st_year_CS_2sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("3rd Sem Sec-A")) {
                                database.getReference().child("2nd_year_CS_3sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("3rd Sem Sec-B")) {
                                database.getReference().child("2nd_year_CS_3sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("4th Sem Sec-A")) {
                                database.getReference().child("2nd_year_CS_4sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("4th Sem Sec-B")) {
                                database.getReference().child("2nd_year_CS_4sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else if(value.equals("5th Sem Sec-A")) {
                                database.getReference().child("3rd_year_CS_5sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                                else if(value.equals("5th Sem Sec-B")){
                                database.getReference().child("3rd_year_CS_5sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                 @Override
                                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                                     progressDialog.dismiss();
                                     for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                         UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                         userModel1.getStudentId(dataSnapshot.getKey());
                                         userModel1ArrayList.add(userModel1);
                                     }
                                     adapter.notifyDataSetChanged();
                                 }

                                 @Override
                                 public void onCancelled(@NonNull DatabaseError error) {

                                 }
                             });
                            }
                            else if(value.equals("6th Sem Sec-A")){
                                database.getReference().child("3rd_year_CS_6sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }  else if(value.equals("6th Sem Sec-B")){
                                database.getReference().child("3rd_year_CS_6sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }  else if(value.equals("7th Sem Sec-A")){
                                database.getReference().child("4th_year_CS_7sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }  else if(value.equals("7th Sem Sec-B")){
                                database.getReference().child("4th_year_CS_7sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }  else if(value.equals("8th Sem Sec-A")){
                                database.getReference().child("4th_year_CS_8sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }  else if(value.equals("8th Sem Sec-B")){
                                database.getReference().child("4th_year_CS_8sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        progressDialog.dismiss();
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            UserModel1 userModel1 = dataSnapshot.getValue(UserModel1.class);
                                            userModel1.getStudentId(dataSnapshot.getKey());
                                            userModel1ArrayList.add(userModel1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }

                         }
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

        TextView datetxt = findViewById(R.id.datetxt);
        String yeardata = setd_year.getText().toString();
        String semdata = setd_sub.getText().toString();
        String datedata = showdate.getText().toString();
        String datename = datetxt.getText().toString();
        String data_data  = datename+datedata;
//        String replaced_date =  data_data.replace(":",",");

        storage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        String tid =  FirebaseAuth.getInstance().getUid();
        progressDialog.show();
//        Toast.makeText(Recycle_view_main.this, data_data.replace(":",","),Toast.LENGTH_LONG).show();

        database.getReference().child("Teacher_SignUp_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(tid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(tid)) {

//                              get_name = dataSnapshot.child("name").getValue().toString();
//                            Toast.makeText(Recycle_view_main.this,data_data,Toast.LENGTH_LONG).show();

                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



        if(yeardata.equals("1st year CS (1st SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            data = new ArrayList<>();
            ArrayList<String> enroll_data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            enroll_data = adapter.getStudent_data();
//            Toast.makeText(Recycle_view_main.this,""+enroll_data,Toast.LENGTH_SHORT).show();
            database.getReference().child("CS_SDBCE_attendance").child("1st Year CS 1st Sem Sec-A").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
            enroll_data.clear();
        }
        else if(yeardata.equals("1st year CS (1st SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("1st Year CS 1st Sem Sec-B").child(semdata  ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("1st year CS (2nd SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("1st Year CS 2nd Sem Sec-A").child(semdata).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("1st year CS (2nd SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("1st Year CS 2nd Sem Sec-B").child(semdata  ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("2nd year CS (3rd SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("2nd Year CS 3rd Sem Sec-A").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("2nd year CS (3rd SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("2nd Year CS 3rd Sem Sec-B").child(semdata).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("2nd year CS (4th SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("2nd Year CS 4th Sem Sec-A").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("2nd year CS (4th SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("2nd Year CS 4th Sem Sec-B").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("3rd year CS (5th SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("3rd Year CS 5th Sem Sec-A").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("3rd year CS (5th SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("3rd Year CS 5th Sem Sec-B").child(semdata).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("3rd year CS (6th SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("3rd Year CS 6th Sem Sec-A").child(semdata).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("3rd year CS (6th SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("3rd Year CS 6th Sem Sec-B").child(semdata  ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("4th year CS (7th SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("4th Year CS 7th Sem Sec-A").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("4th year CS (7th SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("4th Year CS 7th Sem Sec-B").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("4th year CS (8th SEM) CS - A")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("4th Year CS 8th Sem Sec-A").child(semdata ).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }
        else if(yeardata.equals("4th year CS (8th SEM) CS - B")) {
            UsersAdapter adapter = new UsersAdapter();
            ArrayList<String> data = new ArrayList<>();
            data =   adapter.getDatastudentList();
            database.getReference().child("CS_SDBCE_attendance").child("4th Year CS 8th Sem Sec-B").child(semdata).child((datename+datedata)).setValue(data);
            Toast.makeText(Recycle_view_main.this,"Record Submitted",Toast.LENGTH_LONG).show();
            data.clear();
        }

    }

}
