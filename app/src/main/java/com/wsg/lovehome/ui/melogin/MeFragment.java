package com.wsg.lovehome.ui.melogin;

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
        return R.layout.fragment_me_login_view;
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
        appTitle.setCenterTitle("我")
                .setCenterTitleColor(R.color.defult_text_color)
                .setLeftText(R.string.add_friends)
                .setLeftTextColor(R.color.defult_text_color)
                .setRightText("设置").setRightTextColor(R.color.defult_text_color);

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
