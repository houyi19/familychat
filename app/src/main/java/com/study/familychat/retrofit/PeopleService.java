package com.study.familychat.retrofit;

import com.study.familychat.bean.peoplebean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeopleService {

    @GET("idcard/index")
    Observable<peoplebean> getCall(@Query("key") String key, @Query("cardno") String cardID);
}
