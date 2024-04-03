package com.example.bgi;

import static com.example.bgi.R.drawable.stpic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.bgi.databinding.ActivityMainSdbceSdbctPageBinding;
import com.example.bgi.mainSubLayout.All_login;
import com.example.bgi.mainSubLayout.Choose_Student_Teacher;
import com.example.bgi.mainSubLayout.StudentLogin;
import com.example.bgi.mainSubLayout.Student_Interface;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

public class Main_sdbce_sdbct_page extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar  toolbar;
    NavigationView navigationView;
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    ActivityMainSdbceSdbctPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sdbce_sdbct_page);
        binding = ActivityMainSdbceSdbctPageBinding.inflate(getLayoutInflater());
        drawerLayout = findViewById(R.id.drawer_layer);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

//        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        View v = navigationView.getHeaderView(0);
        toggle.syncState();
//        toggle.setDrawerArrowDrawable().setColor(getResources()).getColor(R.color.white);

        storage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        String tid =  FirebaseAuth.getInstance().getUid();
        ImageView pic_img = v.findViewById(R.id.pro_pic);
        TextView name = (TextView) v.findViewById(R.id.pro_name);
        TextView email = v.findViewById(R.id.pro_email);
        database.getReference().child("Teacher_SignUp_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (tid != null) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if (teacherKey.equals(tid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            name.setText(get_name);
                            email.setText(get_email);
                            try{
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(stpic).into(pic_img);
                            }catch (Exception e){
                              String pic_imgdata = String.valueOf(R.drawable.stpic);
                            pic_img.setImageURI(Uri.parse(pic_imgdata));
                            }
                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    public void ClickMenu(View view){
         operDrawer(drawerLayout);
    }
    private void operDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void home(View view){
        Intent intent = new Intent(this  , Home.class);
        startActivities(new Intent[]{intent});
    }
    public void settings(View view){
        Intent intent = new Intent(this  , Show_records.class);
        startActivities(new Intent[]{intent});
    }
    public void editProfile(View view){
        Intent intent = new Intent(this  , EditProfile.class);
        String teacherID = getIntent().getStringExtra("tid");
        startActivities(new Intent[]{intent});
    }
    public void sdbce(View view){
        Intent intent = new Intent(this, SDBCE_activity.class);
        startActivity(intent);

    }
    public void sdbct(View view){
        Intent intent = new Intent(this, SDBCT_activity.class);
        startActivity(intent);
    }
    public void website(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sdbc.ac.in/"));
        startActivities(new Intent[]{intent});
    }
    public void logout(View view){
        logoutMenu(Main_sdbce_sdbct_page.this);
    }
    private void logoutMenu(Main_sdbce_sdbct_page mainActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure, you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=  new Intent(Main_sdbce_sdbct_page.this , Choose_Student_Teacher.class);
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