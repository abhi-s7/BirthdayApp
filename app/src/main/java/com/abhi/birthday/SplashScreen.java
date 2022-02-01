package com.abhi.birthday;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener{
    public static int SPLASH_TIME_OUT = 5000;
    protected Animation fadeIn;
    protected TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_splash_screen);
        fadeIn = AnimationUtils.loadAnimation        (this,R.anim.fadein);         //animation for image_view
        txt = (TextView) findViewById(R.id.textSplash);
        txt.setVisibility(View.VISIBLE);
        txt.startAnimation(fadeIn);
        new Handler().postDelayed(new Runnable(){
            public void run(){                                         //delay for screen
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();                                                        //to end the activity
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
