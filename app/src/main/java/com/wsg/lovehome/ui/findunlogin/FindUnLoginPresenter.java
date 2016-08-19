package com.wsg.lovehome.ui.findunlogin;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.base.BasePresenter;
import com.wsg.lovehome.injector.PerActivity;

import javax.inject.Inject;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by wushange on 2016/08/19.
 */
@PerActivity
public class FindUnLoginPresenter extends BasePresenter<FindUnLoginContract.View> implements FindUnLoginContract.Presenter {

    WeiBoApi mWeiBoApi;

    @Inject
    public FindUnLoginPresenter(WeiBoApi weiBoApi) {
        mWeiBoApi = weiBoApi;
    }

    @Override
    public void getPublicWeiBo() {
        mSubscription = mWeiBoApi.getPublicWeiBo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Response<String>>() {
            @Override
            public void call(Response<String> stringResponse) {
                Logger.json(stringResponse.body());
                Log.e("WUSHANGE", stringResponse.body());
                mView.showList();

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });


    }
}
