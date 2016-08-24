package com.wsg.lovehome.ui.hotweibo;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.base.BasePresenter;
import com.wsg.lovehome.bean.WeiBoResult;
import com.wsg.lovehome.injector.PerActivity;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by wushange on 2016/08/19.
 */
@PerActivity
public class HotWeiBoPresenter extends BasePresenter<HotWeiBoContract.View> implements HotWeiBoContract.Presenter {

    WeiBoApi mWeiBoApi;

    @Inject
    public HotWeiBoPresenter(WeiBoApi weiBoApi) {
        mWeiBoApi = weiBoApi;
    }

    @Override
    public void getPublicWeiBo(int page) {
        mView.showLoading();
        mSubscription = mWeiBoApi.getPublicWeiBo(page).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<WeiBoResult>() {
            @Override
            public void call(WeiBoResult result) {
                Logger.e("解析到" + result.getStatuses().size());
                mView.showList(result);
                mView.hideLoading();

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.e("请求错误" + throwable.getMessage().toString());
                mView.hideLoading();
            }
        });


    }
}
