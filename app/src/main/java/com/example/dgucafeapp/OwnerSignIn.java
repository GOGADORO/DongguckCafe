package com.example.dgucafeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class OwnerSignIn extends AppCompatActivity {

    private Button CustomerButton;
    private Button OwnerSignUpButton;
    private Button OwnerSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_in);

        //타이틀바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //고객 버튼
        CustomerButton= findViewById(R.id.CustomerButton);
        CustomerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OwnerSignIn.this, CustomerSignIn.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });

        //점주 회원가입 버튼
        OwnerSignUpButton= findViewById(R.id.SignUpButton);
        OwnerSignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OwnerSignIn.this, OwnerSignUp.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });

        //점주 로그인 버튼 -> 이동할 액티비티 수정예정
        OwnerSignInButton= findViewById(R.id.SignInButton);
        OwnerSignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OwnerSignIn.this, navigation.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });

    }
}
