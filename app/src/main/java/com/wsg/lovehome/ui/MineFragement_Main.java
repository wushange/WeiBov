package com.wsg.lovehome.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.ui.melogin.MeFragment;
import com.wsg.lovehome.ui.meunlogin.MeUnLoginFragment;
import com.wsg.lovehome.ui.setting.SettingActivity;
import com.wsg.lovehome.util.AccessTokenKeeper;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/22.
 */
public class MineFragement_Main extends BaseFragmentV4 {
    private FragmentManager fm;
    @BindView(R.id.apptitle)
    AppTitle appTitle;

    @Override
    public void initInjector() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_me_main;
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
        if (AccessTokenKeeper.readAccessToken(getContext()).isSessionValid()) {
            appTitle.setCenterTitle(R.string.me)
                    .setCenterTitleColor(R.color.defult_text_color)
                    .setLeftText(R.string.add_friends)
                    .setLeftTextColor(R.color.defult_text_color)
                    .setRightText(R.string.setting)
                    .setRightTextColor(R.color.defult_text_color)
                    .setRightTextClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mBaseOperation.forward(SettingActivity.class);
                        }
                    });
        } else {
            appTitle.setCenterTitle(R.string.me)
                    .setCenterTitleColor(R.color.black_deep)
                    .setRightText(R.string.setting)
                    .setRightTextColor(R.color.black_deep)
                    .setRightTextClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mBaseOperation.forward(SettingActivity.class);
                        }
                    });
        }

    }

    @Override
    public void doBusiness(Context mContext) {
        Logger.e("doBusiness==" + getContext().getClass().getSimpleName());
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
        Logger.e("lazyInitBusiness==" + getContext().getClass().getSimpleName());

        changeStatus();
    }

    private void changeStatus() {
        fm = getFragmentManager();
        if (AccessTokenKeeper.readAccessToken(getContext()).isSessionValid()) {
            fm.beginTransaction().replace(R.id.me_content, new MeFragment()).commit();
        } else {
            fm.beginTransaction().replace(R.id.me_content, new MeUnLoginFragment()).commit();
        }
    }

}
