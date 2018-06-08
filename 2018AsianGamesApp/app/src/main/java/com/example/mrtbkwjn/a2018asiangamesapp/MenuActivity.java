package com.example.mrtbkwjn.a2018asiangamesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.mrtbkwjn.a2018asiangamesapp.directory.GameActivity;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.MascotActivity;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.NewsActivity;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.ParticipantActivity;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.VenueActivity;

import java.util.ArrayList;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {


    private String[] eventList = {"FOTB", "SWIM", "BSKT", "VOLL", "SOFT", "TRIA", "PNCK"};
    private ArrayList<String> chosenEvent = new ArrayList<>();

    private RecyclerView eventListView;
    private EventAdapter eventAdapter;
    private RecyclerView.LayoutManager eventLayoutManager;

    private boolean doubleTap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        eventListView = (RecyclerView) findViewById(R.id.scheduleView);
        eventLayoutManager = new LinearLayoutManager(this);
        eventListView.setLayoutManager(eventLayoutManager);

        eventAdapter = new EventAdapter(chosenEvent);
        eventListView.setAdapter(eventAdapter);

        for(int i = 0; i < eventList.length; i++) {
            addEvent(eventListView);
        }

    }

    public void addEvent(View view) {
        Random random = new Random();
        chosenEvent.add(eventList[random.nextInt(eventList.length)]);

        eventAdapter.notifyDataSetChanged();
    }

    public void goToGame(View view) {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
    }

    public void goToVenue(View view) {
        Intent venueIntent = new Intent(this, VenueActivity.class);
        startActivity(venueIntent);
    }

    public void goToParticipant(View view) {
        Intent participantIntent = new Intent(this, ParticipantActivity.class);
        startActivity(participantIntent);
    }

    public void goToMascot(View view) {
        Intent mascotIntent = new Intent(this, MascotActivity.class);
        startActivity(mascotIntent);
    }

    public void goToNews(View view) {
        Intent newsIntent = new Intent(this, NewsActivity.class);
        startActivity(newsIntent);
    }

    public void liveEvent(View view) {
        Intent liveEventIntent = new Intent(this, StreamingActivity.class);
        startActivity(liveEventIntent);
    }

    @Override
    public void onBackPressed() {
        if (doubleTap) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Press BACK again to exit app!", Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                    System.exit(1);
                    finish();
                }
            }, 500);
        }
    }

}