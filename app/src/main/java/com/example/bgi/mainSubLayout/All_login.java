package com.example.bgi.mainSubLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.Forgotstudent;
import com.example.bgi.Forgotteacher;
import com.example.bgi.MainActivity;
import com.example.bgi.Main_sdbce_sdbct_page;
import com.example.bgi.Models.UserModel;
import com.example.bgi.Models.UserModel1;
import com.example.bgi.R;
import com.example.bgi.SignUp;
import com.example.bgi.Teachersignup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class All_login extends AppCompatActivity {

    FirebaseDatabase database;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_login);

        EditText email = findViewById(R.id.Email);
        EditText pass = findViewById(R.id.Password);
       CardView submit = findViewById(R.id.submit_button);
       TextView signup = findViewById(R.id.signup);
       ImageView home = findViewById(R.id.home);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(All_login.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login to your account");

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=  new Intent(All_login.this , Teachersignup.class);
               startActivities(new Intent[]{intent});
           }
       });
       home.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=  new Intent(All_login.this ,Choose_Student_Teacher.class);
               startActivities(new Intent[]{intent});
           }
       });
        TextView ForgotPass = findViewById(R.id.forgotPass);
        ForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_login.this , Forgotteacher.class);
                startActivities(new Intent[]{intent});

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty()){
                    email.setError("Required");
                    email.requestFocus();
                }
                else if (pass.getText().toString().isEmpty()){
                    pass.setError("Required");
                    pass.requestFocus();
                }else {
                progressDialog.show ();
                auth.signInWithEmailAndPassword(email.getText().toString().trim(),pass.getText().toString().trim()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {

              boolean check = false;
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                       if(task.isSuccessful()) {
                               String tid = task.getResult().getUser().getUid();
                               String teacherID = tid;
                           database.getReference().child("Teacher_SignUp_data").addValueEventListener(new ValueEventListener() {
                               @Override
                               public void onDataChange(@NonNull DataSnapshot snapshot) {
                                   for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                      final String teacher_ID  = dataSnapshot.getKey();
                                        if(teacher_ID.equals(teacherID)){
                                           Intent intent = new Intent(All_login.this, Main_sdbce_sdbct_page.class);

                                          intent.putExtra("tid",teacherID);
                                       Toast.makeText(All_login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                           startActivities(new Intent[]{intent});
                                       }else {
                                          check = true;
                                       }
                               }
                               }

                               @Override
                               public void onCancelled(@NonNull DatabaseError error) {

                               }
                           });



                       }
                       else {
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                       }
                    }
                });
            }}
        });
    }
}
