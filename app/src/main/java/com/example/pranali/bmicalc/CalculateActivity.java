package com.example.pranali.bmicalc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CalculateActivity extends AppCompatActivity {
    TextView tvDetails;
    SharedPreferences sp;
    EditText etHeight,etWeight;
    Button btnCalculate,btnHistory;
    FirebaseDatabase database;
    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);
        btnCalculate= findViewById(R.id.btnCalculate);
        tvDetails= findViewById(R.id.tvDetails);
        btnHistory=findViewById(R.id.btnHistory);
        sp =getSharedPreferences("MyDetails",MODE_PRIVATE);
        String name = sp.getString("name","");
        tvDetails.setText("Welcome "+name);
        database=FirebaseDatabase.getInstance();
        myref = database.getReference("record");
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = etHeight.getText().toString();
                String weight = etWeight.getText().toString();
                Float i = Float.parseFloat(height);
                Float j = Float.parseFloat(weight);
                Float bmi = j/(i*i);
              /*  if(bmi<=18.5)
                {
                    String s = "Your bmi is "+bmi+" and you are underweight";
                    record r = new record(s);
                    myref.push().setValue(r);
                    Toast.makeText(CalculateActivity.this, "Record Added !", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(CalculateActivity.this,InformationActivity.class);
                    in.putExtra("bmi",s);
                    startActivity(in);

                    /*.setText("your BMI is "+s+"and you are underweight");

                }
                if(bmi>18.5 &&bmi<=25)
                {
                    String s = "Your bmi is "+bmi+" and you are normal";
                    record r = new record(s);
                    myref.push().setValue(r);
                    Toast.makeText(CalculateActivity.this, "Record Added !", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(CalculateActivity.this,InformationActivity.class);
                    in.putExtra("bmi",s);
                    startActivity(in);
                }
                if(bmi>25 &&bmi<=30)
                {
                    String s = "Your bmi is "+bmi+" and you are overweight";
                    record r = new record(s);
                    myref.push().setValue(r);
                    Toast.makeText(CalculateActivity.this, "Record Added !", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(CalculateActivity.this,InformationActivity.class);
                    in.putExtra("bmi",s);
                    startActivity(in);

                    }
                if(bmi>30)
                {
                    String s = "Your bmi is "+bmi+" and you are obese";
                    record r = new record(s);
                    myref.push().setValue(r);
                    Toast.makeText(CalculateActivity.this, "Record Added !", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(CalculateActivity.this,InformationActivity.class);
                    in.putExtra("bmi",s);
                    startActivity(in);

                }
              */
                String st = Float.toString(bmi);
               record r = new record(st);
               myref.push().setValue(r);
                Toast.makeText(CalculateActivity.this, "Record Added !", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(CalculateActivity.this,InformationActivity.class);
                in.putExtra("bmi",st);
                startActivity(in);
           }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CalculateActivity.this,ViewActivity.class);
                startActivity(i);

            }
        });

    }
}
