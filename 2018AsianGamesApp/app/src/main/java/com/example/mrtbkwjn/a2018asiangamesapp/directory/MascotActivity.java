package com.example.mrtbkwjn.a2018asiangamesapp.directory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mrtbkwjn.a2018asiangamesapp.R;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.mascot.Atung;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.mascot.Bhinbhin;
import com.example.mrtbkwjn.a2018asiangamesapp.directory.mascot.Kaka;

public class MascotActivity extends FragmentActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascot);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mSectionsPagerAdapter = new SectionsPagerAdapter(this, fragmentManager);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mascot, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(MascotActivity mascotActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    Bhinbhin bhinbhin = new Bhinbhin();

                    return bhinbhin;
                case 1:
                    Atung atung = new Atung();
                    return atung;
                case 2:
                    Kaka kaka = new Kaka();
                    return kaka;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Bhinbhin";
                case 1:
                    return "Kaka";
                case 2:
                    return "Atung";
            }
            return null;
        }
    }
}
