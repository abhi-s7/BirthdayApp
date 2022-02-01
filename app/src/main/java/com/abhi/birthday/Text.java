package com.abhi.birthday;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

public class Text extends AppCompatActivity {


    TextView tv1;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_text);

        tv1 = (TextView) findViewById(R.id.tv1);
        scrollView = (ScrollView) findViewById(R.id.scrollview);
        loadDoc();
    }
    private void loadDoc(){
        String s="Happy birthday to you. From good friends and true, from old friends and new, may good luck go with you and happiness too!\uD83D\uDE1B\uD83D\uDE48\n" +
                "\n" +
                "Katherine, on this birthday, I wish you abundant happiness and love.\uD83D\uDE3A\uD83D\uDE3A\n" +
                "\n" +
                "May all your dreams turn into reality and may lady luck visit your home today.\uD83C\uDF40\uD83C\uDF89\n" +
                "\n" +
                "You are very talented actress and I am a big fan of yours.\uD83C\uDF8A\uD83D\uDE07\n" +
                "\n" +
                "Hope your goodness and pureness will help you to live amazing life.\uD83D\uDE01\uD83E\uDD70";
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv1.setText(s);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0, tv1.getTotalPaddingTop());
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );

        }
    }

}
