package com.example.prasoon.calculator;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Q3 extends AppCompatActivity {

    RadioButton r1,r2,r3,r4;
    TextView t1,t2,t3,t4,ques;
    ImageButton back, check, forward;
    TextToSpeech t;

    boolean isChecked;

    int q;

    String op = "Please select an option to continue.";
    String cor = "This is the correct answer.";
    String wr = "This is the wrong answer.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);

        Log.e("m","In onCreate");

        q = Quiz.seq[2];
        setButtons();
        Set.setText(ques, t1, t2, t3, t4, q);
        isChecked = false;



        Log.e("m","after setButtons");

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t.setLanguage(Locale.ENGLISH);
                t.setSpeechRate(1.2f);
            }
        });


        if(isChecked) {
            r1.setClickable(false);
            r2.setClickable(false);
            r3.setClickable(false);
            r4.setClickable(false);
        }
        else
        {
            r1.setClickable(true);
            r2.setClickable(true);
            r3.setClickable(true);
            r4.setClickable(true);
        }


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setChecked(false);
                r1.setChecked(false);
                r4.setChecked(false);
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setChecked(false);
                r3.setChecked(false);
                r1.setChecked(false);
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.e("m","After assignment");

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked) {
                    Intent i = new Intent(Q3.this, Q4.class);
                    startActivity(i);
                    finish();
                }
                else if(!r1.isChecked() && !r2.isChecked() && !r3.isChecked() && !r4.isChecked()) {
                    typeSpeak(op);
                }
                else {
                    typeSpeak("Please check if answer is correct.");
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isChecked)
                {
                    isChecked = true;
                    if(!r1.isChecked() && !r2.isChecked() && !r3.isChecked() && !r4.isChecked()) {
                        isChecked = false;
                        typeSpeak(op);
                    }
                    else {
                        if(checkIfCorrect()) {
                            colorChangeCorrect();
                            typeSpeak(cor);
                            Quiz.score += 10;
                        }
                        else {
                            colorChangeWrong();
                            typeSpeak(wr);
                            Quiz.score -= 5;
                        }
                    }
                }

            }
        });




    }

    private void typeSpeak(String s)
    {
        Toast.makeText(Q3.this, s, Toast.LENGTH_SHORT).show();
        t.speak(s, TextToSpeech.QUEUE_FLUSH, null);
    }

    private boolean checkIfCorrect()
    {
        boolean x = false;
        switch (Quiz.correct[q])
        {
            case 1: if(r1.isChecked()) x = true; else x = false; break;
            case 2: if(r2.isChecked()) x = true; else x = false; break;
            case 3: if(r3.isChecked()) x = true; else x = false; break;
            case 4: if(r4.isChecked()) x = true; else x = false; break;
        }
        return x;
    }

    private void setButtons()
    {
        Log.e("m","SetButtons");
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        ques = (TextView) findViewById(R.id.ques);

        back = (ImageButton) findViewById(R.id.back);
        check = (ImageButton) findViewById(R.id.check);
        forward = (ImageButton) findViewById(R.id.forward);
    }

    private void colorChangeCorrect()
    {
        getChecked().setBackgroundColor(Color.parseColor("#057eb6"));
    }

    private TextView getChecked()
    {
        if(r1.isChecked()) return t1;
        else if(r2.isChecked()) return t2;
        else if(r3.isChecked()) return t3;
        else return t4;
    }

    private void colorChangeWrong()
    {
        getChecked().setBackgroundColor(Color.RED);
        if(Quiz.correct[q]==1) t1.setBackgroundColor(Color.parseColor("#057eb6"));
        else if(Quiz.correct[q]==2) t2.setBackgroundColor(Color.parseColor("#057eb6"));
        else if(Quiz.correct[q]==3) t3.setBackgroundColor(Color.parseColor("#057eb6"));
        else if(Quiz.correct[q]==4) t4.setBackgroundColor(Color.parseColor("#057eb6"));
    }

}
