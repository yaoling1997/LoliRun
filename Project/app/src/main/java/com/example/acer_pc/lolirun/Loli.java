package com.example.acer_pc.lolirun;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by acer-pc on 2018/1/21.
 */

public class Loli extends View {
    final static float moveDistance=(float)10;
    private Bitmap []bitmapWalk;
    private Bitmap []bitmapRest;
    private float bitmapWidth;
    private float bitmapHeight;
    private float bitmapX;//图片底部中点x坐标
    private float bitmapY;//图片底部中点y坐标
    private int walkCnt;//走路计数器，播放对应的图片
    private int restCnt;//休息计数器，播放对应的图片
    private int status;//state==0 rest,state>0 walk
    private int slow;//用来减缓行走播放速度
    public Loli(Context context) {
        super(context);
        bitmapWalk= new Bitmap[5];
        bitmapWalk[0]= BitmapFactory.decodeResource(getResources(),R.drawable.walk1);
        bitmapWalk[1]= BitmapFactory.decodeResource(getResources(),R.drawable.walk2);
        bitmapWalk[2]= BitmapFactory.decodeResource(getResources(),R.drawable.walk3);
        bitmapWalk[3]= BitmapFactory.decodeResource(getResources(),R.drawable.walk4);
        bitmapWalk[4]= BitmapFactory.decodeResource(getResources(),R.drawable.walk5);
        bitmapRest= new Bitmap[7];
        bitmapRest[0]= BitmapFactory.decodeResource(getResources(),R.drawable.rest1);
        bitmapRest[1]= BitmapFactory.decodeResource(getResources(),R.drawable.rest2);
        bitmapRest[2]= BitmapFactory.decodeResource(getResources(),R.drawable.rest3);
        bitmapRest[3]= BitmapFactory.decodeResource(getResources(),R.drawable.rest4);
        bitmapRest[4]= BitmapFactory.decodeResource(getResources(),R.drawable.rest5);
        bitmapRest[5]= BitmapFactory.decodeResource(getResources(),R.drawable.rest6);
        bitmapRest[6]= BitmapFactory.decodeResource(getResources(),R.drawable.rest7);
        WindowManager wm= (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        bitmapWidth=bitmapWalk[0].getWidth();
        bitmapHeight=bitmapWalk[0].getHeight();
        bitmapX= wm.getDefaultDisplay().getWidth()/2;//初始坐标
        bitmapY= wm.getDefaultDisplay().getHeight()/2;
        walkCnt =0;
        restCnt =0;
        status =0;
        slow=10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        walkCnt =(walkCnt)%(bitmapWalk.length*slow);
        restCnt=(restCnt)%bitmapRest.length;
        if (status>0)
            canvas.drawBitmap(bitmapWalk[walkCnt/slow],bitmapX-bitmapWidth/2,bitmapY-bitmapHeight,paint);
        else
            canvas.drawBitmap(bitmapRest[restCnt],bitmapX-bitmapWidth/2,bitmapY-bitmapHeight,paint);
    }

    public float getBitmapWidth() {
        return bitmapWidth;
    }

    public float getBitmapHeight() {
        return bitmapHeight;
    }

    public float getBitmapX() {
        return bitmapX;
    }

    public void setBitmapX(float bitmapX) {
        this.bitmapX = bitmapX;
    }

    public float getBitmapY() {
        return bitmapY;
    }

    public void setBitmapY(float bitmapY) {
        this.bitmapY = bitmapY;
    }

    public int getRestCnt() {
        return restCnt;
    }

    public void setRestCnt(int restCnt) {
        this.restCnt = restCnt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWalkCnt() {
        return walkCnt;
    }

    public void setWalkCnt(int walkCnt) {
        this.walkCnt = walkCnt;
    }
}
