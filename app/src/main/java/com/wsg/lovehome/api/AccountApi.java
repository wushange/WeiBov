package com.wsg.lovehome.api;


import com.wsg.lovehome.components.retrofit.RequestHelper;
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
public class AccountApi {

        static final String BASE_URL = " https://api.weibo.com/";
    private static final String API_HOST = "https://api.douban.com/v2/movie";
    //    private static final String API_HOST = "http://192.168.31.209/file";
    public static final String SERVER = API_HOST + "/";
    private AccountService mAccountService;
    private RequestHelper mRequestHelper;

    public AccountApi(RequestHelper mRequestHelper, OkHttpClient mOkHttpClient) {
        this.mRequestHelper = mRequestHelper;
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient)
                        .baseUrl(BASE_URL)
                        .addConverterFactory(FastjsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
        mAccountService = retrofit.create(AccountService.class);
    }

    public Observable<Response<String>> login(String userName, String passWord) {
        return mAccountService.login(userName, passWord).subscribeOn(Schedulers.io());
    }

    public Observable<Response<String>> login1(String userName, String passWord) {
        return mAccountService.loadMovieList(0, 10).subscribeOn(Schedulers.io());
    }
}
