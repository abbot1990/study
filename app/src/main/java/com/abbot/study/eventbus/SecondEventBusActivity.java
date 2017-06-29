package com.abbot.study.eventbus;

import org.greenrobot.eventbus.EventBus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.abbot.study.R;

public class SecondEventBusActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_event_bus);
        findViewById(R.id.btn_second_event_bus).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //EventBus.getDefault().post(new MessageEvent("666"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new MessageEvent("777"));
            }
        }).start();
    }
}
