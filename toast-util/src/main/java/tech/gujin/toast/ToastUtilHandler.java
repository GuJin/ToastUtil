package tech.gujin.toast;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


class ToastUtilHandler extends Handler {

    static final int MSG_POST_RES_ID = 1;
    static final int MSG_POST_CHAR_SEQUENCE = 2;

    ToastUtilHandler(Looper mainLooper) {
        super(mainLooper);
    }

    @Override
    public void handleMessage(Message msg) {
        ToastInfo info = (ToastInfo) msg.obj;
        switch (msg.what) {
            case MSG_POST_RES_ID:
                ToastUtil.show(info.resId, info.durationLong, info.mode);
                break;
            case MSG_POST_CHAR_SEQUENCE:
                ToastUtil.show(info.text, info.durationLong, info.mode);
                break;
        }
    }
}
