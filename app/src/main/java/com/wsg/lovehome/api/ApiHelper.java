package com.wsg.lovehome.api;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 接口帮助类
 *
 * @author wushange
 *         created at 2016/06/30 14:01
 */
public class ApiHelper extends RetrofitUtil implements APIService {


    private final int pageSize = 10;

    @Override
    public Observable<Response<String>> loadMovieList(int start, int count) {
        return toSubscribe(getService().loadMovieList(start, count));
    }


    @Override
    public Observable<Response<String>> login(String phone, String password) {
        Map<String, String> params = getHttpRequestMap();
        return toSubscribe(getService().login(phone, password));
    }

    @Override
    public Observable<Response<String>> updateIcon(RequestBody body, MultipartBody.Part upFile) {
        return toSubscribe(getService().updateIcon(body, upFile));
    }


    private static <T> Observable toSubscribe(Observable<T> o) {
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取通用参数
     *
     * @return
     */
    public Map<String, String> getHttpRequestMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        return map;
    }

}
