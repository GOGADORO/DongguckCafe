package com.example.dgucafeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Owner;

public class OwnerSignUp extends AppCompatActivity {

    private Spinner CafeSpinner;
    private ArrayAdapter arrayAdapter;
    private Button SignUpButton;
    private EditText OwnerId, OwnerPw1, OwnerPw1Check, OwnerPw2, OwnerPw2Check;
    private TextView CafeErrorMessage ,IdErrorMessage, Pwd1ErrorMessage, Pwd2ErrorMessage;
    static String cafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_up);

        //타이틀바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //뷰에서 받아온 데이터
        CafeSpinner = (Spinner) findViewById(R.id.CafeSpinner);
        OwnerId = findViewById(R.id.OwnerIdText);
        OwnerPw1 = findViewById(R.id.PW1Text);
        OwnerPw1Check = findViewById(R.id.PW1CheckText);
        OwnerPw2 = findViewById(R.id.PW2Text);
        OwnerPw2Check = findViewById(R.id.PW2CheckText);
        CafeErrorMessage = findViewById(R.id.CafeErrorText);
        IdErrorMessage = findViewById(R.id.IdErrorText);
        Pwd1ErrorMessage = findViewById(R.id.Pwd1ErrorText);
        Pwd2ErrorMessage = findViewById(R.id.Pwd2ErrorText);
        SignUpButton = findViewById(R.id.SignUpButton);



        //최종 확인은 버튼을 눌렀을 때 에러메세지가 " "가 아니면 통과 불가능
        //실행할 메소드
        setSpinnerView();
        cafeCheck(cafe);
        idCheck();
        Check1();
        Check2();
        OwnerSignUp();
    }

    public void setSpinnerView(){
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.CafeArray, android.R.layout.simple_spinner_dropdown_item);
        CafeSpinner.setAdapter(arrayAdapter);
        CafeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cafe = CafeSpinner.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void cafeCheck(String cafe){
        if(cafe.equals(null)){
            CafeErrorMessage.setText("본인의 카페를 선택하십시오.");
            CafeSpinner.setBackgroundResource(R.drawable.textview_border_error);
        } else{
            CafeErrorMessage.setText(" ");
            CafeSpinner.setBackgroundResource(R.drawable.textview_border_layout);
        }
    }

    public void idCheck(){
        OwnerId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력하기 전에
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력되는 텍스트에 변화가 있을 때
                if(OwnerId.toString().length()<11) {
                    IdErrorMessage.setText("전화번호 11자리를 모두 입력하십시오.");
                    OwnerId.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }else{
                    IdErrorMessage.setText(" ");
                    OwnerId.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                //입력이 끝났을 때(중복확인, 전화번호 폼)
                if(s.toString().length()<11) {
                    IdErrorMessage.setText("전화번호 형식과 일치하지 않습니다.");
                    OwnerId.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }/*else if (!isPhoneDup(s.toString())){
                    IdErrorMessage.setText("이미 존재하는 계정입니다.\n이전의 로그인 버튼을 눌러 로그인하십시오.");
                    OwnerId.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }*/else{
                    IdErrorMessage.setText(" ");
                    OwnerId.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerId.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                }
            }
        });
    }

    public void Check1(){
        OwnerPw1Check.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력되는 텍스트에 변화가 있을 때
                if(!OwnerPw1Check.getText().toString().equals(OwnerPw1.getText().toString())){
                    Pwd1ErrorMessage.setText("비밀번호1과 비밀번호1 확인이 일치하지 않습니다.");
                    OwnerPw1.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw1.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                    OwnerPw1Check.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw1Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                } else{
                    Pwd1ErrorMessage.setText(" ");
                    OwnerPw1.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw1.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                    OwnerPw1Check.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw1Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                //입력이 끝났을 때
                if(!OwnerPw1Check.getText().toString().equals(OwnerPw1.getText().toString())){
                    Pwd1ErrorMessage.setText("비밀번호1과 비밀번호1 확인이 일치하지 않습니다.");
                    OwnerPw1.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw1.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                    OwnerPw1Check.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw1Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                } else{
                    Pwd1ErrorMessage.setText(" ");
                    OwnerPw1.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw1.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                    OwnerPw1Check.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw1Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                }
            }
        });
    }

    public void Check2(){
        OwnerPw2Check.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력되는 텍스트에 변화가 있을 때
                if(!OwnerPw2Check.getText().toString().equals(OwnerPw2.getText().toString())){
                    Pwd2ErrorMessage.setText("비밀번호2와 비밀번호2 확인이 일치하지 않습니다.");
                    OwnerPw2.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw2.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                    OwnerPw2Check.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw2Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                } else {
                    Pwd2ErrorMessage.setText(" ");
                    OwnerPw2.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw2.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                    OwnerPw2Check.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw2Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                //입력이 끝났을 때
                if(OwnerPw1.getText().toString().equals(s.toString())){
                    Pwd2ErrorMessage.setText("비밀번호1과 동일한 비밀번호입니다. 재설정하십시오.");
                    OwnerPw2.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw2.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                    OwnerPw2Check.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw2Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }
                else if(!OwnerPw2Check.getText().toString().equals(OwnerPw2.getText().toString())){
                    Pwd2ErrorMessage.setText("비밀번호2와 비밀번호2 확인이 일치하지 않습니다.");
                    OwnerPw2.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw2.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                    OwnerPw2Check.setBackgroundResource(R.drawable.textview_border_error);
                    OwnerPw2Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                }else{
                    Pwd2ErrorMessage.setText(" ");
                    OwnerPw2.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw2.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                    OwnerPw2Check.setBackgroundResource(R.drawable.textview_border_layout);
                    OwnerPw2Check.setHintTextColor(getApplicationContext().getResources().getColor(R.color.defaultColor));
                }
            }
        });
    }

    public void OwnerSignUp(){
        SignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (IdErrorMessage.getText().toString().equals(" ")
                        && Pwd1ErrorMessage.getText().toString().equals(" ")
                        && Pwd2ErrorMessage.getText().toString().equals(" ")
                        && CafeErrorMessage.getText().toString().equals(" ")){
                    //회원가입 정보 저장
                    /*addPhoneNum(OwnerId.getText().toString());
                    addPwd(OwnerPw1.getText().toString(),OwnerPw2.getText().toString());
                    addCafe(cafe);*/

                    //토스트 메세지 출력 -> 화면전환
                    Toast.makeText(OwnerSignUp.this, "회원가입 성공. 로그인하십시오.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OwnerSignUp.this, OwnerSignIn.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(OwnerSignUp.this, "입력한 정보를 재확인하십시오.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
