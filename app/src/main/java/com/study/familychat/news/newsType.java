package com.study.familychat.news;

import android.support.annotation.IntDef;

public class newsType {

    //TO-DO 暂时只加入头条这一栏目；
    @IntDef ({
        TOU_TIAO,
    })

    public @interface Near{};

    public  static  final  int TOU_TIAO = 1;
}
