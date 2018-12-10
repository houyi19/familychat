package com.study.familychat.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HolderBase<T> extends RecyclerView.ViewHolder {


    public HolderBase(View itemView) {
        super(itemView);
    }

    public void bindHolder(T t) {

    }
    public void bindHolder(T t, Object object) {
    }

    public void bindHolder(T t, Object obj0, Object obj1) {
    }

    public void bindHolder(T t, Object obj0, Object obj1, Object obj2) {
    }

    public void unbindHolder() {
    }
}
