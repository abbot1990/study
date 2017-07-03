package com.abbot.study.animator;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.abbot.study.R;

public class SunActivity extends AppCompatActivity {
    private static final String TAG = "SunActivity";

    private LinearLayout mSceneView;
    private FrameLayout mSkyView;
    private ImageView mSunView;

    private int mBlueSkyColor;
    private int mSunsetSkyColor;
    private int mNightSkyColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);

        mSceneView = (LinearLayout) findViewById(R.id.scene);
        mSkyView = (FrameLayout)findViewById(R.id.sky);
        mSunView = (ImageView)findViewById(R.id.sun);
        Resources resources = getResources();
        mBlueSkyColor = resources.getColor(R.color.blue_sky,null);
        mSunsetSkyColor = resources.getColor(R.color.sunset_sky,null);
        mNightSkyColor = resources.getColor(R.color.night_sky,null);



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
            .setDuration(10000);
        heightAnimator.setInterpolator(new AccelerateInterpolator());

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator.ofInt(mSkyView,"backgroundColor",mBlueSkyColor,mSunsetSkyColor).setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator nightSkyAnimator = ObjectAnimator
            .ofInt(mSkyView, "backgroundColor", mSunsetSkyColor, mNightSkyColor)
            .setDuration(1500);
        nightSkyAnimator.setEvaluator(new ArgbEvaluator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
            .play(heightAnimator)
            .with(sunsetSkyAnimator)
            .before(nightSkyAnimator);
        animatorSet.start();

    }

    private void testValueAnimator(final View target,final int start,final int end){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1,100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            //持有一个IntEvaluator对象，方便下面估值的时候使用
            private IntEvaluator evaluator = new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                //获得当前动画的进度值
                int currentValue = (Integer) animator.getAnimatedValue();

                //计算当前进度占整个动画过程的比例，浮点型，0-1之间
                float fraction = currentValue/100f;

                //直接调用整型股指期通过比例计算出宽度，然后再社给view
                target.getLayoutParams().width = evaluator.evaluate(fraction,start,end);
                target.requestLayout();
            }
        });
        valueAnimator.setDuration(3000).start();
    }

}
