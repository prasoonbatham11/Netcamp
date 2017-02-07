package com.example.prasoon.calculator;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button login, signup;

    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p = password.getText().toString();

                if(u.equals("") || p.equals(""))
                {
                    Toast.makeText(Login.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data = openOrCreateDatabase("netcamp", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists user (name varchar, password varchar, email varchar, city varchar, phone varchar)");
                    String ch = "select * from user where name='"+u+"' and password='"+p+"'";
                    Cursor cursor = data.rawQuery(ch, null);
                    if(cursor.getCount()==0)
                    {
                        cursor.close();
                        Toast.makeText(Login.this, "User Not Registered. Click signup to register.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent i = new Intent(Login.this, Functions.class);
                        startActivity(i);
                    }
                }
            }
        });





    }
}
