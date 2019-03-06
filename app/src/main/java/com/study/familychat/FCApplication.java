package com.study.familychat;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class FCApplication extends Application {

    private static final  String TAG = FCApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        //initial log 库
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
