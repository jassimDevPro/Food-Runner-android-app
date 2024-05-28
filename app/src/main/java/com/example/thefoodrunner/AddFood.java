package com.example.thefoodrunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirestoreRegistrar;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddFood extends AppCompatActivity {
    ListView TVlist;
    ArrayList<home_data_modal> dataModalArrayList;
    FirebaseFirestore fstore;
    EditText fdName,quantity;
    Button btnAdd;
    DatabaseReference ref;
    Food food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        getSupportActionBar().setTitle("Add Food");

        TVlist = findViewById(R.id.tvlist);
        dataModalArrayList = new ArrayList<>();
        fstore = FirebaseFirestore.getInstance();
        loadDatainListview();

        fdName=findViewById(R.id.foodName);
        quantity=findViewById(R.id.quantity);
        btnAdd = findViewById(R.id.btnAdd);
        food= new Food();
        ref= FirebaseDatabase.getInstance().getReference().child("Food");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantities= Integer.parseInt(quantity.getText().toString().trim());
                food.setFdName(fdName.getText().toString().trim());
                food.setQuantity(quantities);
                ref.push().setValue(food);
                Toast.makeText(AddFood.this, "Data Added successfully", Toast.LENGTH_SHORT).show();
            }
        });
}
    private void loadDatainListview() {

        fstore.collection("imgData").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                home_data_modal dataModal = d.toObject(home_data_modal.class);
                                dataModalArrayList.add(dataModal);
                            }
                            homeitemadapter adapter = new homeitemadapter(AddFood.this, dataModalArrayList);
                            TVlist.setAdapter(adapter);
                        } else {
                            Toast.makeText(AddFood.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddFood.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}