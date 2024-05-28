package com.example.thefoodrunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Ad_Log extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText email,password;
    Button btnlogin;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_log);
        getSupportActionBar().setTitle("Login");

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnLogIn);
        firebaseAuth = FirebaseAuth.getInstance();
        textView=(TextView)findViewById(R.id.txtView);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String pwd= password.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(Email,pwd).addOnCompleteListener(Ad_Log.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(Ad_Log.this,Ad_Reg.class);
                            startActivity(i);
                            Toast.makeText(Ad_Log.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Ad_Log.this, "not Login success", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ad_Log.this,Ad_Rest.class);
                startActivity(intent);
                Toast.makeText(Ad_Log.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}