package com.example.bgi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bgi.Models.Show_record_adpter;
import com.example.bgi.Models.UserModel1;
import com.example.bgi.Models.UsersAdapter;
import com.example.bgi.databinding.ActivityShowRecordsBinding;
import com.example.bgi.mainSubLayout.RecycleSubjectLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class Show_records extends AppCompatActivity {

    String[] Year = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
    String[] branch = {"CS","IT","EC","ME","MBA"};
    String[] sem = {"1st Sem Sec-A","1st Sem Sec-B", "2nd Sem Sec-A","2nd Sem Sec-B","3rd Sem Sec-A","3rd Sem Sec-B","4th Sem Sec-A","4th Sem Sec-B","5th Sem Sec-A","5th Sem Sec-B","6th Sem Sec-A","6th Sem Sec-B","7th Sem Sec-A","7th Sem Sec-B","8th Sem Sec-A","8th Sem Sec-B"};
    Spinner spinner,spinner2,spinner3,spinner4,spinner5;
   static String[] semmdata = new String[500];
    FirebaseStorage storage;
    ArrayList<String> list = new ArrayList<String>();
    static ArrayList<String> semdata = new ArrayList<String>();
    static ArrayList<String> subdata = new ArrayList<String>();
    static ArrayList<String> datadata = new ArrayList<String>();
    FirebaseAuth auth;
    static String value;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    ActivityShowRecordsBinding binding;
    static String student_data;
    ArrayList<UserModel1> userModel1ArrayList = new ArrayList<UserModel1>() ;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);

//        spinner = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        recyclerView = findViewById(R.id.Recycleview);
        storage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        String sid =  FirebaseAuth.getInstance().getUid();


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Show_records.this,R.layout.spinner_item,branch);
        adapter2.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        String branchsl = spinner2.getSelectedItem().toString();

        if(branchsl.equals("CS")) {
            database.getReference().child("CS_SDBCE_attendance").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    progressDialog.dismiss();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String sem_data = dataSnapshot.getKey();
                        semdata.add(sem_data);
                        //                        Toast.makeText(Show_records.this,sem_data,Toast.LENGTH_SHORT).show();
                    }
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Show_records.this, R.layout.spinner_item, semdata);
                    adapter3.setDropDownViewResource(R.layout.spinner_item);
                    spinner3.setAdapter(adapter3);
                    spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            value = parent.getItemAtPosition(position).toString();
                               sem_selected();

                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }

                    });

                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            semdata.clear();
        }

    }

    private void sem_selected() {


        database.getReference().child("CS_SDBCE_attendance").child(value).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    progressDialog.dismiss();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String sub_data = dataSnapshot.getKey();
                    subdata.add(sub_data);

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(Show_records.this, R.layout.spinner_item, subdata);
                    adapter4.setDropDownViewResource(R.layout.spinner_item);
                    spinner4.setAdapter(adapter4);
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String value2 = parent.getItemAtPosition(position).toString();
//                                Toast.makeText(Show_records.this, value2, Toast.LENGTH_SHORT).show();

                            database.getReference().child("CS_SDBCE_attendance").child(value).child(value2).addValueEventListener(new ValueEventListener() {

                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                        String date_data = dataSnapshot.getKey();
                                        datadata.add(date_data);
//                                        Toast.makeText(Show_records.this, date_data, Toast.LENGTH_SHORT).show();

                                        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(Show_records.this, R.layout.spinner_item, datadata);
                                        adapter5.setDropDownViewResource(R.layout.spinner_item);
                                        spinner5.setAdapter(adapter5);
                                        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                    String student_value = parent.getItemAtPosition(position).toString();
//                                                  Toast.makeText(Show_records.this, student_value, Toast.LENGTH_SHORT).show();

                                                    database.getReference().child("CS_SDBCE_attendance").child(value).child(value2).child(student_value).addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getValue().toString();
//                                                                Toast.makeText(Show_records.this, student_data, Toast.LENGTH_SHORT).show();
                                                               userModel1ArrayList.add(new UserModel1(student_data));
                                                            }
//

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
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                            datadata.clear();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
                    subdata.clear();

    }
    public ArrayList<String> getStudentdata(){
        return datadata;
    }

            public void back(View view){
        Intent intent = new Intent(this  , Main_sdbce_sdbct_page.class);
        startActivities(new Intent[]{intent});
    }
}