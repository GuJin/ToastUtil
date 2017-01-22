package com.gujin.toast;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ToastUtil {
    private static final String TAG = "ToastUtil";
    private static boolean initialized;
    private static Context sContext;
    private static Mode sDefaultMode;
    private static Toast sToast;

    /**
     * Initialize the util.
     *
     * @param context The context to use.
     */
    public static void initialize(Context context) {
        initialize(context, Mode.NORMAL);
    }

    /**
     * Initialize the util with the mode from user.
     *
     * @param context The context to use.
     * @param mode    Is the text can replaced when the toast is showing. Either{@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public static void initialize(Context context, Mode mode) {
        if (initialized) {
            Log.w(TAG, "Invalid initialize, ToastUtil is already initialized");
            return;
        }

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

        initialized = true;
    }

    public enum Mode {

        /**
         * Show as a normal toast. This mode could be user-definable.  This is the default.
         */
        NORMAL,

        /**
         * Show a toast , when it is showing , the text will be replaced if show again.  This mode could be user-definable.
         */
        REPLACEABLE
    }

    private ToastUtil() {}

    /**
     * Shot a toast with the text form a resource.
     *
     * @param resId The resource id of the string resource to use.
     */
    public static void show(int resId) {
        show(sContext.getText(resId));
    }

    /**
     * Shot a toast.
     *
     * @param text The text to show.
     */
    public static void show(CharSequence text) {
        show(text, false);
    }

    /**
     * Shot a toast with the text form a resource.
     * @param resId The resource id of the string resource to use.
     * @param durationLong Whether the toast show for a long period of time?
     */
    public static void show(int resId, boolean durationLong) {
        show(sContext.getText(resId), durationLong);
    }

    public static void show(CharSequence text, boolean durationLong) {
        show(text, durationLong, sDefaultMode);
    }

    public static void show(int resId, Mode mode) {
        show(sContext.getText(resId), false, mode);
    }

    public static void show(CharSequence text, Mode mode) {
        show(text, false, mode);
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
