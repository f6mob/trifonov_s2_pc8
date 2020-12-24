package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class WaitActivity extends AppCompatActivity {

    TextView out;

    Timer timer;

    Button b_OUT;
    Button b_stop;

    int seconds = 900;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        out = findViewById(R.id.timer_output);

        b_OUT = findViewById(R.id.b_out);
        b_stop = findViewById(R.id.b_stop);





        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {


            @Override
            public void run() {
                int minutes = seconds / 60;
                int hours = minutes / 60;
                int sec = seconds % 60;
                seconds--;
                out.setText(String.format("%02d:%02d:%02d",hours, minutes, sec));

                if (seconds != 0){
                    handler.postDelayed(this,1000);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), DriveActivity.class);
                    startActivity(intent);
                    handler.removeCallbacks(this);
                }
            }
        };

            handler.post(runnable);

        b_OUT.setOnClickListener(view -> {
            handler.removeCallbacks(runnable);
            finish();
        });

        b_stop.setOnClickListener(view -> {
            handler.removeCallbacks(runnable);
            Intent intent = new Intent(this, DriveActivity.class);
            startActivity(intent);
            finish();
        });
    }



}