package com.wsg.lovehome.ui.setting;

import android.content.Context;
import android.view.View;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/8/23.
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.apptitle)
    AppTitle appTitle;

    @Override
    public void initInjector() {

    }


    @Override
    public int bindLayout() {
        return R.layout.activity_setting_main_view;
    }

    @Override
    public void initView(View view) {
        setStausBarTextDeep(true);
        appTitle.setLeftButtonRes(R.drawable.navigationbar_back_selete)
                .setCenterTitle(R.string.setting)
                .setLeftButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
