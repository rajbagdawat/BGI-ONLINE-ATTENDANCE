package com.example.bgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.bgi.databinding.ActivityMainBinding;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.mainSubLayout.All_login;
import com.example.bgi.mainSubLayout.Choose_Student_Teacher;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.net.HttpCookie;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth auth;
     DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         auth =FirebaseAuth.getInstance();
//        if(auth.getCurrentUser()!=null) {
//            Intent intent = new Intent(MainActivity.this, Main_sdbce_sdbct_page.class);
//            startActivities(new Intent[]{intent});
//        }else {
//            final Intent intent = new Intent(MainActivity.this, Choose_Student_Teacher.class);
//            startActivities(new Intent[]{intent});
//        }
////         drawerLayout = findViewById(R.id.drawer_layer);

    }
//
//    public void ClickMenu(View view){
//        operDrawer(drawerLayout);
//    }
//    private void operDrawer(DrawerLayout drawerLayout){
//        drawerLayout.openDrawer(GravityCompat.START);
//    }
//    public void home(View view){
//        Intent intent = new Intent(this  , Home.class);
//        startActivities(new Intent[]{intent});
//    }
//    public void settings(View view){
//        Intent intent = new Intent(this  , Settings.class);
//        startActivities(new Intent[]{intent});
//    }
//    public void editProfile(View view){
//        Intent intent = new Intent(this  , EditProfile.class);
//        startActivities(new Intent[]{intent});
//    }
//    public void sdbce(View view){
//        Intent intent = new Intent(this, SDBCE_activity.class);
//        startActivity(intent);
//
//    }
//    public void sdbct(View view){
//        Intent intent = new Intent(this, SDBCT_activity.class);
//        startActivity(intent);
//    }
//    public void website(View view){
////        Intent browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://learntodroid.com"))
////        startActivity(browserIntent)
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sdbc.ac.in/"));
//     startActivities(new Intent[]{intent});
//    }
//    public void logout(View view){
//      logoutMenu(MainActivity.this);
//    }
//    private void logoutMenu(MainActivity mainActivity){
//        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
//        builder.setTitle("Logout");
//        builder.setMessage("Are you sure, you want to logout?");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.show();
//    }

}