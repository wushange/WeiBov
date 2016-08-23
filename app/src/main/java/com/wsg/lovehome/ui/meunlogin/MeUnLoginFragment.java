package com.wsg.lovehome.ui.meunlogin;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.orhanobut.logger.Logger;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/05/31.
 */
public class MeUnLoginFragment extends BaseFragmentV4 {

    @BindView(R.id.pzs_me_view)
    PullToZoomScrollViewEx pullToZoomScrollViewEx;

    @Override
    public int bindLayout() {
        return R.layout.fragment_me_unlogin_main_view;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {

        View headView = LayoutInflater.from(getContext()).inflate(R.layout.me_defult_headview, null, false);
        View zoomView = LayoutInflater.from(getContext()).inflate(R.layout.me_defult_zoomview, null, false);
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.me_defult_contentview, null, false);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (8.0F * (mScreenWidth / 16.0F)));
        pullToZoomScrollViewEx.setHeaderLayoutParams(localObject);
        pullToZoomScrollViewEx.setHeaderView(headView);
        pullToZoomScrollViewEx.setZoomView(zoomView);
        pullToZoomScrollViewEx.setScrollContentView(contentView);

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void lazyInitBusiness(Context mContext) {
        Logger.e("lazyInitBusiness");

    }


    @Override
    public void initInjector() {

    }


}
