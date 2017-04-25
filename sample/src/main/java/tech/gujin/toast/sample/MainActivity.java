package tech.gujin.toast.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tech.gujin.toast.ToastUtil;
import tech.gujin.toast.sample.runnable.ToastRunnable;

public class MainActivity extends Activity implements View.OnClickListener {

    private int mNormalCount;
    private int mReplaceableCount;
    private int mLongNormalCount;
    private int mLongReplaceableCount;
    private int mSubThreadNormalCount;
    private int mSubThreadReplaceableCount;

    private ExecutorService mExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
        mExecutorService = Executors.newCachedThreadPool();
    }

    private void setListener() {
        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn_replaceable).setOnClickListener(this);
        findViewById(R.id.btn_long_normal).setOnClickListener(this);
        findViewById(R.id.btn_long_replaceable).setOnClickListener(this);
        findViewById(R.id.btn_sub_thread_normal).setOnClickListener(this);
        findViewById(R.id.btn_sub_thread_replaceable).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                ToastUtil.show("normal" + ++mNormalCount);
                break;
            case R.id.btn_replaceable:
                ToastUtil.show("replaceable " + ++mReplaceableCount, ToastUtil.Mode.REPLACEABLE);
                break;
            case R.id.btn_long_normal:
                ToastUtil.show("long (normal) " + ++mLongNormalCount, true);
                break;
            case R.id.btn_long_replaceable:
                ToastUtil.show("long (replaceable) " + ++mLongReplaceableCount, true, ToastUtil.Mode.REPLACEABLE);
                break;
            case R.id.btn_sub_thread_normal:
                startThread(++mSubThreadNormalCount);
                break;
            case R.id.btn_sub_thread_replaceable:
                startThread(++mSubThreadReplaceableCount, ToastUtil.Mode.REPLACEABLE);
                break;
        }
    }

    private void startThread(int count) {
        startThread(count, null);
    }

    private void startThread(int count, ToastUtil.Mode mode) {
        mExecutorService.execute(new ToastRunnable(count, mode));
    }
}
