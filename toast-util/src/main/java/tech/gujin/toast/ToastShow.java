package tech.gujin.toast;

import android.os.Build;
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
    private static Toast sReplaceToast;
    private static int sDuration;

    static {
        sHandler = new ToastUtilHandler(Looper.getMainLooper());
    }

    static void show(CharSequence text, boolean durationLong, @Nullable ToastUtil.Mode mode) {
        final int duration = durationLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;

        if (mode == null) {
            mode = ToastConfig.getDefaultMode();
        }

        if (ToastUtil.Mode.NORMAL == mode) {
            Toast.makeText(ToastConfig.getContext(), text, duration).show();
            return;
        }

        if (sReplaceToast == null || sDuration != duration) {
            sDuration = duration;
            sReplaceToast = makeReplaceToast(text, duration);
        } else {
            try {
                sReplaceToast.setText(text);
            } catch (RuntimeException e) {
                sReplaceToast = makeReplaceToast(text, duration);
            }
        }
        sReplaceToast.show();
    }

    private static Toast makeReplaceToast(CharSequence text, int duration) {
        Toast toast = Toast.makeText(ToastConfig.getContext(), text, duration);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            toast.addCallback(new Toast.Callback() {
                @Override
                public void onToastHidden() {
                    sReplaceToast = null;
                }
            });
        }
        return toast;
    }

    public static void postShow(CharSequence text, boolean durationLong, ToastUtil.Mode mode) {
        final ToastInfo info = new ToastInfo(text, durationLong, mode);
        sHandler.obtainMessage(ToastUtilHandler.MSG_POST_CHAR_SEQUENCE, info).sendToTarget();
    }
}
