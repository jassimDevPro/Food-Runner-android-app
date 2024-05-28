package com.example.thefoodrunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Ad_Rest extends AppCompatActivity {
    EditText email,password,phone,name;
    Button btnsignup,btnsignin;
    FirebaseFirestore fstore;
    String uid;
    FirebaseAuth fireebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_reg);
        getSupportActionBar().setTitle("Sign Up");

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        btnsignin=findViewById(R.id.btnSignIn);
        btnsignup=findViewById(R.id.btnSignUp);

        fireebaseAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String pwd= password.getText().toString();
                String Name=name.getText().toString();
                String Phone=phone.getText().toString();

                fireebaseAuth.createUserWithEmailAndPassword(Email,pwd).addOnCompleteListener(Ad_Rest.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            uid= fireebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fstore.collection("data").document(uid);
                            Map<String,Object> user =new HashMap<>();
                            user.put("name",Name);
                            user.put("phone",Phone);
                            user.put("email",Email);
                            documentReference.set(user).addOnSuccessListener(Ad_Rest.this, new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Intent i=new Intent(Ad_Rest.this,Ad_Log.class);
                                    startActivity(i);

                                    Toast.makeText(Ad_Rest.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else{
                            Toast.makeText(Ad_Rest.this, "Not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Ad_Rest.this,Ad_Log.class);
                startActivity(i);
            }
        });
    }
}