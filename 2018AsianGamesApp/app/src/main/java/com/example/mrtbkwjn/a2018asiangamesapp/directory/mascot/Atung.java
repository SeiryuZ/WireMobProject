package com.example.mrtbkwjn.a2018asiangamesapp.directory.mascot;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.example.mrtbkwjn.a2018asiangamesapp.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;

public class Atung extends Fragment {

    private FirebaseStorage atungStorage = FirebaseStorage.getInstance("gs://asian-games-2c2a0.appspot.com");
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDetailReference = mDatabase.getReference("Atung");
    private StorageReference mascotStorage;
    private StorageReference mascotBannerStorage;
    private ImageView mascotView;
    private ImageView mascotBannerView;
    private TextView mascotDetail;
    public static final String TAG = "ATUNG";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_atung, container, false);

        mascotStorage = atungStorage.getReference("Mascot/Atung/atungFull.png");
        mascotBannerStorage = atungStorage.getReference("Mascot/Atung/mascot2.jpg");
        mascotView = (ImageView) rootView.findViewById(R.id.mascotAtung);
        mascotBannerView = (ImageView) rootView.findViewById(R.id.mascotBannerAtung);
        mascotDetail = (TextView) rootView.findViewById(R.id.mascotTextViewAtung);

        @GlideModule
        final class MyAppGlideModule extends AppGlideModule {
            @Override
            public void registerComponents(Context context, Glide glide, Registry
                    registry) {
                // Register FirebaseImageLoader to handle StorageReference
                registry.append(StorageReference.class, InputStream.class,
                        new FirebaseImageLoader.Factory());
            }
        }

        Glide.with(rootView)
                .load(mascotStorage)
                .into(mascotView);

        Glide.with(rootView)
                .load(mascotBannerStorage)
                .into(mascotBannerView);

        // Read from the database
        mDetailReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                setTextView(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return rootView;

    }

    private void setTextView(String readText) {
        mascotDetail.setText(readText);
    }
}