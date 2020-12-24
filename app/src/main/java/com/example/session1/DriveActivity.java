package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class DriveActivity extends AppCompatActivity {

    TextView out;
    Button b_stop;

    int seconds = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        out = findViewById(R.id.timer_output);

        b_stop = findViewById(R.id.b_stop);





        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {


            @Override
            public void run() {
                int minutes = seconds / 60;
                int hours = minutes / 60;
                int sec = seconds % 60;
                seconds++;
                out.setText(String.format("%02d:%02d:%02d",hours, minutes, sec));
                handler.postDelayed(this,1000);
            }
        };

        handler.post(runnable);

        b_stop.setOnClickListener(view -> {
            Toast.makeText(this,"Thank you!", Toast.LENGTH_LONG);
            handler.removeCallbacks(runnable);
            finish();
        });
    }
}