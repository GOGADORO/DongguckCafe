package com.example.dgucafeapp;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class UseCoupon extends AppCompatActivity {

    TextView textView;
    TimerTask timerTask;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usecoupon);

        textView = findViewById(R.id.textView2);
    }




    @Override
    protected void onDestroy()
    {
        timer.cancel();
        super.onDestroy();
    }

    public void clickHandler(View view)
    {
        switch(view.getId())
        {
            case R.id.sendNum:
                startTimerTask();
                break;
            case R.id.checkNum :
                stopTimerTask();
                break;
        }
    }

    private void startTimerTask()
    {
        stopTimerTask();

        timerTask = new TimerTask()
        {
            int count = 60;

            @Override
            public void run()
            {
                count--;
                textView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(count + " 초");
                    }
                });
            }
        };
        timer.schedule(timerTask,0 ,1000);
    }

    private void stopTimerTask()
    {
        if(timerTask != null)
        {
            textView.setText("60 초");
            timerTask.cancel();
            timerTask = null;
        }
    }
}



