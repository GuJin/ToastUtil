package tech.gujin.toast;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ToastUtilHandler extends Handler {

    static final int MSG_POST_CHAR_SEQUENCE = 1;

    ToastUtilHandler(Looper mainLooper) {
        super(mainLooper);
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.what == MSG_POST_CHAR_SEQUENCE) {
            ToastInfo info = (ToastInfo) msg.obj;
            ToastUtil.show(info.getText(), info.isDurationLong(), info.getMode());
        }
    }
}