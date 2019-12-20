package com.example.pranali.bmicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;

public class SplashActivity extends AppCompatActivity {
    ImageView ivBMI;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivBMI=findViewById(R.id.ivBMI);
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.a1);
        ivBMI.startAnimation(animation);



        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    Thread.sleep(5000);
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }catch (InterruptedException e){e.printStackTrace();}
            }
        }).start();
}}
