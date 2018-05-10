package com.example.mrtbkwjn.a2018asiangamesapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    private ImageButton googleButton = (ImageButton) findViewById(R.id.glogButton);
    private ImageButton facebookButton = (ImageButton) findViewById(R.id.fblogButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //View decorView = getWindow().getDecorView();
        // Hide the status bar.
        //int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
       // decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
       // ActionBar actionBar = getActionBar();
        //actionBar.hide();

    }

    @Override
    public void onClick(View view){
        if(view == googleButton){
            Intent menuIntent = new Intent (LoginActivity.this, MenuActivity.java);
            startActivity(menuIntent);
        }
        else if (view == facebookButton){
            Intent menuIntent = new Intent (LoginActivity.this, MenuActivity.java);
            startActivity(menuIntent);
        }
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
