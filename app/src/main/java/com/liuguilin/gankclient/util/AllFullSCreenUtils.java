package com.liuguilin.gankclient.util;

import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/10/20.
 */
//保持屏幕全屏的工具类
public class AllFullSCreenUtils {
    public static void KeepFull(AppCompatActivity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
