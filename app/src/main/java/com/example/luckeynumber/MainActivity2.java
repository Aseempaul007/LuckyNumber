package com.example.luckeynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView textView5;
    TextView textView2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView5 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button);

        String name1 = intent.getStringExtra("name_user");
        textView2.setText(name1+" your Luckey Number is");

        double dnum =  Math.random()*10;
        int num = (int)dnum;
        String str = Integer.toString(num);
        textView5.setText(str);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,name1+" is Lucky Today!!");
                i.putExtra(Intent.EXTRA_TEXT,name1+"'s Luckey number is "+str);
                startActivity(Intent.createChooser(i,"Choose a Platform"));
            }
        });


    }
}