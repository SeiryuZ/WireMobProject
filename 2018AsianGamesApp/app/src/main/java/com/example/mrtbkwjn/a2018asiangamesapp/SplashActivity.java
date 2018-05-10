package com.example.mrtbkwjn.a2018asiangamesapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("main","ONRESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("main", "ONPAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("main", "ONSTOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("main","ONDESTROY");
    }
}
