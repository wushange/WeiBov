package com.wsg.lovehome.api;

import com.wsg.lovehome.bean.HomeWeiBo;

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
    Observable<HomeWeiBo.StatusesBean.UserBean> showUserInfo(@QueryMap Map<String, String> params, @Query("uid") String uid);
}
