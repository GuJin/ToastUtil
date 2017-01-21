package com.gujin.utils.toast;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private static Context sContext;
    private static Mode sDefaultMode;
    private static Toast sToast;

    public static void initialize(Context context) {
        initialize(context, Mode.NORMAL);
    }

    /**
     * @param context The context to use.
     * @param mode    Is the text can replaced when the toast is showing. Either{@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public static void initialize(Context context, Mode mode) {
        if (context == null) {
            throw new NullPointerException("context can not be null");
        }

        if (context instanceof Application) {
            sContext = context;
        } else {
            sContext = context.getApplicationContext();
        }

        if (mode == null) {
            sDefaultMode = Mode.NORMAL;
        } else {
            sDefaultMode = mode;
        }
    }

    public enum Mode {

        /**
         * Show as a normal toast.
         * This is the default.
         */
        NORMAL,

        /**
         * Show a toast , when it is showing , the text will be replaced if show again.
         */
        REPLACEABLE;
    }

    private ToastUtil() {}

    public static void show(int resId) {
        show(sContext.getText(resId));
    }

    public static void show(CharSequence text) {
        show(text, false);
    }

    public static void show(int resId, boolean durationLong) {
        show(sContext.getText(resId), durationLong);
    }

    public static void show(CharSequence text, boolean durationLong) {
        show(text, durationLong, sDefaultMode);
    }

    public static void show(int resId, boolean durationLong, Mode mode) {
        show(sContext.getText(resId), durationLong, mode);
    }

    public static void show(CharSequence text, boolean durationLong, Mode mode) {
        if (mode == Mode.NORMAL) {
            Toast.makeText(sContext, text, durationLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
            return;
        }

        if (sToast == null) {
            sToast = Toast.makeText(sContext, text, durationLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        } else {
            sToast.setText(text);
        }
        sToast.show();
    }
}
