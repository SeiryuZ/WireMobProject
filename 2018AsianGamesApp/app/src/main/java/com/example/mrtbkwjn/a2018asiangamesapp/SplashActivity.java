package com.example.mrtbkwjn.a2018asiangamesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView headerLogo;
    private Animation fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        headerLogo = (ImageView) findViewById(R.id.aslogo);
        fromTop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        headerLogo.setAnimation(fromTop);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
               startActivity(loginIntent);
               finish();
           }
       } ,6000);
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
