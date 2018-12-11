package com.study.familychat.base;

import android.view.View;

public interface IPresenter<V> {

    //设定特定的View；
    void setView(V v);
    //获取特定的View
    V getView();

    //涉及到订阅的一些
    void subscribe();

    //进行解绑订阅关系；
    void unSubscribe();
}
