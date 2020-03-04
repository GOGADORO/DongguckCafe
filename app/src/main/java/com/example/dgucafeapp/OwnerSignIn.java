package com.example.dgucafeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class OwnerSignIn extends AppCompatActivity {

    private Button CustomerButton;
    private Button OwnerSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_in);

        CustomerButton= findViewById(R.id.CustomerButton);
        CustomerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OwnerSignIn.this, CustomerSignIn.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });

        OwnerSignUpButton= findViewById(R.id.SignUpButton);
        CustomerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OwnerSignIn.this, OwnerSignUp.class); //현재에서 이동할 액티비티
                startActivity(intent); //액티비티 이동
            }
        });

    }
}
