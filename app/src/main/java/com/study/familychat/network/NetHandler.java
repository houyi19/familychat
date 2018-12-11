package com.study.familychat.network;

import com.study.familychat.bean.historyDayBean;
import com.study.familychat.bean.peoplebean;
import com.study.familychat.bean.phonebean;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class NetHandler {

    //进行retrofit的网络请求；
    private static final String KEY_IDCARD = "7bdb988c3ece23dbc65f4e8e59e42880";
    private static final String KEY_PHONE = "0622a979692f29dd68326c7ed2ca1a4f";
    private static final String KEY_HISTORY = "0622a979692f29dd68326c7ed2ca1a4f";

    private static final String URL_BASE1 = "http://apis.juhe.cn/";
    private static final String URL_BASE2 = "http://api.juheapi.com/";

    private static Retrofit getRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        return retrofit;
    }


    public interface handler_bean {
        @GET("idcard/index")
        Observable<peoplebean> getCall(@Query("key") String key, @Query("cardno") String cardID);
    }

    public interface handler_phone_bean {
        @GET("mobile/get")
        Observable<phonebean> getCall(@Query("phone") String phoneId, @Query("key") String key);
    }

    public interface handler_history_bean {
        @GET("japi/toh")
        Observable<historyDayBean> getCall(@Query("key") String key, @Query("v") String version, @Query("month") int m, @Query("day") int d);
    }

    public static Observable<peoplebean> getIDCardResponse(String cardId) {

        Observable<peoplebean> response = getRetrofit(URL_BASE1).create(handler_bean.class).getCall(KEY_IDCARD, cardId);
        return response;
    }

    public static Observable<phonebean> getPhoneResponse(String phoneID) {
        Observable<phonebean> response = getRetrofit(URL_BASE1).create(handler_phone_bean.class).getCall(phoneID, KEY_PHONE);
        return response;
    }

    public static Observable<historyDayBean> getHistoryDayResponse(String v, int m, int day) {
        Observable<historyDayBean> response = getRetrofit(URL_BASE2).create(handler_history_bean.class).getCall(KEY_HISTORY, v, m, day);
        return response;
    }
}
