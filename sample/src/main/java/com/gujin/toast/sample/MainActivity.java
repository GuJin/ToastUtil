package com.gujin.toast.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gujin.toast.ToastUtil;

public class MainActivity extends Activity implements View.OnClickListener {

    private int mShowCount;
    private int mReplaceableCount;
    private int mLongCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_show).setOnClickListener(this);
        findViewById(R.id.btn_replaceable).setOnClickListener(this);
        findViewById(R.id.btn_long).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                ToastUtil.show("show" + ++mShowCount);
                break;
            case R.id.btn_replaceable:
                ToastUtil.show("replaceable " + ++mReplaceableCount, ToastUtil.Mode.REPLACEABLE);
                break;
            case R.id.btn_long:
                ToastUtil.show("long" + ++mLongCount, true);
                break;
        }
    }
}
