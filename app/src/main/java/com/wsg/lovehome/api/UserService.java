package com.wsg.lovehome.api;

import com.wsg.lovehome.bean.TestUserBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by wushange on 2016/8/25.
 */
public interface UserService {

    @GET("users/show.json")
    Observable<TestUserBean> showUserInfo(@QueryMap Map<String, String> params, @Query("uid") String uid);
}
