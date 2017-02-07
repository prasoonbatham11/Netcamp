package com.example.prasoon.calculator;

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
import android.widget.ImageView;
import android.widget.TextView;

public class Prox extends AppCompatActivity implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;
    MediaPlayer mediaPlayer, mediaPlayer2;
    ImageButton back;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prox);

        //x = (TextView) findViewById(R.id.x);
        back = (ImageButton) findViewById(R.id.back);
        imageView = (ImageView) findViewById(R.id.image);

        mediaPlayer = MediaPlayer.create(this, R.raw.where);
        //mediaPlayer2 = MediaPlayer.create(this, R.raw.space);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        Log.e("data","in OnCreate");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();//mediaPlayer2.stop();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        Log.e("data","in OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        Log.e("data","in OnPause");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //x.setText(""+event.values[0]);
        Log.e("data","in sensor changed");

        if(event.values[0]==0) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.space);
            mediaPlayer.start();
            imageView.setImageResource(R.drawable.space);

        }
        else {

            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.where);
            mediaPlayer.start();
            imageView.setImageResource(R.drawable.where);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
