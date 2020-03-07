package com.example.dgucafeapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;

        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.HashMap;



public class AccumulateStamp extends AppCompatActivity {
    Button Accumulate, Reset;
    EditText EditCoupon;
    Button UseCoupon,ManageMenu;

    // 1 주문하는 고객 2 해당 고객의 스탬프 적립 -> 고객 정보를 가져와서 고객의 스탬프를 적립
    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "id";
    private static final String TAG_COUPON = "coupon";
    private static final String TAGSTAMP_ = "stamp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accumulatestamp);
        EditCoupon = (EditText) findViewById(R.id.couponCount);
        Accumulate = (Button) findViewById(R.id.accumulate);
        Reset = (Button) findViewById(R.id.reset);

        UseCoupon = (Button) findViewById(R.id.useCopoun);
        ManageMenu = (Button) findViewById(R.id.managementMenu);

        Accumulate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { //적립을 하기 위한 함수
                if(EditCoupon.getText().length() == 0){
                    Toast.makeText(getApplicationContext() , "적립할 수 없습니다!", Toast.LENGTH_SHORT).show();
                }else{
                    //데이터 베이스 연결
                    EditCoupon.setText("");
                    Toast.makeText(getApplicationContext() , "적립되었습니다.", Toast.LENGTH_SHORT).show();

                }

            }
        });

        Reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { //적립 취소 함수
                if(EditCoupon.getText().length() == 0){
                    Toast.makeText(getApplicationContext() , "초기화되었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    EditCoupon.setText("");
                    Toast.makeText(getApplicationContext() , "초기화되었습니다", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //하단부
        UseCoupon.setOnClickListener(new Button.OnClickListener() { //쿠폰 사용을 위한 activity로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccumulateStamp.this, UseCoupon.class) ;

                startActivity(intent) ;
            }
        });

        ManageMenu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {   //메뉴 관리를 위한 activity로 이동
                Intent intent = new Intent(AccumulateStamp.this, ManageMenu.class) ;

                startActivity(intent) ;
            }
        });

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


    public void getData(String url){
        class GetDataJSON extends AsyncTask<String,Void,String> {

            @Override
            protected String doInBackground(String... params){
                String uri = params[0];

                BufferedReader bufferedReader = null;
                try{
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();

                }catch (Exception e ){
                    return null;}
            }
            @Override
            protected  void onPostExecute(String result) {
                myJSON = result;
                //showList();
            }
        }
        GetDataJSON g= new GetDataJSON();
        g.execute(url);
    }
}

