package com.wsg.lovehome.ui.me;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/05/31.
 */
public class MeFragment extends BaseFragmentV4 {

    @BindView(R.id.apptitle)
    AppTitle appTitle;

    @Override
    public int bindLayout() {
        return R.layout.fragment_me_main_view;
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
        appTitle.setCenterTitle("我").setLeftText("添加好友").setRightText("设置");
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
