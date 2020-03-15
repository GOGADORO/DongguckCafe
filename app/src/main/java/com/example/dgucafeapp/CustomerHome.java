package com.example.dgucafeapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerHome extends Fragment {
    View v;
    private TextView CustomerId, StampNum, Americano, Latte;
    private ImageView Stamp1, Stamp2, Stamp3, Stamp4, Stamp5,
                        Stamp6, Stamp7, Stamp8, Stamp9, Stamp10,
                        Stamp11, Stamp12, Stamp13, Stamp14, Stamp15;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_customer_home,container,false);

        //뷰에서 받아온 데이터
        CustomerId = v.findViewById(R.id.CustomerId);
        StampNum = v.findViewById(R.id.StampNum);
        Americano = v.findViewById(R.id.Americano);
        Latte = v.findViewById(R.id.Cafelatte);

        //CustomerId.setText(getCustomerId());

        return v;
    }

    public void setStampView(){
        for(int i=0; i<6; i++){
            String stampView = "R.id.Stamp"+String.valueOf(i);
            int stampId = getResources().getIdentifier(stampView, "id","com.example.dgucafeapp");
            ImageView Stamp = v.findViewById(stampId);
            Stamp.setImageResource(R.drawable.coop);
        }
    }



}
