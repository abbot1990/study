package com.abbot.study.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class FrameAnimationTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation_test);
    }

    private void preFrameAnimation(View view){
        view.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable)view.getBackground();
        animationDrawable.start();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
    }
}
