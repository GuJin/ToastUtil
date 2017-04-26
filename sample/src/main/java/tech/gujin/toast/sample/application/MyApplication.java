package tech.gujin.toast.sample.application;

import android.app.Application;

import tech.gujin.toast.ToastUtil;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.initialize(this);
        // replaceable mode
        // ToastUtil.initialize(this, ToastUtil.Mode.REPLACEABLE);
    }
}