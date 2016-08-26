package com.wsg.lovehome.api;

import android.content.Context;

import com.wsg.lovehome.bean.HomeWeiBo;
import com.wsg.lovehome.components.retrofit.RequestHelper;
import com.wushange.converterfastjson.FastjsonConverterFactory;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wushange on 2016/8/25.
 */
public class UserApi {
    static final String BASE_URL = "https://api.weibo.com/2/";
    private Context mContext;
    private UserService mUserService;
    private RequestHelper mRequestHelper;

    public UserApi(Context context, RequestHelper mRequestHelper, OkHttpClient mOkHttpClient) {
        this.mContext = context;
        this.mRequestHelper = mRequestHelper;
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient)
                        .baseUrl(BASE_URL)
                        .addConverterFactory(FastjsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
        mUserService = retrofit.create(UserService.class);
    }

    public Observable<HomeWeiBo.StatusesBean.UserBean> showUserInfo(String uid) {
        Map<String, String> params = mRequestHelper.getHttpRequestMap();
        return mUserService.showUserInfo(params, uid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
