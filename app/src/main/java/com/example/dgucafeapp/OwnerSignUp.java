package com.example.dgucafeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class OwnerSignUp extends AppCompatActivity {

    private Spinner CafeSpinner;
    private ArrayAdapter arrayAdapter;

    private EditText OwnerId;
    private EditText OwnerPw1;
    private EditText OwnerPw1Check;
    private EditText OwnerPw2;
    private EditText OwnerPw2Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_up);

        setSpinnerView();

    }

    public void setSpinnerView(){
        CafeSpinner = (Spinner) findViewById(R.id.CafeSpinner);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.CafeArray, android.R.layout.simple_spinner_dropdown_item);
        CafeSpinner.setAdapter(arrayAdapter);
    }
}
