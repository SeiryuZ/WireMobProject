package com.example.mrtbkwjn.a2018asiangamesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("main", "ONRESUME");
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
        Log.i("main", "ONDESTROY");
    }

}