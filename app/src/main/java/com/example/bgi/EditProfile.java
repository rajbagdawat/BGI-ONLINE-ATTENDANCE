package com.example.bgi;

import static com.example.bgi.R.drawable.stpic;

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

import com.example.bgi.Models.UserModel;
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

public class EditProfile extends AppCompatActivity {
    FirebaseStorage storage;
    FirebaseAuth auth;
    FirebaseDatabase database;
//    ImageView profile_img = (ImageView) findViewById(R.id.pro_pic);
    ActivityResultLauncher<Intent> activityResultLauncher;

ActivityEditProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_edit_profile);
//        Intent intent = this.getIntent();

        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(EditProfile.this);
        progressDialog.setTitle("Edit Profile");
        progressDialog.setMessage("Loading Edit Profile data.....");


        ImageView pic_img = findViewById(R.id.imageId);
        TextView name = findViewById(R.id.st_name);
        TextView  id = findViewById(R.id.st_id);
        TextView email = findViewById(R.id.st_email);
        TextView phone = findViewById(R.id.st_phone);
        String teacherID = getIntent().getStringExtra("tid");

        storage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        String tid =  FirebaseAuth.getInstance().getUid();
        progressDialog.show();

        database.getReference().child("Teacher_SignUp_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    progressDialog.dismiss();
                    if(tid != null){

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                           String teacherKey = dataSnapshot.getKey();
                    if(teacherKey.equals(tid)) {

                        String get_name = dataSnapshot.child("name").getValue().toString();
                        String get_email = dataSnapshot.child("email").getValue().toString();
                        String get_id = dataSnapshot.child("id").getValue().toString();
                        String get_mobileno = dataSnapshot.child("mobileno").getValue().toString();
                    name.setText(get_name);
                    id.setText(get_id);
                    email.setText(get_email);
                    phone.setText(get_mobileno);
                        try{
                            String get_profilepic = dataSnapshot.child("profilepic").getValue().toString();
                            Picasso.get().load(get_profilepic).placeholder(stpic).into(pic_img);
                        }catch (Exception e){
                            String pic_imgdata = String.valueOf(R.drawable.stpic);

                        }
                    }
                }

            }}

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
                   Toast.makeText(EditProfile.this, " Profile pic uploaded", Toast.LENGTH_SHORT).show();
//                     img.setImageURI(tfile);
                    final StorageReference reference = storage.getReference().child("teacher_profile_pic")
                            .child(FirebaseAuth.getInstance().getUid());
                    reference.putFile(tfile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    database.getReference().child("Teacher_SignUp_data").child(FirebaseAuth.getInstance().getUid())
                                            .child("profilepic").setValue(uri.toString());

                                }
                            });
                        }

                    });
                }
            } }); }

            public void back(View view) {
                Intent intent = new Intent(EditProfile.this, Main_sdbce_sdbct_page.class);
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