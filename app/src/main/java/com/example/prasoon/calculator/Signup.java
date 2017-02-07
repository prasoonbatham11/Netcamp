package com.example.prasoon.calculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText username, password, confirmpassword, email, city, phone;
    Button signup;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setViewIds();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                String cp = confirmpassword.getText().toString();
                String e = email.getText().toString();
                String c = city.getText().toString();
                String ph = phone.getText().toString();

                if(u.equals("") || p.equals("") || cp.equals("") || e.equals("") || c.equals("") || ph.equals("")) {
                    Toast.makeText(Signup.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase data = openOrCreateDatabase("netcamp", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists user (name varchar, password varchar, email varchar, city varchar, phone varchar)");
                    String ch = "select * from user where name='"+u+"' ";
                    Cursor cursor = data.rawQuery(ch, null);
                    String cj = "select * from user where email='"+e+"' ";
                    Cursor cursor1 = data.rawQuery(cj, null);
                    if(cursor.getCount()>0) {
                        cursor.close();
                        cursor1.close();
                        Toast.makeText(Signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else if(cursor1.getCount()>0) {
                        cursor.close();
                        cursor1.close();
                        Toast.makeText(Signup.this, "Email already registered", Toast.LENGTH_SHORT).show();
                    }
                    else if(!p.equals(cp)){
                        cursor.close();
                        cursor1.close();
                        Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                    else if(ph.length()!=10)
                    {
                        cursor.close();
                        cursor1.close();
                        Toast.makeText(Signup.this, "Not a valid phone number", Toast.LENGTH_SHORT).show();
                    }
                    else if(e.indexOf("@")==-1 || e.indexOf("@")!=e.lastIndexOf("@"))
                    {
                        cursor.close();
                        cursor1.close();
                        Toast.makeText(Signup.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        cursor.close();
                        cursor1.close();
                        data.execSQL("insert into user values ('"+u+"', '"+p+"', '"+e+"', '"+c+"', '"+ph+"' )");
                        Toast.makeText(Signup.this, "User Registered", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

    }

    private void setViewIds()
    {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        email = (EditText) findViewById(R.id.email);
        city = (EditText) findViewById(R.id.city);
        phone = (EditText) findViewById(R.id.phone);
        signup = (Button) findViewById(R.id.signup);
        back = (ImageButton) findViewById(R.id.back);
    }
}
