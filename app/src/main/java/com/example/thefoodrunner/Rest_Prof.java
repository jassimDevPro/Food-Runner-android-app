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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Rest_Prof extends AppCompatActivity {
    ListView list;
    String resName[]={"Ahmad NGO","Jassim NGO","Ali NGO","Raza NGO","Hassan NGO","Hamza NGO"};
    String resLoc[]={"Karachi","Gujranwala","Lahore","Islamabad","Kashmir","Multan"};
    int image[]={R.drawable.rest1,R.drawable.rest2,R.drawable.rest3,R.drawable.rest1,R.drawable.rest2,R.drawable.rest3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_rest);
        getSupportActionBar().setTitle("NGOs list");
        list=findViewById(R.id.myList);
        MyAdapter adapter=new MyAdapter(Rest_Prof.this,resName,resLoc,image);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.main_menu_2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();
        if(item_id==R.id.item3){
            Intent intent =new Intent(Rest_Prof.this,Ad_Reg.class);
            startActivity(intent);
            Toast.makeText(this, "Restaurant List selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}