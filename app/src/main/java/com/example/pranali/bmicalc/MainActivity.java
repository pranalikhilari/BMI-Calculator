package com.example.pranali.bmicalc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName,etAge,etPhone;
    Button btnRegister;
    RadioGroup rgGender;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAge= findViewById(R.id.etAge);
        etName= findViewById(R.id.etName);
        etPhone= findViewById(R.id.etPhone);
        btnRegister=findViewById(R.id.btnRegister);
        sp = getSharedPreferences("MyDetails",MODE_PRIVATE);
        String name=sp.getString("name","");
        String age=sp.getString("age","");
        String phone =sp.getString("phone","");


        if(name.length()==0||age.length()==0||phone.length()==0)
        {
        btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = etName.getText().toString();
                    String age =etAge.getText().toString();
                    String phone = etPhone.getText().toString();
                    if(name.length()==0)
                    {
                        etName.setError("name is empty");
                        etName.requestFocus();
                        return;
                    }
                    if(age.length()==0)
                    {
                        etAge.setError("age is empty");
                        etAge.requestFocus();
                        return;
                    }
                    if(phone.length()==0)
                    {
                        etPhone.setError("phone is empty");
                        etPhone.requestFocus();
                        return;
                    }

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name",name);
                    editor.putString("phone",phone);
                    editor.putString("age",age);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this,CalculateActivity.class));
                    finish();


                }
            });

    }
    else {
            Toast.makeText(this, "name= "+name+"age= "+age+"Phone= "+phone, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,CalculateActivity.class));
            finish();
        }

       /*public boolean onCreateOptionsMenu(Menu menu)
        {

        }*/
}}

