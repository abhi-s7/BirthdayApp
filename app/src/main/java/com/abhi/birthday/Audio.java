package com.abhi.birthday;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class Audio extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton btnPlay;
    private ImageButton btnBack,btnFor;
    private SeekBar seekBar1;
    private MediaPlayer mediaPlayer;
    private Runnable runnable;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        btnPlay = findViewById(R.id.btn_play);
        btnBack = findViewById(R.id.btn_prev);
        btnFor = findViewById(R.id.btn_next);
        handler = new Handler();

        mediaPlayer =  MediaPlayer.create(this, R.raw.audio);

        seekBar1 =  findViewById(R.id.seekbar);

        btnPlay.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnFor.setOnClickListener(this);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar1.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
            }
        });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void changeSeekbar() {

        seekBar1.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying()){

            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };

            handler.postDelayed(runnable,1000);

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_play:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_play_arrow);
                }else{

                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause);
                    changeSeekbar();

                }
                break;

            case R.id.btn_prev:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 3000);
                break;

            case R.id.btn_next:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 3000);
                break;

        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
        mediaPlayer.release();
    }


    @Override
    protected void onPause() {
        mediaPlayer.pause();
        btnPlay.setImageResource(R.drawable.ic_play_arrow);
//        handler.removeCallbacks(runnable);
            super.onPause();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            //            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            //            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            //            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            );

        }
    }
}
