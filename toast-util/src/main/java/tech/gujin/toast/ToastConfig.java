package tech.gujin.toast;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * description:
 * ===============================
 * GuJin 2022/8/22 20:06
 */
class ToastConfig {

    @SuppressLint("StaticFieldLeak")
    static Context sContext;
    static ToastUtil.Mode sDefaultMode;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }

    public static ToastUtil.Mode getDefaultMode() {
        return sDefaultMode;
    }

    public static void setDefaultMode(ToastUtil.Mode defaultMode) {
        sDefaultMode = defaultMode;
    }
}
