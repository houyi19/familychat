package com.study.familychat.base;

import android.view.View;

public abstract class HolderBaseRecycler<T> extends HolderBase<T> {
    public HolderBaseRecycler(View itemView) {
        super(itemView);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
