package tech.gujin.toast.sample.runnable;

import tech.gujin.toast.ToastUtil;

public class ToastRunnable implements Runnable {

    private final int mCount;
    private final ToastUtil.Mode mMode;

    public ToastRunnable(int count, ToastUtil.Mode mode) {
        mCount = count;
        mMode = mode;
    }

    @Override
    public void run() {
        String msg = (mMode == ToastUtil.Mode.REPLACEABLE ? "sub-thread (replaceable) " : "sub-thread (normal) ") + mCount;
        ToastUtil.postShow(msg, mMode);
    }
}
