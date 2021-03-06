package com.example.dgucafeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class CustomerSignIn extends AppCompatActivity {

    private Button OwnerButton, SignUpButton, SignInButton;
    private EditText CustomerId; //.toString()으로 변환시켜야함
    private TextView LoginErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_in);

        //타이틀바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //뷰에서 받아온 데이터
        SignInButton = findViewById(R.id.SignInButton);
        SignUpButton = findViewById(R.id.SignUpButton);
        CustomerId = findViewById(R.id.CustomerIdText);
        LoginErrorMessage = findViewById(R.id.LoginErrorText);

        //실행메소드
        MoveButton();
        CustomerSignIn();
        CustomerSignUp();
    }

    //액티비티 이동 버튼액션 함수
    public void MoveButton(){
        OwnerButton = findViewById(R.id.OwnerButton);
        OwnerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CustomerSignIn.this, OwnerSignIn.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });
    }

    //점주 로그인 함수
    public void CustomerSignIn(){
        /*SignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if checkPhone(u_id){
                    Intent intent = new Intent(CustomerSignIn.this, navigation.class);
                    startActivity(intent);
                }
                else{
                    LoginErrorMessage.setText("로그인 오류입니다.\n전화번호(id)를 확인하십시오.");
                    CustomerId.setBackgroundResource(R.drawable.textview_border_error);
                    CustomerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }
            }
        });*/

        //임시 로그인
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerSignIn.this, navigation.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });

    }

    public void CustomerSignUp(){
        /*SignUpButton = findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (isPhoneDup(CustomerId.getText().toString().equals(null))) {
                    LoginErrorMessage.setText("이미 존재하는 계정입니다.\n로그인 버튼을 눌러 로그인하십시오.");
                    CustomerId.setBackgroundResource(R.drawable.textview_border_error);
                    CustomerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }
                else if(CustomerId.getText().toString().equals(null)){
                    LoginErrorMessage.setText("회원가입 할 전화번호(id)를 입력한 후에\n회원가입 버튼을 누르십시오.");
                    CustomerId.setBackgroundResource(R.drawable.textview_border_error);
                    CustomerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                } else {
                    Toast.makeText(CustomerSignIn.this, "계정이 생성되었습니다. 로그인 하십시오.",Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }
}
