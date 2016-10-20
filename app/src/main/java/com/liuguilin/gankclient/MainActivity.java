package com.liuguilin.gankclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuguilin.gankclient.util.AllFullSCreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AllFullSCreenUtils.KeepFull(this);
    }

    //双击返回键退出

}
