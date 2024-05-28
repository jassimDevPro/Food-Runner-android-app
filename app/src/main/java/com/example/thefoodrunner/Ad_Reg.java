package com.example.thefoodrunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Ad_Reg extends AppCompatActivity {
    ListView list;
    String resName[]={"Ahmad Restaurant","Jassim Restaurant","Ali Restaurant","Raza Restaurant","Hassan Restaurant","Hamza Restaurant"};
    String resLoc[]={"Lahore","Karachi","Islamabad","Gujranwala","Lahore","Multan"};
    int image[]={R.drawable.rest1,R.drawable.rest2,R.drawable.rest3,R.drawable.rest1,R.drawable.rest2,R.drawable.rest3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_rest);
        getSupportActionBar().setTitle("Restaurant list");
        list = findViewById(R.id.myList);
        MyAdapter adapter = new MyAdapter(Ad_Reg.this, resName, resLoc, image);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(Ad_Reg.this,AhmadRestaurant.class));
                }else if(i==1){
                    startActivity(new Intent(Ad_Reg.this,JassimRestaurant.class));
                }else if(i==2){
                    startActivity(new Intent(Ad_Reg.this,AliRestaurant.class));
                }else if(i==3){
                    startActivity(new Intent(Ad_Reg.this,RazaRestaurant.class));
                }else if(i==4){
                    startActivity(new Intent(Ad_Reg.this,HassanRestaurant.class));
                }else if(i==5){
                    startActivity(new Intent(Ad_Reg.this,HamzaRestaurant.class));
                }else{
                    Toast.makeText(Ad_Reg.this, "Nothing Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();
        if(item_id==R.id.item1){
            Intent intent =new Intent(Ad_Reg.this,Rest_Prof.class);
            startActivity(intent);
            Toast.makeText(this, "NGOs selected", Toast.LENGTH_SHORT).show();
        }
        else if(item_id==R.id.item2){
            Intent intent =new Intent(Ad_Reg.this,Ad_Log.class);
            startActivity(intent);
            Toast.makeText(this, "Logout selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}