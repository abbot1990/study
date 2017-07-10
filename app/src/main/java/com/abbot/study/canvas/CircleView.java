package com.abbot.study.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.abbot.study.R;

/**
 * <pre>
 *     author : fangzheng
 *     e-mail : 185849480@qq.com
 *     time   : 2017/07/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CircleView extends View {

    private static final String TAG = "CircleView";

    public CircleView(Context context) {
        super(context);
        new CircleView(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(50);

        String content = "圆心";
        Rect rect = new Rect();
        paint.getTextBounds(content,0,1,rect);

        int textWidth = (int) paint.measureText(content,0,1);
        int textHeight = rect.height();

        Log.d(TAG, "onDraw: "+paint.measureText(content,0,1));
        Log.d(TAG, "onDraw: "+paint.measureText(content,0,2));


        Log.d(TAG, "onDraw: "+textWidth+","+textHeight);

        canvas.drawRect(400-textWidth,400-textHeight,400+textWidth,400+textHeight,paint);

        canvas.drawCircle(400,400,60,paint);
        canvas.drawText("圆心",400-textWidth,400+textHeight/2,paint);
       canvas.drawText(content,0,44,paint);

        canvas.drawRect(0,0,400,400,paint);
    }
}
