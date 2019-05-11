package com.bwei.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.start_RelativeLayout)
    RelativeLayout startRelativeLayout;
    @BindView(R.id.start_TextView)
    TextView startTextView;
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        mTimer = new Timer();
        TimerTask mTimerTask = new TimerTask() {
            int num = 3;

            @Override
            public void run() {
                //run方法中执行需要间隔执行的代码
                num--;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (num == 0) {
                            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                            startActivity(intent);
                            //Toast.makeText(StartActivity.this, "跳转", Toast.LENGTH_SHORT).show();
                            overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                            finish();
                            mTimer.cancel();
                        }
                    }
                });
            }
        };
        //2s后开始执行，间隔为4s
        mTimer.schedule(mTimerTask, 0, 1000);
    }
}
