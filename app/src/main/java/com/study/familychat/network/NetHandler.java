package com.study.familychat.network;

import com.study.familychat.bean.historyDayBean;
import com.study.familychat.bean.peoplebean;
import com.study.familychat.bean.phonebean;
import com.study.familychat.retrofit.HistoryDayService;
import com.study.familychat.retrofit.PeopleService;
import com.study.familychat.retrofit.PhoneService;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class NetHandler {

    //进行retrofit的网络请求APP_KEY；
    private static final String KEY_IDCARD = "7bdb988c3ece23dbc65f4e8e59e42880";
    private static final String KEY_PHONE = "0622a979692f29dd68326c7ed2ca1a4f";
    private static final String KEY_HISTORY = "0622a979692f29dd68326c7ed2ca1a4f";

    //进行retrofit的前缀地址；
    private static final String URL_BASE1 = "http://apis.juhe.cn/";
    private static final String URL_BASE2 = "http://api.juheapi.com/";

    private static Retrofit getRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        return retrofit;
    }

    public static Observable<peoplebean> FetchIDCardResponse(String cardId) {

        Observable<peoplebean> response = getRetrofit(URL_BASE1).create(PeopleService.class).getCall(KEY_IDCARD, cardId);
        return response;
    }

    public static Observable<phonebean> FetchPhoneResponse(String phoneID) {
        Observable<phonebean> response = getRetrofit(URL_BASE1).create(PhoneService.class).getCall(phoneID, KEY_PHONE);
        return response;
    }

    public static Observable<historyDayBean> FetchHistoryDayResponse(String v, int m, int day) {
        Observable<historyDayBean> response = getRetrofit(URL_BASE2).create(HistoryDayService.class).getCall(KEY_HISTORY, v, m, day);
        return response;
    }
}
