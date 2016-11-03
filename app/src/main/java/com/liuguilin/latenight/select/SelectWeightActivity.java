package com.liuguilin.latenight.select;

/*
 *  项目名：  LateNight 
 *  包名：    com.liuguilin.latenight.select
 *  文件名:   SelectWeightActivity
 *  创建者:   LGL
 *  创建时间:  2016/10/21 16:50
 *  描述：    选择体重
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lichfaker.scaleview.BaseScaleView;
import com.lichfaker.scaleview.HorizontalScaleScrollView;
import com.liuguilin.gankclient.R;
import com.liuguilin.latenight.entity.GankUser;
import com.liuguilin.latenight.util.SharePreUtils;
import com.sdsmdg.tastytoast.TastyToast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class SelectWeightActivity extends AppCompatActivity implements View.OnClickListener {

    //下一步
    private Button btn_next;
    private TextView select_tv_weight;
    private HorizontalScaleScrollView horizontalScale;
    private ImageView weight_logo;

    private int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_weight);

        initView();
    }

    private void initView() {
        weight_logo = (ImageView) findViewById(R.id.weight_logo);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        select_tv_weight = (TextView) findViewById(R.id.select_tv_weight);

        String sex = SharePreUtils.getString(this,"sex","男");
        if(sex.equals("男")){
            weight_logo.setBackgroundResource(R.drawable.boy_off);
        }else {
            weight_logo.setBackgroundResource(R.drawable.girl_off);
        }

        horizontalScale = (HorizontalScaleScrollView) findViewById(R.id.horizontalScale);
        horizontalScale.setOnScrollListener(new BaseScaleView.OnScrollListener() {
            @Override
            public void onScaleScroll(int scale) {
                select_tv_weight.setText(scale + "KG");
                weight = scale;
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                updateWeight();
                break;
        }
    }

    private void updateWeight(){
        GankUser user = new GankUser();
        user.setWeight(weight + "KG");
        BmobUser bmobUser = BmobUser.getCurrentUser();
        user.update(bmobUser.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    startActivity(new Intent(SelectWeightActivity.this, SelectConstellationActivity.class));
                    finish();
                } else {
                    TastyToast.makeText(SelectWeightActivity.this,"更新信息失敗",TastyToast.LENGTH_LONG,TastyToast.ERROR);
                }
            }
        });
    }
}
