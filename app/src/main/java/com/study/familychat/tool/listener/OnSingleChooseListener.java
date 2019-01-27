package com.study.familychat.tool.listener;

import android.view.View;

import com.study.familychat.tool.bean.DateBean;


/**
 * 日期点击接口
 */
public interface OnSingleChooseListener {
    /**
     * @param view
     * @param date
     */
    void onSingleChoose(View view, DateBean date);
}
