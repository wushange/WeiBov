package com.wsg.lovehome.ui.findlogin;

import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.base.BasePresenter;
import com.wsg.lovehome.injector.PerActivity;

import javax.inject.Inject;

/**
 * Created by wushange on 2016/08/19.
 */
@PerActivity
public class FindPresenter extends BasePresenter<FindContract.View> implements FindContract.Presenter {

    WeiBoApi mWeiBoApi;

    @Inject
    public FindPresenter(WeiBoApi weiBoApi) {
        mWeiBoApi = weiBoApi;
    }

    @Override
    public void getPublicWeiBo() {
//        mSubscription = mWeiBoApi.getPublicWeiBo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Response<WeiBoBean>>() {
//            @Override
//            public void call(Response< WeiBoBean> stringResponse) {
////                Log.e("WUSHANGE", stringResponse.body());
//                List<WeiBoBean> weiBoBeanList = new ArrayList<WeiBoBean>();
////                weiBoBeanList = JSON.parseArray(stringResponse.body(), WeiBoBean.class);
////                Logger.e("解析后的集合" + weiBoBeanList.size());
//                Logger.e("解析到" + stringResponse.body() );
//                mView.hideLoading();
//
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                Logger.e("请求错误" + throwable.getMessage().toString());
//                mView.hideLoading();
//            }
//        });


    }
}
