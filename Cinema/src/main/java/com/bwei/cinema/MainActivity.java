package com.bwei.cinema;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.GuidanceAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public int image[] = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four};
    @BindView(R.id.main_ViewPager)
    ViewPager mainViewPager;
    @BindView(R.id.main_LinearLayout)
    LinearLayout mainLinearLayout;
    private List<ImageView> list;
    //sssss
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        sp = MainActivity.this.getSharedPreferences("Guidance",MODE_PRIVATE);
        if (sp.getBoolean("flag",false)==true){
           // Log.e("tag",sp.getBoolean("flag",false)+"");
            Intent intent = new Intent(MainActivity.this,StartActivity.class);
            startActivity(intent);
            finish();
        }
        Dot();
        GuidanceAdapter adapter = new GuidanceAdapter(image);
        mainViewPager.setAdapter(adapter);
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                for (int i = 0; i < image.length; i++) {
                    if (i == arg0%image.length) {
                        list.get(i).setImageResource(R.mipmap.s);
                    }else{
                        list.get(i).setImageResource(R.mipmap.t);
                    }
                }
                if (image.length-1 == arg0){
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("flag",true);
                    edit.commit();
                    Intent intent = new Intent(MainActivity.this,StartActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


    private void Dot() {
        //点
        for (int i = 0; i < image.length; i++) {
            ImageView iv = new ImageView(MainActivity.this);
            if (i == 0) {
                iv.setImageResource(R.mipmap.s);
            } else {
                iv.setImageResource(R.mipmap.t);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(5, 0, 5, 0);
            mainLinearLayout.addView(iv, params);
            list.add(iv);
        }

    }


}
