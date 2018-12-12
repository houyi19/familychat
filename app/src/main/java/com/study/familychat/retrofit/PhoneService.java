package com.study.familychat.retrofit;

import com.study.familychat.bean.phonebean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhoneService {

    @GET("mobile/get")
    Observable<phonebean> getCall(@Query("phone") String phoneId, @Query("key") String key);
}
