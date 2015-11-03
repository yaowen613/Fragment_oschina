package com.yaowen.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Display display = getWindowManager().getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            Fragment1 fragment1 = new Fragment1();
            getFragmentManager()//1.获取到FragmentManager，在Activity中可以直接通过getFragmentManager得到。
                    .beginTransaction()//2.开启一个事务，通过调用beginTransaction方法开启。
                            //3.向容器内加入Fragment，一般使用replace方法实现，需要传入容器的id和Fragment的实例。
                    .replace(R.id.main_layout, fragment1)
                    .commit();//4.提交事务，调用commit方法提交。
        } else {
            Fragment2 fragment2 = new Fragment2();
            getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commit();
        }
    }
}

