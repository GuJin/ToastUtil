package tech.gujin.toast;

import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * description:
 * ===============================
 * GuJin 2022/8/22 20:04
 */
class ToastShow {

    private static final ToastUtilHandler sHandler;
    private static Toast sToast;
    private static int sDuration;

    static {
        sHandler = new ToastUtilHandler(Looper.getMainLooper());
    }

    static void show(CharSequence text, boolean durationLong, @Nullable ToastUtil.Mode mode) {
        final int duration = durationLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;

        if (mode == null) {
            mode = ToastConfig.getDefaultMode();
        }

        if (mode != ToastUtil.Mode.REPLACEABLE) {
            Toast.makeText(ToastConfig.getContext(), text, duration).show();
            return;
        }

        if (sToast == null || sDuration != duration) {
            sDuration = duration;
            sToast = Toast.makeText(ToastConfig.getContext(), text, duration);
        } else {
            try {
                sToast.setText(text);
            } catch (RuntimeException e) {
                sToast = Toast.makeText(ToastConfig.getContext(), text, duration);
            }
        }
        sToast.show();
    }

    public static void postShow(CharSequence text, boolean durationLong, ToastUtil.Mode mode) {
        final ToastInfo info = new ToastInfo(text, durationLong, mode);
        sHandler.obtainMessage(ToastUtilHandler.MSG_POST_CHAR_SEQUENCE, info).sendToTarget();
    }
}
