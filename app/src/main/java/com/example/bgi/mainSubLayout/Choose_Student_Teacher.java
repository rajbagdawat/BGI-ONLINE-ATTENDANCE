package com.example.bgi.mainSubLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.First_Year_CS_SDBCE;
import com.example.bgi.Main_sdbce_sdbct_page;
import com.example.bgi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.temporal.Temporal;

public class Choose_Student_Teacher extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    String sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_student_teacher);

//        ImageView img = findViewById(R.id.changeimg);
        CardView stbutton = findViewById(R.id.studentbutton);
        CardView tebutton = findViewById(R.id.teacherbutton);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        sid =  FirebaseAuth.getInstance().getUid();
//        Toast.makeText(getApplicationContext(), sid, Toast.LENGTH_SHORT).show();
        progressDialog = new ProgressDialog(Choose_Student_Teacher.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login to your account");
        database.getReference().child("Teacher_SignUp_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//        progressDialog.show();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    final String teacher_ID = dataSnapshot.getKey();
                    if (teacher_ID.equals(sid)) {
                        Intent intent = new Intent(Choose_Student_Teacher.this, Main_sdbce_sdbct_page.class);
                        progressDialog.dismiss();
                        startActivities(new Intent[]{intent});
                    }
                }
            }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                        database.getReference().child("1st_year_CS_1sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

//                                                    1sem B
                        database.getReference().child("1st_year_CS_1sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                        // 2sem A
                        database.getReference().child("1st_year_CS_2sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                        // 2sem B
                        database.getReference().child("1st_year_CS_2sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //3sem A
                        database.getReference().child("2nd_year_CS_3sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //3sem B
                        database.getReference().child("2nd_year_CS_3sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //4sem A
                        database.getReference().child("2nd_year_CS_4sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

//                                                 4sem B
                        database.getReference().child("2nd_year_CS_4sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //5sem A
                        database.getReference().child("3rd_year_CS_5sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //5sem B
                        database.getReference().child("3rd_year_CS_5sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //6sem A
                        database.getReference().child("3rd_year_CS_6sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //6sem B
                        database.getReference().child("3rd_year_CS_6sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //7sem A
                        database.getReference().child("4th_year_CS_7sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //7sem B
                        database.getReference().child("4th_year_CS_7sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //8sem A
                        database.getReference().child("4th_year_CS_8sem_Sec-A").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        //8sem B
                        database.getReference().child("4th_year_CS_8sem_Sec-B").addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String student_data = dataSnapshot.getKey();
                                    if(student_data.equals(sid)){
                                        Intent intent = new Intent(Choose_Student_Teacher.this, Student_Interface.class);
                                        progressDialog.dismiss();
                                        startActivities(new Intent[]{intent});
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

        tebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Student_Teacher.this, All_login.class);
                startActivities(new Intent[]{intent });
            }
        });
        stbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Student_Teacher.this, StudentLogin.class);
                startActivities(new Intent[]{intent });
            }
        });
    }
}