package com.study.familychat.tool.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class toolItemVIew extends FrameLayout {
    public toolItemVIew(Context context) {
        super(context);
    }

    public toolItemVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public toolItemVIew(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
