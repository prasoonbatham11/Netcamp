package com.example.prasoon.calculator;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Functions extends AppCompatActivity {

    ImageButton back,music,calc,cam,quiz,sensor;
    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);

        activity = this;

        setViewIds();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Functions.this, Music.class); startActivity(i);
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Functions.this, Calculator.class); startActivity(i);
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Functions.this, Camera.class); startActivity(i);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Functions.this, Quiz.class); startActivity(i);
            }
        });

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Functions.this, Sense.class); startActivity(i);
            }
        });


    }

    private void setViewIds()
    {
        back = (ImageButton) findViewById(R.id.back);
        music = (ImageButton) findViewById(R.id.bmusic);
        calc = (ImageButton) findViewById(R.id.bcalc);
        cam = (ImageButton) findViewById(R.id.bcam);
        quiz = (ImageButton) findViewById(R.id.bquiz);
        sensor = (ImageButton) findViewById(R.id.bsensor);

    }
}
