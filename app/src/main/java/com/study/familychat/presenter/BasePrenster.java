package com.study.familychat.presenter;

import com.study.familychat.base.IPresenter;

public class BasePrenster<V> implements IPresenter<V> {
    protected final String TAG = getClass().getSimpleName();
    protected V mView;

    @Override
    public void setView(V v) {
        mView = v;
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
