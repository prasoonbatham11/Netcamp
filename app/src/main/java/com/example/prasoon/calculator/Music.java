package com.example.prasoon.calculator;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Music extends AppCompatActivity {

    ImageButton play, pause, resume, stop,back;
    MediaPlayer m;
    int length;
    boolean isPlay = false, isPause = false, isResume = false, isStop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        setViewIds();

        m = MediaPlayer.create(this, R.raw.song);




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isStop && !isPlay && !isResume && !isPause) {
                    isPlay = true; isPause = false; isResume = false; isStop = false;
                m = MediaPlayer.create(Music.this, R.raw.song);
                m.start();
                play.setBackgroundColor(Color.parseColor("#018325"));
                pause.setBackgroundColor(Color.parseColor("#012d25"));
                resume.setBackgroundColor(Color.parseColor("#012d25"));
                stop.setBackgroundColor(Color.parseColor("#012d25"));}

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((isPlay || isResume) && !isStop && !isPause) {
                    isPlay = false; isPause = true; isResume = false; isStop = false;
                m.pause();
                length = m.getCurrentPosition();
                pause.setBackgroundColor(Color.RED);
                play.setBackgroundColor(Color.parseColor("#012d25"));
                resume.setBackgroundColor(Color.parseColor("#012d25"));
                stop.setBackgroundColor(Color.parseColor("#012d25"));}
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPause && !isPlay && !isStop && !isResume) {
                    isPlay = false; isPause = false; isResume = true; isStop = false;
                m.seekTo(length);
                m.start();

                resume.setBackgroundColor(Color.parseColor("#018325"));
                pause.setBackgroundColor(Color.parseColor("#012d25"));
                play.setBackgroundColor(Color.parseColor("#012d25"));
                stop.setBackgroundColor(Color.parseColor("#012d25"));}
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((isResume || isPlay) && !isStop && !isPause) {
                    isPlay = false; isPause = false; isResume = false; isStop = true;
                m.stop();

                stop.setBackgroundColor(Color.RED);
                pause.setBackgroundColor(Color.parseColor("#012d25"));
                resume.setBackgroundColor(Color.parseColor("#012d25"));
                play.setBackgroundColor(Color.parseColor("#012d25"));}
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.stop();
                finish();
            }
        });

    }

    private void setViewIds()
    {
        play = (ImageButton) findViewById(R.id.play);
        pause = (ImageButton) findViewById(R.id.pause);
        resume = (ImageButton) findViewById(R.id.resume);
        stop = (ImageButton) findViewById(R.id.stop);
        back = (ImageButton) findViewById(R.id.back);
    }
}
