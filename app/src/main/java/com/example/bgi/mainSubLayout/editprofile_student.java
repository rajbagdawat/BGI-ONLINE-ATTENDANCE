package com.example.bgi.mainSubLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgi.EditProfile;
import com.example.bgi.MainActivity;
import com.example.bgi.Models.UserModel1;
import com.example.bgi.R;
import com.example.bgi.databinding.ActivityEditProfileBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class editprofile_student extends AppCompatActivity {

    FirebaseStorage storage;
    FirebaseAuth auth;
    FirebaseDatabase database;
    //    ImageView profile_img = (ImageView) findViewById(R.id.pro_pic);
    static ActivityResultLauncher<Intent> activityResultLauncher;

    ActivityEditProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile_student);
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(editprofile_student.this);
        progressDialog.setTitle("Edit Profile");
        progressDialog.setMessage("Loading Edit Profile data.....");


        ImageView pic_img = findViewById(R.id.imageId);
        TextView name = findViewById(R.id.st_name);
        TextView  id = findViewById(R.id.st_id);
        TextView email = findViewById(R.id.st_email);
        TextView phone = findViewById(R.id.st_phone);
        String studentID = getIntent().getStringExtra("sid");

        storage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        String data =  database.getReference().child("1st_year_CS_1sem_Sec-A").getKey();
//        Toast.makeText(editprofile_student.this,data,Toast.LENGTH_SHORT).show();

        String sid =  FirebaseAuth.getInstance().getUid();
        progressDialog.show();

                        database.getReference().child("1st_year_CS_1sem_Sec-A").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                progressDialog.dismiss();
                                if(sid != null){

                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                        String teacherKey = dataSnapshot.getKey();
                                        if(teacherKey.equals(sid)) {
                                          String get_name = dataSnapshot.child("name").getValue().toString();
                                            String get_email = dataSnapshot.child("email").getValue().toString();
                                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                                            name.setText(get_name);
                                            id.setText(get_id);
                                            email.setText(get_email);
                                            phone.setText(get_mobileno);

                                            try {

                                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);



                                            }catch (Exception e){}


                                        }
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getData() != null) {
                                    final Uri tfile = result.getData().getData();
                                    pic_img.setImageURI(tfile);
                                    Toast.makeText(editprofile_student.this, " Profile pic uploaded", Toast.LENGTH_SHORT).show();
//
                                    final StorageReference reference = storage.getReference().child("student_profile_pic")
                                            .child(FirebaseAuth.getInstance().getUid());
//                                    Toast.makeText(editprofile_student.this,"done",Toast.LENGTH_SHORT).show();
//
                                    reference.putFile(tfile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override

                                                public void onSuccess(Uri uri) {
//                                                    String data =  database.getReference().child("1st_year_CS_1sem_Sec-A").getKey();
//                                                    Toast.makeText(editprofile_student.this,"done",Toast.LENGTH_SHORT).show();
//                                                    if(data.equals("1st_year_CS_1sem_Sec-A")){
                                                  //1sem A
                                                    database.getReference().child("1st_year_CS_1sem_Sec-A").addValueEventListener(new ValueEventListener() {

                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if(student_data.equals(sid)){
                                                                       database.getReference().child("1st_year_CS_1sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("1st_year_CS_1sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("1st_year_CS_2sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("1st_year_CS_2sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("2nd_year_CS_3sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("2nd_year_CS_3sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("2nd_year_CS_4sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("2nd_year_CS_4sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("3rd_year_CS_5sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("3rd_year_CS_5sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("3rd_year_CS_6sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("3rd_year_CS_6sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("4th_year_CS_7sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("4th_year_CS_7sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("4th_year_CS_8sem_Sec-A").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
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
                                                            progressDialog.dismiss();
                                                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                                String student_data = dataSnapshot.getKey();
                                                                if (student_data.equals(sid)) {
                                                                    database.getReference().child("4th_year_CS_8sem_Sec-B").child(FirebaseAuth.getInstance().getUid())
                                                                            .child("profilepic").setValue(uri.toString());
                                                                }
                                                            }

                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError error) {
                                                        }
                                                    });

                                                }
                                            });
                                        }

                                    });
                                }
                            } });


        database.getReference().child("1st_year_CS_1sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);


                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        database.getReference().child("1st_year_CS_2sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



        database.getReference().child("1st_year_CS_2sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        database.getReference().child("2nd_year_CS_3sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        database.getReference().child("2nd_year_CS_3sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



        database.getReference().child("2nd_year_CS_4sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        database.getReference().child("2nd_year_CS_4sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        database.getReference().child("3rd_year_CS_5sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database.getReference().child("3rd_year_CS_5sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database.getReference().child("3rd_year_CS_6sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database.getReference().child("3rd_year_CS_6sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database.getReference().child("4th_year_CS_7sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database.getReference().child("4th_year_CS_7sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database.getReference().child("4th_year_CS_8sem_Sec-A").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {

                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
////
        database.getReference().child("4th_year_CS_8sem_Sec-B").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progressDialog.dismiss();
                if(sid != null){

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String teacherKey = dataSnapshot.getKey();
                        if(teacherKey.equals(sid)) {
                            String get_name = dataSnapshot.child("name").getValue().toString();
                            String get_email = dataSnapshot.child("email").getValue().toString();
                            String get_id = dataSnapshot.child("enroll").getValue().toString();
                            String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                            name.setText(get_name);
                            id.setText(get_id);
                            email.setText(get_email);
                            phone.setText(get_mobileno);
                            try {
                                String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                                Picasso.get().load(get_profilepic).placeholder(R.drawable.stpic).into(pic_img);
                            }catch (Exception e){}
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



    }

    public void back(View view) {
        Intent intent = new Intent(editprofile_student.this, Student_Interface.class);
        startActivities(new Intent[]{intent});
    }

    public void uploadpic(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activityResultLauncher.launch(intent);
//                Toast.makeText(EditProfile.this, "clicked", Toast.LENGTH_SHORT).show();

    }
}