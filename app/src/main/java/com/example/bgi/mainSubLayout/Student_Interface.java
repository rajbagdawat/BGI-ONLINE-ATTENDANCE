package com.example.bgi.mainSubLayout;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.Models.Show_record_adpter;
import com.example.bgi.Models.UserModel1;

import com.example.bgi.R;
import com.example.bgi.Show_records;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;


public class Student_Interface extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FirebaseAuth auth;
    Spinner spinner4,spinner5;
    FirebaseDatabase database;
    static Map CS_attendance_data;
    static String value1;
    static String value2, sname ,semail,spropic ;
   static String subject_data;
  static ArrayList<String> subject_list = new ArrayList<>();
  static ArrayList<String> date_list = new ArrayList<>();
  static ArrayList<String> stu_list = new ArrayList<>();
    static Map yeardata;
    static Map subjectdata;
    static Map datedata;
    static Map map;
   static String name_enroll;
    NavigationView navigationView;
    ArrayList<UserModel1> userModel1ArrayList = new ArrayList<UserModel1>() ;
    RecyclerView recyclerView;
    static TextView name,email;
    static String sid,stuid;
    static ImageView pic_img;
   static String year_semdata,setname,setemail,setpic;
    static ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_interface);
        drawerLayout = findViewById(R.id.drawer_layer);
        auth = FirebaseAuth.getInstance();
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        sid =  FirebaseAuth.getInstance().getUid();
        recyclerView = findViewById(R.id.Recycleview);

        drawerLayout = findViewById(R.id.drawer_layer);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

//        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        View v = navigationView.getHeaderView(0);
        toggle.syncState();
         pic_img = v.findViewById(R.id.pro_pic);
        name = (TextView) v.findViewById(R.id.pro_name);
        email = v.findViewById(R.id.pro_email);
//        Toast.makeText(this, sid, Toast.LENGTH_SHORT).show();
        ChooseSubject();
    }

    private void ChooseSubject() {

        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(Student_Interface.this);
        progressDialog.setTitle("Edit Profile");
        progressDialog.setMessage("Loading Edit Profile data.....");


        ImageView pic_img = findViewById(R.id.imageId);
        TextView name = findViewById(R.id.st_name);
        TextView id = findViewById(R.id.st_id);
        TextView email = findViewById(R.id.st_email);
        TextView phone = findViewById(R.id.st_phone);
        String studentID = getIntent().getStringExtra("sid");

        database.getReference().child("1st_year_CS_1sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                        Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child("1st_year_CS_1sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("1st_year_CS_2sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("1st_year_CS_2sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                         sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("2nd_year_CS_3sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("2nd_year_CS_3sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("2nd_year_CS_4sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("2nd_year_CS_4sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("3rd_year_CS_5sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("3rd_year_CS_5sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("3rd_year_CS_6sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("3rd_year_CS_6sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("4th_year_CS_7sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("4th_year_CS_7sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("4th_year_CS_8sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); database.getReference().child("4th_year_CS_8sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String fsem_Sec_B = dataSnapshot.getKey();
                            Map map2 = (Map) dataSnapshot.getValue();
                        String ssname = map2.get("name").toString();
                        String ssemail = map2.get("email").toString();
                        String sspic;
                        try{
                            sspic = map2.get("profilepic").toString();
                        }
                        catch (Exception e){
                            sspic = String.valueOf(R.drawable.stpic);
                        }
                        if (fsem_Sec_B.matches(sid)) {
                            stuid = fsem_Sec_B;
                            map = map2;
                            setname = ssname;
                            setemail = ssemail;
                            setpic = sspic;
                            setdata();
                        }
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void setdata() {
            String year = map.get("year").toString();
            String branch = map.get("branch").toString();
            String sem = map.get("sem_section").toString();
            String stuname = map.get("name").toString();
            String stuenroll = map.get("enroll").toString();
            name.setText(setname);
            email.setText(setemail);
             Picasso.get().load(setpic).placeholder(R.drawable.stpic).into(pic_img);

//                             Toast.makeText(Student_Interface.this,name_enroll, Toast.LENGTH_SHORT).show();
            year_semdata = year + " " + branch + " " + sem;
            name_enroll = stuname + " \n(" + stuenroll + ")";
            database.getReference().child("CS_SDBCE_attendance").child(year_semdata).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (sid != null) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            String sublist = dataSnapshot.getKey();
                            subject_list.add(dataSnapshot.getKey());

                            ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(Student_Interface.this, R.layout.spinner_item, subject_list);
                            adapter4.setDropDownViewResource(R.layout.spinner_item);
                            spinner4.setAdapter(adapter4);
                            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @SuppressLint("SuspiciousIndentation")
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    value1 = parent.getItemAtPosition(position).toString();
//
                                    database.getReference().child("CS_SDBCE_attendance").child(year_semdata).child(value1).addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                date_list.add(dataSnapshot.getKey());
                                                ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(Student_Interface.this, R.layout.spinner_item, date_list);
                                                adapter5.setDropDownViewResource(R.layout.spinner_item);
                                                spinner5.setAdapter(adapter5);
                                                spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                    @Override
                                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                        value2 = parent.getItemAtPosition(position).toString();
//
                                                        database.getReference().child("CS_SDBCE_attendance").child(year_semdata).child(value1).child(value2).addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                    String student_data = dataSnapshot.getValue().toString();
                                                                    if(name_enroll.equals(student_data)) {
                                                                        userModel1ArrayList.add(new UserModel1(name_enroll));
                                                                    }

                                                                }
                                                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                                                Show_record_adpter adpter = new Show_record_adpter(userModel1ArrayList,getApplicationContext());
                                                                recyclerView.setAdapter(adpter);
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {

                                                            }
                                                        });
                                                        userModel1ArrayList.clear();


                                                    }



                                                    @Override
                                                    public void onNothingSelected(AdapterView<?> parent) {

                                                    }
                                                });

                                            }
//
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                    date_list.clear();

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            subject_list.clear();
            map.clear();
    }

    public void ClickMenu(View view){
        operDrawer(drawerLayout);
    }
    private void operDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void editProfile(View view){
        Intent intent = new Intent(this  , editprofile_student.class);
        startActivities(new Intent[]{intent});
    }

    public void website(View view){
//        Intent browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://learntodroid.com"))
//        startActivity(browserIntent)
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sdbc.ac.in/"));
        startActivities(new Intent[]{intent});
    }
    public void logout(View view){
        logoutMenu(Student_Interface.this);
    }
    private void logoutMenu(Student_Interface mainActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure, you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=  new Intent(Student_Interface.this , Choose_Student_Teacher.class);
                auth.signOut();
                startActivities(new Intent[]{intent});
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}