package com.example.prasoon.calculator;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {

    Button number[] = new Button[10];
    Button point,plus,minus,mul,div,equal,sin,cos,log,clear;
    String a = "";
    String b = "";
    TextView op,result,edit;
    ImageButton back;
    DecimalFormat dff = new DecimalFormat(".######");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setbuttons();


        int i;
        for(i=0;i<10;i++)
        {
            number[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    String str = getResources().getResourceEntryName(id);
                    a += str.substring(6);
                    edit.setText(a);
                }
            });
        }

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a+=".";
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("+");
                if(a!="") {
                    b = a; a = "";
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("-");
                if(a!="") {
                    b = a; a = "";
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("X");
                if(a!="") {
                    b = a; a = "";
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("/");
                if(a!="") {
                    b = a; a = "";
                }
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("SIN");
                if(a!="") {
                    double res = Math.sin(Double.parseDouble(a));
                    b = a; a = "";
                    result.setText(String.valueOf(dff.format(res)));
                }
                else if(b!="") {
                    double res = Math.sin(Double.parseDouble(b));
                    result.setText(String.valueOf(dff.format(res)));
                }



            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("COS");
                if(a!="") {
                    double res = Math.cos(Double.parseDouble(a));
                    b = a; a = "";
                    result.setText(String.valueOf(dff.format(res)));
                }
                else if(b!="") {
                    double res = Math.cos(Double.parseDouble(b));
                    result.setText(String.valueOf(dff.format(res)));
                }

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText("LOG");
                if(a!="") {
                    double res = Math.log(Double.parseDouble(a));
                    b = a; a = "";
                    result.setText(String.valueOf(dff.format(res)));
                }
                else if(b!="") {
                    double res = Math.log(Double.parseDouble(b));
                    result.setText(String.valueOf(dff.format(res)));
                }

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opr = op.getText().toString();
                double res = 0;
                switch(opr)
                {
                    case "+":
                        res = Double.parseDouble(b)+Double.parseDouble(a);
                        b = String.valueOf(res);
                        break;
                    case "-":
                        res = Double.parseDouble(b)-Double.parseDouble(a);
                        b = String.valueOf(res);
                        break;
                    case "X":
                        res = Double.parseDouble(b)*Double.parseDouble(a);
                        b = String.valueOf(res);
                        break;
                    case "/":
                        res = Double.parseDouble(b)/Double.parseDouble(a);
                        b = String.valueOf(res);
                        break;
                }
                a = "";
                int x;
                if(res == (int)res) {x = (int)res;result.setText(String.valueOf(x));}
                else {result.setText(String.valueOf(dff.format(res)));}
                clearafter();


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("");
                result.setText("");
                op.setText("");
                a = "";
                b = "";
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void setbuttons()
    {
        Resources res = getResources();
        int i;
        String b;
        for(i=0;i<10;i++)
        {
            b = "button"+i;
            number[i] = (Button) findViewById(res.getIdentifier(b,"id",getPackageName()));
        }

        point = (Button) findViewById(R.id.point);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        equal = (Button) findViewById(R.id.equal);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        log = (Button) findViewById(R.id.log);
        clear = (Button) findViewById(R.id.clear);

        op = (TextView) findViewById(R.id.op);
        edit = (TextView) findViewById(R.id.edit);
        result = (TextView) findViewById(R.id.result);

        back = (ImageButton) findViewById(R.id.back);
    }

    private void clearafter()
    {
        op.setText("");
        edit.setText("");
    }
}
