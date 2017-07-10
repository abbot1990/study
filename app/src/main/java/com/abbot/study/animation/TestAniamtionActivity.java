package com.abbot.study.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.abbot.study.R;

public class TestAniamtionActivity extends AppCompatActivity {

    private Button btnAnimationeTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_aniamtion);

        btnAnimationeTest = (Button)findViewById(R.id.btn_animation_test);
        btnAnimationeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //translate();
                go();
            }
        });

        TextView tv = (TextView)findViewById(R.id.tv_red);
        tv.setCompoundDrawables(null,null,getDrawable(R.drawable.red_tip_),null);
    }

    private void translate(){
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this,R.anim.translate);
        btnAnimationeTest.startAnimation(translateAnimation);
    }

    private void go(){
        Intent intent = new Intent(this,FrameAnimationTestActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out);

    }
    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
