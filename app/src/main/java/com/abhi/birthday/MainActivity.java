package com.abhi.birthday;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.abhi.birthday.adapter.CustomSwipeAdapter;
import com.abhi.birthday.model.Wishes;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ViewPager viewPager;
    private CustomSwipeAdapter adapterCard;
    private List<Wishes> wishes;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_audio:
                    Intent intentAudio = new Intent(MainActivity.this, Audio.class);
                    startActivity(intentAudio);
                    return true;
                case R.id.navigation_images:
                    Intent intentFun = new Intent(MainActivity.this, Images.class);
                    startActivity(intentFun);
                    return true;
                case R.id.navigation_video:
                    Intent intentVideo = new Intent(MainActivity.this, Video.class);
                    startActivity(intentVideo);
                    return true;
                case R.id.navigation_text:
                    Intent intentText = new Intent(MainActivity.this, Text.class);
                    startActivity(intentText);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wishes = new ArrayList<>();
        wishes.add(new Wishes(R.drawable.wish1));
        wishes.add(new Wishes(R.drawable.wish2));
        wishes.add(new Wishes(R.drawable.wish3));
        wishes.add(new Wishes(R.drawable.wish4));
        wishes.add(new Wishes(R.drawable.wish5));
        wishes.add(new Wishes(R.drawable.wish6));
        wishes.add(new Wishes(R.drawable.wish7));

        adapterCard = new CustomSwipeAdapter(wishes, this);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapterCard);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);    //used for transparency of status bar because originally its translucent but it makes screen go below soft key
            getWindow().getDecorView().setSystemUiVisibility(      //it is used for removing soft key and it prevents soft key from reappearing permenantally  when user interacts with the screen
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            );

        }
    }
}
