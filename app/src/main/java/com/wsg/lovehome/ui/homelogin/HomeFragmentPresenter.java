package com.wsg.lovehome.ui.homelogin;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.api.UserApi;
import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.base.BasePresenter;
import com.wsg.lovehome.bean.HomeWeiBo;
import com.wsg.lovehome.injector.PerActivity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by wushange on 2016/8/25.
 */
@PerActivity
public class HomeFragmentPresenter extends BasePresenter<HomeFrgmentContract.View> implements HomeFrgmentContract.Presenter {

    private Context context;
    private WeiBoApi weiBoApi;
    private UserApi userApi;

    @Inject
    public HomeFragmentPresenter(Context context, WeiBoApi weiBoApi, UserApi userApi) {
        this.context = context;
        this.weiBoApi = weiBoApi;
        this.userApi = userApi;
    }

    @Override
    public void getWeiBoList(int page) {

        mView.showLoading();
        mCompositeSubscription.add(weiBoApi.getHomeWeiBo(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeWeiBo>() {
                    @Override
                    public void call(HomeWeiBo weiBoResult) {
                            mView.hideLoading();
                            mView.showWeiBoList(weiBoResult);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e("请求一场" + throwable.getMessage().toString());
                        mView.hideLoading();

                    }
                }));

    }

    @Override
    public void getUserInfo(String uid) {

        mCompositeSubscription.add(userApi.showUserInfo(uid).subscribe(new Subscriber<HomeWeiBo.StatusesBean.UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HomeWeiBo.StatusesBean.UserBean userBean) {
                mView.showUserName(userBean);

            }
        }));

    }
}
