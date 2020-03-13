package com.example.dgucafeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import java.security.acl.Owner;

public class OwnerSignIn extends AppCompatActivity {

    private Button CustomerButton;
    private Button OwnerSignUpButton;
    private Button OwnerSignInButton;
    private EditText OwnerId, OwnerPwd1, OwnerPwd2;
    private TextView LoginErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_in);

        //타이틀바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //뷰에서 받아온 데이터
        OwnerSignInButton= findViewById(R.id.SignInButton);
        OwnerId = findViewById(R.id.OwnerIdText);
        OwnerPwd1 = findViewById(R.id.OwnerPW1Text);
        OwnerPwd2 = findViewById(R.id.OwnerPW2Text);
        LoginErrorMessage = findViewById(R.id.LoginErrorText);

        String u_id = OwnerId.toString();
        String pwd1 = OwnerPwd1.toString();
        String pwd2 = OwnerPwd2.toString();

        //실행메소드
        ButtonAction();
        OwnerLogin();
    }

    //버튼 액션 함수
    public void ButtonAction(){
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
    }

    public void OwnerLogin(){
        /*OwnerSignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if checkPhone(u_id){
                    if checkPassword(u_id, pwd1, pwd2){
                        Intent intent = new Intent(OwnerSignIn.this, navigation.class); //현재에서 이동할 액티비티
                        startActivity(intent); //액티비티 이동
                    }
                    else{
                        //비밀번호 오류 메세지
                        LoginErrorMessage.setText("로그인 오류입니다.\n비밀번호1, 2를 확인하십시오.");
                        OwnerPwd1.setBackgroundResource(R.drawable.textview_border_error);
                        OwnerPwd2.setBackgroundResource(R.drawable.textview_border_error);
                        OwnerPwd1.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                        OwnerPwd2.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                    }
                } else {
                    //로그인 오류 메세지
                    LoginErrorMessage.setText("로그인 오류입니다.\n전화번호(id)를 확인하십시오.");
                    OwnerId.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }
            }
        });*/

        //임시로그인
        OwnerSignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OwnerSignIn.this, OwnerNavigation.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });
    }
}
