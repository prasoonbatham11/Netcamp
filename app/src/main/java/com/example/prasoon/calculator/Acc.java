package com.example.prasoon.calculator;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Acc extends AppCompatActivity implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;
    MediaPlayer mediaPlayer;
    TextView x,y,z;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        x = (TextView) findViewById(R.id.x);
        y = (TextView) findViewById(R.id.y);
        z = (TextView) findViewById(R.id.z);
        back = (ImageButton) findViewById(R.id.back);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Log.e("my","After creating sensor");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("X = " + event.values[0]);
        y.setText("Y = " + event.values[1]);
        z.setText("Z = " + event.values[2]);

        //Log.e("my","setting values");

        double p = event.values[0];
        double q = event.values[1];
        double r = event.values[2];

        double a = Math.abs(p);
        double b = Math.abs(q);
        double c = Math.abs(r);

        if(a>b && a>c) {
            x.setTextColor(Color.parseColor("#d40206"));
            y.setTextColor(Color.parseColor("#3fb603"));
            z.setTextColor(Color.parseColor("#3fb603"));
        }
        else if(b>a && b>c) {
            x.setTextColor(Color.parseColor("#3fb603"));
            y.setTextColor(Color.parseColor("#d40206"));
            z.setTextColor(Color.parseColor("#3fb603"));
        }
        else {
            x.setTextColor(Color.parseColor("#3fb603"));
            y.setTextColor(Color.parseColor("#3fb603"));
            z.setTextColor(Color.parseColor("#d40206"));
        }

        //Log.e("my","Set the values");




    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
