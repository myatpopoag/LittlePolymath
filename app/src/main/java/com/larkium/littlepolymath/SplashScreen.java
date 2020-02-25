package com.larkium.littlepolymath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread t = new Thread() {
            @Override
            public void run() {
                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this,HomeScreen.class));
                    finish();
                }
            }
        };
        t.start();
    }
}
