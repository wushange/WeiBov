package com.wsg.lovehome.ui.homelogin;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;
import com.wsg.lovehome.api.UserApi;
import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.base.BasePresenter;
import com.wsg.lovehome.bean.HomeWeiBo;
import com.wsg.lovehome.bean.UserBean;
import com.wsg.lovehome.injector.PerActivity;

import javax.inject.Inject;

import retrofit2.Response;
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
                .subscribe(new Action1<Response<String>>() {
                    @Override
                    public void call(Response<String> weiBoResult) {
                        Logger.e("call" + weiBoResult.body().toString());
                        try {
                            HomeWeiBo homeWeiBo = JSON.parseObject(weiBoResult.body().toString(), HomeWeiBo.class);
                            Logger.e("---" + homeWeiBo.getStatuses().size());

                            mView.hideLoading();
                            mView.showWeiBoList(homeWeiBo);
                        } catch (Exception e) {
                            Logger.e("解析错误" + e.getMessage().toString());
                            e.printStackTrace();
                        }

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

        mCompositeSubscription.add(userApi.showUserInfo(uid).subscribe(new Subscriber<UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBean userBean) {
                mView.showUserName(userBean);

            }
        }));

    }
}
