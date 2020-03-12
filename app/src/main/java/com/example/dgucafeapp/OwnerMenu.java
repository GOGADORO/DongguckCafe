package com.example.dgucafeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OwnerMenu extends Fragment {
    ViewGroup viewGroup;
    Button ChangeMenu, AddMenu , Coffee, Noncoffee, Smoothie, Bakery ;
    TextView MenuList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_owner_managemenu,container,false);

        ChangeMenu = (Button) getView().findViewById(R.id.changeMenu);
        AddMenu = (Button) getView().findViewById(R.id.addMenu);
        Coffee = (Button) getView().findViewById(R.id.coffee);
        Noncoffee = (Button) getView().findViewById(R.id.noncoffee);
        Smoothie = (Button) getView().findViewById(R.id.smoothie);
        Bakery = (Button) getView().findViewById(R.id.bakery);

        return viewGroup;
    }
}
