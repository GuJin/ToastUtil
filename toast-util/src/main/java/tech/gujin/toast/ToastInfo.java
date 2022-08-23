package tech.gujin.toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ToastInfo {

    private final CharSequence mText;
    private final boolean mDurationLong;
    @Nullable
    private final ToastUtil.Mode mMode;

    public ToastInfo(CharSequence text, boolean durationLong, @Nullable ToastUtil.Mode mode) {
        this.mText = text;
        this.mDurationLong = durationLong;
        this.mMode = mode;
    }

    public CharSequence getText() {
        return mText;
    }

    public boolean isDurationLong() {
        return mDurationLong;
    }

    @Nullable
    public ToastUtil.Mode getMode() {
        return mMode;
    }

    @NonNull
    @Override
    public String toString() {
        return "ToastInfo{" +
                "Text=" + mText +
                ", DurationLong=" + mDurationLong +
                ", Mode=" + mMode +
                '}';
    }
}