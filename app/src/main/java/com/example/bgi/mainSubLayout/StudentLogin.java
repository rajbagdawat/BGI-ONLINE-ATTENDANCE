package com.example.bgi.mainSubLayout;

import static com.example.bgi.mainSubLayout.Student_Interface.sid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.Forgotstudent;
import com.example.bgi.Main_sdbce_sdbct_page;
import com.example.bgi.Models.UserModel;
import com.example.bgi.R;
import com.example.bgi.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class StudentLogin extends AppCompatActivity {

    FirebaseDatabase database;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;
    boolean checked  = true;
    static String sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        TextView signup = findViewById(R.id.signup);
        TextView ForgotPass = findViewById(R.id.forgotPass);
        EditText email  = (EditText) findViewById(R.id.email);
        EditText pass  = (EditText) findViewById(R.id.password);
        CardView submit = findViewById(R.id.submit_button);

        String emaildata = email.getText().toString();
        String passdata = pass.getText().toString();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(StudentLogin.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login to your account");

        sid =  FirebaseAuth.getInstance().getUid();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty()) {
                    email.setError("Required");
                    email.requestFocus();
                } else if (pass.getText().toString().isEmpty()) {
                    pass.setError("Required");
                    pass.requestFocus();
                } else {
                    progressDialog.show();
                    auth.signInWithEmailAndPassword(email.getText().toString().trim(), pass.getText().toString().trim()).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

//                                progressDialog.dismiss();
//
                    database.getReference().child("1st_year_CS_1sem_Sec-A").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String stukey = dataSnapshot.getKey();
                                    Map map2 = (Map) dataSnapshot.getValue();
                                    String ssemail = map2.get("email").toString();
                                    String sspass = map2.get("conpass").toString();

                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                        progressDialog.dismiss();
                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                        startActivities(new Intent[]{intent});
                                    }else {
                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }}

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
//                                    1sem B
                                    database.getReference().child("1st_year_CS_1sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });

//
//                                    // 2sem A
                                    database.getReference().child("1st_year_CS_2sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    // 2sem B
                                    database.getReference().child("1st_year_CS_2sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//
//                                    //3sem A
                                    database.getReference().child("2nd_year_CS_3sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //3sem B
                                    database.getReference().child("2nd_year_CS_3sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //4sem A
                                    database.getReference().child("2nd_year_CS_4sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//
////                                                 4sem B
                                    database.getReference().child("2nd_year_CS_4sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//
//                                    //5sem A
                                    database.getReference().child("3rd_year_CS_5sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //5sem B
                                    database.getReference().child("3rd_year_CS_5sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//
//                                    //6sem A
                                    database.getReference().child("3rd_year_CS_6sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
//                                                    Toast.makeText(StudentLogin.this, "Login successful", Toast.LENGTH_SHORT).show();

                                                    }else {
                                                        progressDialog.dismiss();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //6sem B
                                    database.getReference().child("3rd_year_CS_6sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        Toast.makeText(StudentLogin.this,

                                                                "Login successful", Toast.LENGTH_SHORT).show();
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//
//                                    //7sem A
                                    database.getReference().child("4th_year_CS_7sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //7sem B
                                    database.getReference().child("4th_year_CS_7sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //8sem A
                                    database.getReference().child("4th_year_CS_8sem_Sec-A").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                        progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    //8sem B
                                    database.getReference().child("4th_year_CS_8sem_Sec-B").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    String stukey = dataSnapshot.getKey();
                                                    Map map2 = (Map) dataSnapshot.getValue();
                                                    String ssemail = map2.get("email").toString();
                                                    String sspass = map2.get("conpass").toString();

                                                    if (email.getText().toString().matches(ssemail) && pass.getText().toString().matches(sspass)) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
                                                        startActivities(new Intent[]{intent});
                                                    }else {
                                                    progressDialog.dismiss();
//                                                    Toast.makeText(StudentLogin.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                                                }
                                                }
                                            }}

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//                                    Intent intent = new Intent(StudentLogin.this, Student_Interface.class);
//                                    startActivities(new Intent[]{intent});
                                }
                            });

                }
             }
        });


                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StudentLogin.this, SignUp.class);
                        startActivities(new Intent[]{intent});
                    }
                });
                ImageView home = findViewById(R.id.home);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StudentLogin.this, Choose_Student_Teacher.class);
                        startActivities(new Intent[]{intent});
                    }
                });
                ForgotPass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StudentLogin.this, Forgotstudent.class);
                        startActivities(new Intent[]{intent});

                    }
                });
            }
    }