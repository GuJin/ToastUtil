package tech.gujin.toast;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public class ToastUtil {

    private static final String TAG = "ToastUtil";

    private static boolean initialized;

    /**
     * Initialize util.
     *
     * @param context The context to use.
     */
    public synchronized static void initialize(@NonNull Context context) {
        initialize(context, Mode.NORMAL);
    }

    /**
     * Initialize util with the mode from user.
     *
     * @param context     The context to use.
     * @param defaultMode The default display mode tu use. Either{@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public synchronized static void initialize(@NonNull Context context, @NonNull Mode defaultMode) {
        if (initialized) {
            Log.w(TAG, "Invalid initialize, ToastUtil is already initialized");
            return;
        }

        //noinspection ConstantConditions
        if (context == null) {
            throw new NullPointerException("context can not be null");
        }

        //noinspection ConstantConditions
        if (defaultMode == null) {
            defaultMode = Mode.NORMAL;
        }

        ToastConfig.setContext(context.getApplicationContext());
        ToastConfig.setDefaultMode(defaultMode);

        initialized = true;
    }

    /**
     * Display mode
     */
    public enum Mode {

        /**
         * Show as a normal toast. This mode could be user-definable.  This is the default.
         */
        NORMAL,

        /**
         * When the toast is shown to the user , the text will be replaced if call the show() method again.  This mode could be user-definable.
         */
        REPLACEABLE
    }

    /**
     * Show a toast with the text form a resource.
     *
     * @param resId The resource id of the string resource to use.
     */
    public static void show(int resId) {
        show(resId, false);
    }

    /**
     * Show a toast with the text form a resource.
     *
     * @param resId        The resource id of the string resource to use.
     * @param durationLong Whether the toast show for a long period of time?
     */
    public static void show(int resId, boolean durationLong) {
        show(resId, durationLong, null);
    }

    /**
     * Show a toast with the text form a resource.
     *
     * @param resId The resource id of the string resource to use.
     * @param mode  The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public static void show(int resId, @Nullable Mode mode) {
        show(resId, false, mode);
    }

    /**
     * Show a toast with the text form a resource.
     *
     * @param resId        resId The resource id of the string resource to use.
     * @param durationLong Whether the toast show for a long period of time?
     * @param mode         The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public static void show(int resId, boolean durationLong, @Nullable Mode mode) {
        show(getText(resId), durationLong, mode);
    }

    /**
     * Show a toast.
     *
     * @param text The text to show.
     */
    public static void show(CharSequence text) {
        show(text, false);
    }

    /**
     * Show a toast.
     *
     * @param text         The text to show.
     * @param durationLong Whether the toast show for a long period of time?
     */
    public static void show(CharSequence text, boolean durationLong) {
        show(text, durationLong, null);
    }

    /**
     * Show a toast.
     *
     * @param text The text to show.
     * @param mode The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public static void show(CharSequence text, @Nullable Mode mode) {
        show(text, false, mode);
    }

    /**
     * Show a toast.
     *
     * @param text         The text to show.
     * @param durationLong Whether the toast show for a long period of time?
     * @param mode         The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     */
    public static void show(CharSequence text, boolean durationLong, @Nullable Mode mode) {
        ToastShow.show(text, durationLong, mode);
    }

    /**
     * Show a toast with the text form a resource.
     * This method can be invoked from non-UI thread.
     *
     * @param resId The resource id of the string resource to use.
     * @see #show(int)
     */
    public static void postShow(@StringRes int resId) {
        postShow(resId, false);
    }

    /**
     * Show a toast with the text form a resource.
     * This method can be invoked from non-UI thread.
     *
     * @param resId        The resource id of the string resource to use.
     * @param durationLong Whether the toast show for a long period of time?
     * @see #show(int, boolean)
     */
    public static void postShow(int resId, boolean durationLong) {
        postShow(getText(resId), durationLong);
    }

    /**
     * Show a toast with the text form a resource.
     * This method can be invoked from non-UI thread.
     *
     * @param resId The resource id of the string resource to use.
     * @param mode  The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     * @see #show(int, Mode)
     */
    public static void postShow(int resId, @Nullable Mode mode) {
        postShow(resId, false, mode);
    }

    /**
     * Show a toast with the text form a resource.
     * This method can be invoked from non-UI thread.
     *
     * @param resId        resId The resource id of the string resource to use.
     * @param durationLong Whether the toast show for a long period of time?
     * @param mode         The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     * @see #show(int, boolean, Mode)
     */
    public static void postShow(int resId, boolean durationLong, @Nullable Mode mode) {
        postShow(getText(resId), durationLong, mode);
    }

    /**
     * Show a toast.
     * This method can be invoked from non-UI thread.
     *
     * @param text The text to show.
     * @see #show(CharSequence)
     */
    public static void postShow(CharSequence text) {
        postShow(text, false);
    }

    /**
     * Show a toast.
     * This method can be invoked from non-UI thread.
     *
     * @param text         The text to show.
     * @param durationLong Whether the toast show for a long period of time?
     * @see #show(CharSequence, boolean)
     */
    public static void postShow(CharSequence text, boolean durationLong) {
        postShow(text, durationLong, null);
    }

    /**
     * Show a toast.
     * This method can be invoked from non-UI thread.
     *
     * @param text The text to show.
     * @param mode The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     * @see #show(CharSequence, Mode)
     */
    public static void postShow(CharSequence text, @Nullable Mode mode) {
        postShow(text, false, mode);
    }

    /**
     * Show a toast.
     * This method can be invoked from non-UI thread.
     *
     * @param text         The text to show.
     * @param durationLong Whether the toast show for a long period of time?
     * @param mode         The display mode to use.  Either {@link Mode#NORMAL} or {@link Mode#REPLACEABLE}
     * @see #show(CharSequence, boolean, Mode)
     */
    public static void postShow(CharSequence text, boolean durationLong, @Nullable Mode mode) {
        ToastShow.postShow(text, durationLong, mode);
    }

    private static CharSequence getText(@StringRes int resId) {
        return ToastConfig.getContext().getText(resId);
    }

    private ToastUtil() {
    }
}