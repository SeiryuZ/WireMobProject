package com.example.mrtbkwjn.a2018asiangamesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mrtbkwjn.a2018asiangamesapp.liveVideoPlayer.LiveVideoPlayerActivity;


public class StreamingActivity extends AppCompatActivity {

    public final static String RTMP_BASE_URL = "//rtmp://192.168.1.104/LiveApp/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
    }

    public void openVideoPlayer(View view) {
        Intent i = new Intent(this, LiveVideoPlayerActivity.class);
        startActivity(i);
    }
}
