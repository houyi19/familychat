package com.study.familychat.utils;

import android.app.Activity;
import android.support.annotation.NonNull;

public interface onRequestPermission {

    void grantPermissionResult(Activity mAct, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
