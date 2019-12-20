package com.example.pranali.bmicalc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class InformationActivity extends AppCompatActivity {
    TextView tvInformation,tv1,tv2,tv3,tv4;
    Button btnBack,btnShare;
    SharedPreferences sp;
    FirebaseDatabase database;
    DatabaseReference myref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        tvInformation= findViewById(R.id.tvInformation);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        btnBack=findViewById(R.id.btnBack);
        btnShare=findViewById(R.id.btnShare);
        database =FirebaseDatabase.getInstance();
        myref= database.getReference("record");

        sp = getSharedPreferences("MyDetails",MODE_PRIVATE);
        final String name = sp.getString("name","");
        final String age = sp.getString("age","");
        final String phone = sp.getString("phone","");

        Intent in = getIntent();
        String s = in.getStringExtra("bmi");
        Float k = Float.parseFloat(s);
        if(k<=18.5)
        {
            tv1.setTextColor(Color.MAGENTA);
            tv1.setTextSize(20);
            tv2.setAllCaps(true);
            tvInformation.setText("your BMI is "+s+"and you are underweight");

        }
        if(k>18.5 &&k<=25)
        {
            tv2.setTextColor(Color.GREEN);
            tv2.setTextSize(20);
            tv2.setAllCaps(true);
            tvInformation.setText("your BMI is "+s+"and you are normal");

        }
        if(k>25 &&k<=30)
        {
            tv3.setTextColor(Color.RED);
            tv3.setTextSize(20);
            tv3.setAllCaps(true);
            tvInformation.setText("your BMI is "+s+"and you are overweight");

        }
        if(k>30)
        {
            tv4.setTextColor(Color.BLACK);
            tv4.setTextSize(20);
            tv4.setAllCaps(true);
            tvInformation.setText("your BMI is "+s+"and you are obese");

        }

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String share = tvInformation.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"result="+ share);
                startActivity(i);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InformationActivity.this,CalculateActivity.class));

            }
        });


    }
}
