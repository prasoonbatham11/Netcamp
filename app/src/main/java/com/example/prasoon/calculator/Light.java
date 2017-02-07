package com.example.prasoon.calculator;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Light extends AppCompatActivity implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;
    MediaPlayer mediaPlayer;
    TextView textView;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        back = (ImageButton) findViewById(R.id.back);
        textView = (TextView) findViewById(R.id.textView);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

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

        textView.setText(event.values[0]+"");

        if(event.values[0]>5) {
            mediaPlayer.start();
        }
        else {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
