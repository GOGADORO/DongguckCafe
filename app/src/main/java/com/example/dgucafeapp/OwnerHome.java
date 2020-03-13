package com.example.dgucafeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OwnerHome extends Fragment {
    ViewGroup viewGroup;
    Button Accumulate, Reset;
    TextView EditCoupon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_owner_home_accumulatestamp,container,false);

        EditCoupon = (TextView) getView().findViewById(R.id.couponCount);
        Accumulate = (Button) getView().findViewById(R.id.accumulate);
        Reset = (Button) getView().findViewById(R.id.reset);

        Accumulate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { //적립을 하기 위한 함수
                if(EditCoupon.toString() == "0"){
                    Toast.makeText(getActivity().getApplicationContext() , "적립할 수 없습니다!", Toast.LENGTH_SHORT).show();
                }else{
                    //데이터 베이스 연결
                    EditCoupon.setText("");
                    Toast.makeText(getActivity().getApplicationContext() , "적립되었습니다.", Toast.LENGTH_SHORT).show();

                }

            }
        });

        Reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { //적립 취소 함수
                if(EditCoupon.getText().length() == 0){
                    Toast.makeText(getActivity().getApplicationContext() , "초기화되었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    EditCoupon.setText("");
                    Toast.makeText(getActivity().getApplicationContext() , "초기화되었습니다", Toast.LENGTH_SHORT).show();

                }

            }
        });
        return viewGroup;
    }
    public void NumberingCoupon(View v){ //키패드를 이용해서 적립할 쿠폰 숫자 지정
        switch (v.getId()) {
            case R.id.Num0:
                EditCoupon.append("0");
                break;
            case R.id.Num1:
                EditCoupon.append("1");
                break;
            case R.id.Num2:
                EditCoupon.append("2");
                break;
            case R.id.Num3:
                EditCoupon.append("3");
                break;
            case R.id.Num4:
                EditCoupon.append("4");
                break;
            case R.id.Num5:
                EditCoupon.append("5");
                break;
            case R.id.Num6:
                EditCoupon.append("6");
                break;
            case R.id.Num7:
                EditCoupon.append("7");
                break;
            case R.id.Num8:
                EditCoupon.append("8");
                break;
            case R.id.Num9:
                EditCoupon.append("9");
                break;
        }
    }

}
