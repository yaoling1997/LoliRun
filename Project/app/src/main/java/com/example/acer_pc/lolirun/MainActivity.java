package com.example.acer_pc.lolirun;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        FrameLayout myLayout= (FrameLayout)findViewById(R.id.myLayout);
        final Loli loli= new Loli(MainActivity.this);
        final Handler handler= new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==0x123){
                    loli.setRestCnt(loli.getRestCnt()+1);
                    loli.invalidate();
                }
                super.handleMessage(msg);
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,1000);
        loli.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                loli.setBitmapX(motionEvent.getX()-loli.getBitmapWidth()/2);
                loli.setBitmapY(motionEvent.getY()-loli.getBitmapHeight()/2);
                loli.invalidate();
                return true;
            }
        });
        myLayout.addView(loli);
    }
}