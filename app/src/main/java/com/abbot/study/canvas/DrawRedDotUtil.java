package com.abbot.study.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by fangzheng on 2017/7/10.
 */

public class DrawRedDotUtil {
    private static Paint mPaint;

    /**
     *
     * @param srcBitmap 原来的bitmap
     * @param centerX   圆心处x坐标值
     * @param centerY   圆心处y坐标值
     * @param radius    圆的半径
     * @return  在原来图片上添加自定义的圆后的图片
     */
    public static Bitmap drawRedDot(Bitmap srcBitmap, float centerX, float centerY, float radius) {
        if (srcBitmap == null) {
            return null;
        }
        int bgWidth = srcBitmap.getWidth();
        int bgHeight = srcBitmap.getHeight();
        Bitmap newBitmap = Bitmap.createBitmap(bgWidth, bgHeight, Bitmap.Config.ARGB_8888);
        Canvas cv = new Canvas(newBitmap);
        cv.drawBitmap(srcBitmap, 0, 0, null);//在 0，0坐标开始画

        //若paint没有自定义，则使用默认初始化
        if (mPaint == null) {
            initPaint();
        }
        //centerX
        centerX = bgWidth-radius;
        centerY = radius;

        cv.drawCircle(centerX, centerY, radius, mPaint);
        cv.save(Canvas.ALL_SAVE_FLAG);//保存
        cv.restore();//存储
        return newBitmap;
    }

    /**
     * 设置自定义的paint
     *
     * @param paint
     */
    public static void setPaint(Paint paint) {
        mPaint = paint;
    }

    /**
     * 返回程序默认初始化的paint
     * @return
     */
    public static Paint getPaint(){
        if(mPaint==null){
            initPaint();
        }
        return mPaint;
    }

    //默认画笔的初始化
    private static void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);//实心
        mPaint.setColor(0xffff0000);//红色
       // mPaint.setAntiAlias(true);//抗锯齿
    }
}
