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
    private Bitmap []bitmap;
    private float bitmapWidth;
    private float bitmapHeight;
    private float bitmapX;
    private float bitmapY;
    private int walkCnt;//走路计数器，播放对应的图片
    private int restCnt;//休息计数器，播放对应的图片
    public Loli(Context context) {
        super(context);
        bitmap= new Bitmap[5];
        bitmap[0]= BitmapFactory.decodeResource(getResources(),R.drawable.anime1);
        bitmap[1]= BitmapFactory.decodeResource(getResources(),R.drawable.anime2);
        bitmap[2]= BitmapFactory.decodeResource(getResources(),R.drawable.anime3);
        bitmap[3]= BitmapFactory.decodeResource(getResources(),R.drawable.anime4);
        bitmap[4]= BitmapFactory.decodeResource(getResources(),R.drawable.anime5);
        WindowManager wm= (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        bitmapWidth=bitmap[0].getWidth();
        bitmapHeight=bitmap[0].getHeight();
        bitmapX= wm.getDefaultDisplay().getWidth()/2-bitmapWidth/2;//初始坐标
        bitmapY= wm.getDefaultDisplay().getHeight()/2-bitmapHeight/2;
        walkCnt =0;
        restCnt =0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        walkCnt =(walkCnt +1)%bitmap.length;
        restCnt=(restCnt)%bitmap.length;
        canvas.drawBitmap(bitmap[(walkCnt+restCnt)%bitmap.length],bitmapX,bitmapY,paint);
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


}
