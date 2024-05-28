package com.example.thefoodrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RazaRestaurant extends AppCompatActivity {
    Button btnAddBurger,btnAddPizza,btnAddShawarma,btnAddPlatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza_restaurant);
        getSupportActionBar().setTitle("Raza Restaurant");

        btnAddBurger=findViewById(R.id.addBurger);
        btnAddPizza=findViewById(R.id.addPizza);
        btnAddShawarma=findViewById(R.id.addShawarma);
        btnAddPlatter=findViewById(R.id.addPlatter);

        btnAddBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RazaRestaurant.this,AddFood.class);
                startActivity(intent);
                Toast.makeText(RazaRestaurant.this, "clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        btnAddPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RazaRestaurant.this,AddFood.class);
                startActivity(intent);
                Toast.makeText(RazaRestaurant.this, "clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        btnAddShawarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RazaRestaurant.this,AddFood.class);
                startActivity(intent);
                Toast.makeText(RazaRestaurant.this, "clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        btnAddPlatter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RazaRestaurant.this,AddFood.class);
                startActivity(intent);
                Toast.makeText(RazaRestaurant.this, "clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}