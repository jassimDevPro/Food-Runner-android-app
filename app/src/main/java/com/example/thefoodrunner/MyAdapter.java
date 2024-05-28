package com.example.thefoodrunner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context context;
    String resName[];
    String resLoc[];
    int image[];
    public MyAdapter(Context context,String[] resName,String[] resLoc,int[] image){
        this.context=context;
        this.resName=resName;
        this.resLoc=resLoc;
        this.image=image;
        inflater=LayoutInflater.from(context);
    }
    LayoutInflater inflater;
    @Override
    public int getCount() {
        return resName.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.rest_custom, null);
        TextView rName = view.findViewById(R.id.resName);
        TextView rRoll = view.findViewById(R.id.resLoc);
        ImageView imgView = view.findViewById(R.id.imageview);
        rName.setText(resName[i]);
        rRoll.setText(resLoc[i]);
        imgView.setImageResource(image[i]);
        return view;
    }

}

