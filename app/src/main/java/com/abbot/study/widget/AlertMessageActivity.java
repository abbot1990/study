package com.abbot.study.widget;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.abbot.study.R;

public class AlertMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_message);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.btn_test_alert_dialog:
                showAbout();
                break;
        }
    }

    private void showAbout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("didi");
        builder.setTitle("关于");
        builder.setNegativeButton("好的", null);
        builder.show();
    }
}
