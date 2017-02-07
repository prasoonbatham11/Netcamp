package com.example.prasoon.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;

public class Quiz extends AppCompatActivity {


    static Activity activity;

    static String ques[] = {"ADSL is the abbreviation of",
            "What is the meaning of Bandwidth in Network?",
            "DNS is the abbreviation of",
            "How many layers does OSI Reference Model has?",
            "IPV4 Address is",
            "Computer Network is",
            "What is the use of Bridge in Network?",
            "DHCP is the abbreviation of",
            "What is a Firewall in Computer Network?",
            "Router operates in which layer of OSI Reference Model?"
    };

    static String option1[] = {
            "Asymmetric Dual System Line",
            "Connected Computers in the Network",
            "Dynamic Network System",
            "4",
            "64 bit",
            "All",
            "All",
            "Dynamic Host Control Protocol",
            "The physical boundary of Network",
            "Layer 3 (Network Layer)"
    };

    static String option2[] = {
            "Asymmetric Digital System Line",
            "Transmission capacity of a communication channels",
            "Domain Name System",
            "6",
            "32 bit",
            "Sharing of resources and information",
            "to connect LANs",
            "Dynamic Host Configuration Protocol",
            "An operating System of Computer Network",
            "Layer 4 (Transport Layer)"
    };

    static String option3[] = {
            "Asymmetric Digital Subscriber Line",
            "Class of IP used in Network",
            "Dynamic Name System",
            "7",
            "8 bit",
            "Collection of hardware components and computers",
            "to separate LANs",
            "Dynamic Hyper Control Protocol",
            "A system designed to prevent unauthorized access",
            "Layer 1 (Physical Layer)"
    };

    static String option4[] = {
            "Asymmetric Dual Subscriber Line",
            "None",
            "Domain Network Service",
            "5",
            "16 bit",
            "Interconnected by communication channels",
            "to control Network Speed",
            "Dynamic Hyper Configuration Protocol",
            "A web browsing Software",
            "Layer 7 (Application Layer)"
    };

    static int[] correct = {3, 2, 2, 3, 2, 1, 2, 2, 3, 1 };

    static int[] seq;
    static int score;

    ImageButton back, go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        go = (ImageButton) findViewById(R.id.go);
        back = (ImageButton) findViewById(R.id.back);
        seq = generate();
        score = 0;
        activity = this;

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quiz.this, Q1.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    public int[] generate()
    {
        int i = 0;
        int a[] = new int[5];
        boolean c[] = new boolean[10];
        Arrays.fill(c,false);
        while(i<5)
        {
            int r = (int)(Math.random()*10);
            if(!c[r])
            {
                c[r] = true;
                a[i] = r;
                i++;
            }
        }
        return a;
    }

    @Override
    protected void onResume() {
        super.onResume();
        seq = generate();
    }
}
