package com.example.bgi.mainSubLayout;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.app.appsearch.PutDocumentsRequest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.bgi.Computer_Graphics_CSA_1stYE;
import com.example.bgi.First_Year_CS_SDBCE;
import com.example.bgi.R;
import com.example.bgi.SDBCE_FirstY_CS_A_ListView;
import com.example.bgi.SDBCE_activity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainSubjectLayout extends AppCompatActivity  {
        TextView year_data_sem_data,section_data,subject_one,subject_two,subject_three,subject_four,subject_five,subject_six,subject_seven;
        DatabaseReference db;

    Bundle bundle = new Bundle();

    ProgressDialog progressDialog;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        progressDialog = new ProgressDialog(MainSubjectLayout.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Loading Subjects");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subject_layout);
        year_data_sem_data = findViewById(R.id.year_data_and_sem_data);
        section_data = findViewById(R.id.section_data);
        subject_one = findViewById(R.id.subject_one);
        subject_two = findViewById(R.id.subject_two);
        subject_three = findViewById(R.id.subject_three);
        subject_four = findViewById(R.id.subject_four);
        subject_five = findViewById(R.id.subject_five);
        subject_six = findViewById(R.id.subject_six);
        subject_seven = findViewById(R.id.subject_seven);
        firestore = FirebaseFirestore.getInstance();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
           String value = bundle.getString("c");
           if(value.equals("c1")){
                showfiredata();
           }
           else if(value.equals("c2")){
                showfiredata2();
           }
           else if(value.equals("c3")){
                showfiredata3();
           }
           else if(value.equals("c4")){
                showfiredata4();
           }
           else if(value.equals("s1")){
               showfiredatas1();
           }
           else if(value.equals("s2")){
               showfiredatas2();
           }
           else if(value.equals("s3")){
               showfiredatas3();
           }
           else if(value.equals("s4")){
               showfiredatas4();
           }
           else if(value.equals("t1")){
               showfiredatat1();
           }
           else if(value.equals("t2")){
               showfiredatat2();
           }
           else if(value.equals("t3")){
               showfiredatat3();
           }
           else if(value.equals("t4")){
               showfiredatat4();
           }
           else if(value.equals("f1")){
               showfiredataf1();
           }
           else if(value.equals("f2")){
               showfiredataf2();
           }
           else if(value.equals("f3")){
               showfiredataf3();
           }
           else if(value.equals("f4")){
               showfiredataf4();
           }
        }
        else {

            Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
        }
    }
    public void showfiredata(){
//        Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
//        intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
        progressDialog.show ();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "1st_year_1sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
              if(documentSnapshot.exists()){
                  progressDialog.dismiss();
                  year_data_sem_data.setText((documentSnapshot.getString("1")));
                 section_data.setText((documentSnapshot.getString("2")));
                  subject_one.setText(documentSnapshot.getString("3"));
                  subject_two.setText(documentSnapshot.getString("4"));
                  subject_three.setText(documentSnapshot.getString("5"));
                  subject_four.setText(documentSnapshot.getString("6"));
                  subject_five.setText(documentSnapshot.getString("7"));
                  subject_six.setText(documentSnapshot.getString("8"));
                  subject_seven.setText(documentSnapshot.getString("9"));
//                  Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
//                  intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );

                  subject_one.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_one);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("m1","1");
                          intent.putExtra("subd_sub_one",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  }); subject_two.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_two);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("m2","2");
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("subd_sub_two",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  });subject_three.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_three);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("m3","3");
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("subd_sub_three",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  });subject_four.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_four);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("m4","4");
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("subd_sub_four",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  });subject_five.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_five);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("m5","5");
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("subd_sub_five",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  });subject_six.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_six);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("m6","6");
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("subd_sub_six",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  });subject_seven.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                          TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                          TextView val_sec = (TextView) findViewById(R.id.section_data);
                          TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                          intent.putExtra("sub_year",val_year.getText());
                          intent.putExtra("m7","7");
                          intent.putExtra("subd_sec",val_sec.getText());
                          intent.putExtra("subd_sub_seven",val_sub.getText());
                          intent.putExtra("1sem_student_data_Sec_A" ,"1st Sem Sec-A" );
                          bundle.putString("c","1st Sem Sec-A" );
                          intent.putExtras(bundle);
                          startActivities(new Intent[]{intent });
                      }
                  });
              }else {
                  Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
    public void showfiredata2(){
//        Intent intent = new Intent(this,Recycle_view_main.class);
//        intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
        progressDialog.show ();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "1st_year_1sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");

                    section_data.setText(value);
                    subject_one.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            intent.putExtra("1sem_student_data_Sec_B" ,"1st Sem Sec-B" );
                            bundle.putString("c","1st Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data 2nd", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
 public void showfiredata3 (){
     Intent intent = new Intent(this,Recycle_view_main.class);
     intent.putExtra("2sem_student_data_Sec_A" ,"2nd Sem Sec-A" );
     progressDialog.show();
     firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "1st_year_2sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csa");
                    section_data.setText(value);
//                    Toast.makeText(getApplicationContext(), "show3", Toast.LENGTH_SHORT).show();


                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
 public void showfiredata4(){
     Intent intent = new Intent(this,Recycle_view_main.class);
     intent.putExtra("2sem_student_data_Sec_B" ,"2nd Sem Sec-B" );
     progressDialog.show();
     firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document("1st_year_2sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                progressDialog.dismiss();
                if(documentSnapshot.exists()){
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_two",val_sub.getText());

                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","2nd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showfiredatas1(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("3sem_student_data_Sec_A" ,"3rd Sem Sec-A" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "2nd_year_3sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("s1","s1");
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s2","s2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s3","s3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s4","s4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s5","s5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s6","s6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s7","s7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showfiredatas2(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("3sem_student_data_Sec_B" ,"3rd Sem Sec-B" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document("2nd_year_3sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");
                    section_data.setText(value);
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("s1","s1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s2","s2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s3","s3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s4","s4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s5","s5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s6","s6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s7","s7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","3rd Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showfiredatas3(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("4sem_student_data_Sec_A" ,"4th Sem Sec-A" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "2nd_year_4sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("s1","s1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s2","s2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s3","s3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s4","s4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s5","s5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s6","s6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s7","s7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showfiredatas4(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("4sem_student_data_Sec_B" ,"4th Sem Sec-B" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "2nd_year_4sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");
                    section_data.setText(value);
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("s1","s1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s2","s2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s3","s3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s4","s4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s5","s5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s6","s6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("s7","s7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","4th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
 public void showfiredatat1(){
     Intent intent = new Intent(this,Recycle_view_main.class);
     intent.putExtra("5sem_student_data_Sec_A" ,"5th Sem Sec-A" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "3rd_year_5sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));

//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("t1","t1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t2","t2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t3","t3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t4","t4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t5","t5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t6","t6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t7","t7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showfiredatat2(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("5sem_student_data_Sec_B" ,"5th Sem Sec-B" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "3rd_year_5sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");
                    section_data.setText(value);
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("t1","t1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t2","t2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t3","t3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t4","t4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t5","t5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t6","t6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t7","t7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","5th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showfiredatat3(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("6sem_student_data_Sec_A" ,"6th Sem Sec-A" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document("3rd_year_6sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("t1","t1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t2","t2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t3","t3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t4","t4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t5","t5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t6","t6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t7","t7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showfiredatat4(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("6sem_student_data_Sec_B" ,"6th Sem Sec-B" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document("3rd_year_6sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");
                    section_data.setText(value);
                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("t1","t1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t2","t2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t3","t3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t4","t4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t5","t5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t6","t6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("t7","t7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","6th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
 public void showfiredataf1(){
     Intent intent = new Intent(this,Recycle_view_main.class);
     intent.putExtra("7sem_student_data_Sec_A" ,"7th Sem Sec-A" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "4th_year_7sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "shows1", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","7th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showfiredataf2(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("7sem_student_data_Sec_B" ,"7th Sem Sec-B" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "4th_year_7sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "show2", Toast.LENGTH_SHORT).show();
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");
                    section_data.setText(value);
                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            bundle.putString("c","7th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showfiredataf3(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("8sem_student_data_Sec_A" ,"8th Sem Sec-A" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "4th_year_8sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
//                    Toast.makeText(getApplicationContext(), "show3", Toast.LENGTH_SHORT).show();


                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","8th Sem Sec-A" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showfiredataf4(){
        Intent intent = new Intent(this,Recycle_view_main.class);
        intent.putExtra("8sem_student_data_Sec_B" ,"8th Sem Sec-B" );
        progressDialog.show();
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("CS_Subjects").document(
                "4th_year_8sem_subjects");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    progressDialog.dismiss();
                    year_data_sem_data.setText((documentSnapshot.getString("1")));
//                    section_data.setText((documentSnapshot.getString("2")));
                    subject_one.setText(documentSnapshot.getString("3"));
                    subject_two.setText(documentSnapshot.getString("4"));
                    subject_three.setText(documentSnapshot.getString("5"));
                    subject_four.setText(documentSnapshot.getString("6"));
                    subject_five.setText(documentSnapshot.getString("7"));
                    subject_six.setText(documentSnapshot.getString("8"));
                    subject_seven.setText(documentSnapshot.getString("9"));
                    Bundle bundle = getIntent().getExtras();
                    String value = bundle.getString("csb");
                    section_data.setText(value);
//                    Toast.makeText(getApplicationContext(), "show4", Toast.LENGTH_SHORT).show();

                    subject_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_one);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("m1","1");
                            intent.putExtra("subd_sub_one",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    }); subject_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_two);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m2","2");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_two",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_three);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m3","3");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_three",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_four);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m4","4");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_four",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this,Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_five);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m5","5");
                            intent.putExtra("subd_sec",val_sec.getText());
                            intent.putExtra("subd_sub_five",val_sub.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            startActivities(new Intent[]{intent });
                        }
                    });subject_six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_six);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m6","6");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_six",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });subject_seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainSubjectLayout.this, Recycle_view_main.class);
                            TextView val_year = (TextView) findViewById(R.id.year_data_and_sem_data);
                            TextView val_sec = (TextView) findViewById(R.id.section_data);
                            TextView val_sub = (TextView) findViewById(R.id.subject_seven);
                            intent.putExtra("sub_year",val_year.getText());
                            intent.putExtra("m7","7");
                            intent.putExtra("subd_sec",val_sec.getText());
                            bundle.putString("c","8th Sem Sec-B" );
                            intent.putExtras(bundle);
                            intent.putExtra("subd_sub_seven",val_sub.getText());
                            startActivities(new Intent[]{intent });
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void back(View view){
        Intent intent = new Intent(this  , First_Year_CS_SDBCE.class);
        startActivities(new Intent[]{intent});
    }
}
////        Map<String,Object> users = new HashMap<>();
//////        users.put("firstname","easy");
////        db = FirebaseFirestore.getInstance();
//        db.collection("user").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//        db.collection("user").document("subjectname").addSnapshotListener()
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//