package com.example.thefoodrunner;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class homeitemadapter extends ArrayAdapter<home_data_modal> {
    public homeitemadapter(@NonNull Context context, ArrayList<home_data_modal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
        EditText priceTV;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.home_horizontal_item, parent, false);
        }
        home_data_modal dataModal = getItem(position);
        TextView nameTV = listitemView.findViewById(R.id.idTVtext);
        ImageView courseIV = listitemView.findViewById(R.id.idIVimage);
        TextView priceTV=listitemView.findViewById(R.id.idTVprice);
        nameTV.setText(dataModal.getName());
        priceTV.setText(dataModal.getPrice());
        Picasso.with(getContext()).load(dataModal.getImgUrl()).into(courseIV);
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Item clicked is : " + dataModal.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return listitemView;
    }
}
