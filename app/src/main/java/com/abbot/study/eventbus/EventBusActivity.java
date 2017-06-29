package com.abbot.study.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.abbot.study.R;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "EventBusActivity";
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        textView = (TextView) findViewById(R.id.tv_message);
        findViewById(R.id.btn_test_bus).setOnClickListener(this);
        findViewById(R.id.btn_test_bus2).setOnClickListener(this);

        textView2 = (TextView)findViewById(R.id.tv_message2) ;

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
        textView2.setText(messageEvent.getContent());
        EventBus.getDefault().cancelEventDelivery(messageEvent);
    }

    @Subscribe(priority = 8)
    public void setContent2(MessageEvent messageEvent) {
        Log.i(TAG, "setContent: subscribe");
        textView.setText(messageEvent.getContent());
    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
