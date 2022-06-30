package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running;
    private long StopOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    public void StartChronometer(View view) {
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime()-StopOffset);
            chronometer.start();
            running=true;
        }
    }

    public void StopChronometer(View view) {
        if(running){
            chronometer.stop();
            StopOffset=SystemClock.elapsedRealtime()- chronometer.getBase();
            running=false;
        }
    }

    public void ResetChronometer(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        StopOffset=0;
    }


}