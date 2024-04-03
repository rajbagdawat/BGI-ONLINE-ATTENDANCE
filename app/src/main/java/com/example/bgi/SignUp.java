package com.example.bgi;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.Models.UserModel;
import com.example.bgi.Models.UserModel1;
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

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    FirebaseFirestore db;
    TextView stuid,fullname,enroll,emailaddress,mobile,pass,conpass;
    Spinner spinner,spinner2,spinner3;
    FirebaseDatabase database;
    private FirebaseAuth auth;
    String y1,y2,y3,y4,b1,b2,b3,b4,b5,ss1a,ss1b,ss2a,ss2b,ss3a,ss3b,ss4a,ss4b,ss5a,ss5b,ss6a,ss6b,ss7a,ss7b,ss8a,ss8b;
    ProgressDialog progressDialog;
//    ArrayList<Integer> langList = new ArrayList<>();
    String[] Year = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
    String[] branch = {"CS","IT","EC","ME","MBA"};
    String[] sem = {"1st Sem Sec-A","1st Sem Sec-B", "2nd Sem Sec-A","2nd Sem Sec-B","3rd Sem Sec-A","3rd Sem Sec-B","4th Sem Sec-A","4th Sem Sec-B","5th Sem Sec-A","5th Sem Sec-B","6th Sem Sec-A","6th Sem Sec-B","7th Sem Sec-A","7th Sem Sec-B","8th Sem Sec-A","8th Sem Sec-B"};

    FirebaseFirestore firestore;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = findViewById(R.id.Fullname);
        enroll = findViewById(R.id.Enroll);
        emailaddress = findViewById(R.id.EmailAddress);
        mobile = findViewById(R.id.Mobileno);
        pass = findViewById(R.id.Password);
        conpass = findViewById(R.id.ConfirmPassword);
        auth = FirebaseAuth.getInstance();
        database =FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(SignUp.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        spinner = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SignUp.this,R.layout.spinner_item,Year);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                Toast.makeText(SignUp.this,value + " Is Selected ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SignUp.this,R.layout.spinner_item,branch);
        adapter2.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                Toast.makeText(SignUp.this,value + " Is Selected ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SignUp.this,R.layout.spinner_item,sem);
        adapter3.setDropDownViewResource(R.layout.spinner_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                Toast.makeText(SignUp.this,value + " Is Selected ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TextView loginst = findViewById(R.id.loginasstudent);
        CardView submitbutton = findViewById(R.id.submit_button);
        loginst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this , StudentLogin.class);
                startActivities(new Intent[]{intent});
            }
        });
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(emailaddress.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    String year = spinner.getSelectedItem().toString();
                    String branch = spinner2.getSelectedItem().toString();
                    String sem  = spinner3.getSelectedItem().toString();

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            if(pass.getText().toString().equals(conpass.getText().toString())){
                                String id = task.getResult().getUser().getUid();
                                String studentId = id;
//                                for(int i=0;i<sem.length();i++){
//                                    if(SignUp.this.Year[i].equals(year) && SignUp.this.branch[i].equals(branch) && SignUp.this.sem[i].equals(sem) ){
//
//                                    }
//                                }
//                                    Toast.makeText(SignUp.this, sem, Toast.LENGTH_LONG).show();
//                                    Toast.makeText(SignUp.this, year, Toast.LENGTH_LONG).show();
//                                    Toast.makeText(SignUp.this, branch, Toast.LENGTH_LONG).show();

                                //1st year CS
                                if(year.equals("1st Year") && branch.equals("CS") && sem.equals("1st Sem Sec-A" )) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("1st_year_CS_1sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("1st Year") && branch.equals("CS") && sem.equals("1st Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("1st_year_CS_1sem_Sec-B").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("1st Year") && branch.equals("CS") && sem.equals("2nd Sem Sec-A" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("1st_year_CS_2sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 else if(year.equals("1st Year") && branch.equals("CS") && sem.equals("2nd Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("1st_year_CS_2sem_Sec-B").child(id).setValue(userModel1);
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 //2nd year CS
                                else if(year.equals("2nd Year") && branch.equals("CS") && sem.equals("3rd Sem Sec-A" )) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("2nd_year_CS_3sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("2nd Year") && branch.equals("CS") && sem.equals("3rd Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("2nd_year_CS_3sem_Sec-B").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("2nd Year") && branch.equals("CS") && sem.equals("4th Sem Sec-A" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("2nd_year_CS_4sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 else if(year.equals("2nd Year") && branch.equals("CS") && sem.equals("4th Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("2nd_year_CS_4sem_Sec-B").child(id).setValue(userModel1);
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 //3rd year CS
                                else if(year.equals("3rd Year") && branch.equals("CS") && sem.equals("5th Sem Sec-A" )) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("3rd_year_CS_5sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("3rd Year") && branch.equals("CS") && sem.equals("5th Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("3rd_year_CS_5sem_Sec-B").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("3rd Year") && branch.equals("CS") && sem.equals("6th Sem Sec-A" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("3rd_year_CS_6sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 else if(year.equals("3rd Year") && branch.equals("CS") && sem.equals("6th Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("3rd_year_CS_6sem_Sec-B").child(id).setValue(userModel1);
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 //4th year CS
                                else if(year.equals("4th Year") && branch.equals("CS") && sem.equals("7th Sem Sec-A" )) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("4th_year_CS_7sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("4th Year") && branch.equals("CS") && sem.equals("7th Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("4th_year_CS_7sem_Sec-B").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                else if(year.equals("4th Year") && branch.equals("CS") && sem.equals("8th Sem Sec-A" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("4th_year_CS_8sem_Sec-A").child(id).setValue(userModel1);
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }
                                 else if(year.equals("4th Year") && branch.equals("CS") && sem.equals("8th Sem Sec-B" ) ) {
                                    UserModel1 userModel1 = new UserModel1(studentId, fullname.getText().toString(), enroll.getText().toString(), emailaddress.getText().toString(), mobile.getText().toString(), year, branch, sem, pass.getText().toString(), conpass.getText().toString());
                                    database.getReference().child("4th_year_CS_8sem_Sec-B").child(id).setValue(userModel1);
                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
//                                    Toast.makeText(SignUp.this, "SignUp Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SignUp.this, StudentLogin.class);
                                    startActivities(new Intent[]{intent});
                                }



                                }
                            else {
                                pass.setError("Password and Confirm Password must be same");
                                pass.requestFocus();
                            }
                        }
                        else {
                            Toast.makeText(SignUp.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });


                ImageView home = findViewById(R.id.home);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SignUp.this, StudentLogin.class);
                        startActivities(new Intent[]{intent});
                    }
                });

            }
        }