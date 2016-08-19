package com.wsg.lovehome.api;


import android.content.Context;

import com.wsg.lovehome.components.retrofit.RequestHelper;
import com.wsg.lovehome.util.AccessTokenKeeper;
import com.wushange.converterfastjson.FastjsonConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * 接口定义
 *
 * @author wushange
 *         created at 2016/06/30 14:02
 */
public class WeiBoApi {

    private static final String BASE_URL = "https://api.weibo.com/2/";
    private WeiBoService mWeiBoService;
    private RequestHelper mRequestHelper;
    private Context mContext;

    public WeiBoApi(Context context, RequestHelper mRequestHelper, OkHttpClient mOkHttpClient) {
        this.mContext = context;
        this.mRequestHelper = mRequestHelper;
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient)
                        .baseUrl(BASE_URL)
                        .addConverterFactory(FastjsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
        mWeiBoService = retrofit.create(WeiBoService.class);
    }

    public Observable<Response<String>> getPublicWeiBo() {
        return mWeiBoService.getPublicWeiBo(AccessTokenKeeper.readAccessToken(mContext).getToken(),1).subscribeOn(Schedulers.io());
    }
}