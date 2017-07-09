package com.abbot.study.canvas;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.abbot.study.R;
import com.abbot.study.tools.DisplayUtil;

public class CanvasActivity extends AppCompatActivity {
    private static final String TAG = "CanvasActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Log.i(TAG, "onCreate: "+ DisplayUtil.dp2px(this,100));

        ImageView imageView = (ImageView)findViewById(R.id.iv_bitmap);
        imageView.setImageBitmap(R.drawable.bitmap_test);

        Bitmap.
    }
}
