package com.example.bgi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.Models.UserModel;
import com.example.bgi.mainSubLayout.All_login;
import com.example.bgi.mainSubLayout.Choose_Student_Teacher;
import com.example.bgi.mainSubLayout.StudentLogin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Teachersignup extends AppCompatActivity {

    FirebaseFirestore db;
    FirebaseDatabase database;
    private FirebaseAuth auth;
    EditText fullname,id,emailaddress,mobile,pass,conpass;
        ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachersignup);
        TextView loginte = findViewById(R.id.loginasteacher);
        fullname = findViewById(R.id.Fullname);
        id = findViewById(R.id.ID);
        emailaddress = findViewById(R.id.Email);
        mobile = findViewById(R.id.Mobileno);
        pass = findViewById(R.id.Password);
        conpass = findViewById(R.id.ConfirmPassword);
        CardView submit = findViewById(R.id.submit_button);

        auth = FirebaseAuth.getInstance();
        database =FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(Teachersignup.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(emailaddress.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            if(pass.getText().toString().equals(conpass.getText().toString())){
                                String tid = task.getResult().getUser().getUid();
                                String teacherId = tid;
//
                                UserModel userModel = new UserModel(tid,fullname.getText().toString(),id.getText().toString(),emailaddress.getText().toString(),mobile.getText().toString(),pass.getText().toString(),conpass.getText().toString());
                            database.getReference().child("Teacher_SignUp_data").child(tid).setValue(userModel);
                                Intent intent = new Intent(Teachersignup.this, All_login.class);
                                Toast.makeText(Teachersignup.this,"SignUp Successful",Toast.LENGTH_LONG).show();
                                startActivities(new Intent[]{intent});
                            }
                            else {
                                pass.setError("Password and Confirm Password must be same");
                                pass.requestFocus();
                            }
                        }
                        else {
                            Toast.makeText(Teachersignup.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        loginte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Teachersignup.this , All_login.class);
                startActivities(new Intent[]{intent});

            }
        });
        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(Teachersignup.this ,All_login.class);
                startActivities(new Intent[]{intent});
            }
        });

    }
}