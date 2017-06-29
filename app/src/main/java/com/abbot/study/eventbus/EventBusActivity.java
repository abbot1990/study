package com.abbot.study.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.abbot.study.R;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "EventBusActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        textView = (TextView) findViewById(R.id.tv_message);
        findViewById(R.id.btn_test_bus).setOnClickListener(this);
        findViewById(R.id.btn_test_bus2).setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_bus:
                Log.i(TAG, "onClick:");
                //本页面修改
                EventBus.getDefault().post(new MessageEvent("hello"));
                break;
            case R.id.btn_test_bus2:
                //跳转到另一页去修改
                Intent intent = new Intent(this,SecondEventBusActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void setContent(MessageEvent messageEvent) {
        Log.i(TAG, "setContent: subscribe");
        textView.setText(messageEvent.getContent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
