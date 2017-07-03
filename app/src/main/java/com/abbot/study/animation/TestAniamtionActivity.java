package com.abbot.study.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

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
                translate();
            }
        });
    }

    private void translate(){
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this,R.anim.translate);
        btnAnimationeTest.startAnimation(translateAnimation);
    }
}
