package com.example.dgucafeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class CustomerSignIn extends AppCompatActivity {

    private Button OwnerButton;
    private Button SignUpButton;
    private Button SignInButton;

    private EditText CustomerId; //.toString()으로 변환시켜야함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_in);
        //타이틀바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        OwnerButton = findViewById(R.id.OwnerButton);
        OwnerButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(CustomerSignIn.this, OwnerSignIn.class); //현재에서 이동할 액티비티
               startActivity(intent); //액티비티 이동
           }
        });


        SignUpButton = findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CustomerSignIn.this, navigation.class);
                startActivity(intent); //현재는 로그인 확인 절차 없이 바로 이동
            }
        });


        SignInButton = findViewById(R.id.SignInButton);
        SignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getCustomerID();
                Intent intent = new Intent(CustomerSignIn.this, navigation.class);
                startActivity(intent); //현재는 로그인 확인 절차 없이 바로 이동
            }
        });


    }

    public void getCustomerID(){
        //editText에서 아이디 받아와서 데이터베이스에 저장 및 데이터 넘겨주기
        CustomerId = findViewById(R.id.CustomerIdText);
        String customerId = CustomerId.toString();
    }
}
