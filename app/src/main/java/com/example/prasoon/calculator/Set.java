package com.example.prasoon.calculator;

import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by prasoon on 12/11/2016.
 */
public class Set {



    public static void setText(TextView ques ,TextView t1, TextView t2, TextView t3, TextView t4, int q)
    {
        ques.setText(Quiz.ques[q]);
        t1.setText(Quiz.option1[q]);
        t2.setText(Quiz.option2[q]);
        t3.setText(Quiz.option3[q]);
        t4.setText(Quiz.option4[q]);
    }

}
