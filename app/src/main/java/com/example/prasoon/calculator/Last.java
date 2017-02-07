package com.example.prasoon.calculator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Last extends AppCompatActivity {

    TextView textView;
    String s;
    ImageButton facebook, twitter, insta, pinterest, google, netcamp, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        s = "Your Score is " + Quiz.score + " points.";
        textView = (TextView) findViewById(R.id.score);
        textView.setText(s);
        setbuttons();


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/"));
                startActivity(i);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/"));
                startActivity(i);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/"));
                startActivity(i);
            }
        });
        netcamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.netcamp.in/"));
                startActivity(i);
            }
        });
        pinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pinterest.com/"));
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.activity.finish();
                Quiz.activity.finish();
                Functions.activity.finish();
                Intent i = new Intent(Last.this, Login.class);
                startActivity(i);

                finish();
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://plus.google.com/"));
                startActivity(i);
            }
        });


    }

    public void setbuttons()
    {
        facebook = (ImageButton) findViewById(R.id.facebook);
        twitter = (ImageButton) findViewById(R.id.twitter);
        insta = (ImageButton) findViewById(R.id.instagram);
        pinterest = (ImageButton) findViewById(R.id.pinterest);
        google = (ImageButton) findViewById(R.id.google);
        netcamp = (ImageButton) findViewById(R.id.netcamp);
        logout = (ImageButton) findViewById(R.id.logout);
    }

}
