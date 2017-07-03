package com.abbot.study.animation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.abbot.study.R;

public class SunActivity extends AppCompatActivity {
    private static final String TAG = "SunActivity";

    private LinearLayout mSceneView;
    private FrameLayout mSkyView;
    private ImageView mSunView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);

        mSceneView = (LinearLayout) findViewById(R.id.scene);
        mSkyView = (FrameLayout)findViewById(R.id.sky);
        mSunView = (ImageView)findViewById(R.id.sun);

        mSceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }

    private void startAnimation() {
        float sunYStart = mSunView.getTop();
        float sunYEnd = mSkyView.getHeight();
        Log.i(TAG, "startAnimation: "+sunYStart+","+sunYEnd);
        ObjectAnimator heightAnimator = ObjectAnimator
            .ofFloat(mSunView, "y", sunYStart, sunYEnd)
            .setDuration(3000);
        heightAnimator.start();


    }
}
