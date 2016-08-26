package com.wsg.lovehome.ui.regist;

import android.content.Context;
import android.view.View;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/17.
 */
public class RegistActivity extends BaseActivity {
    @BindView(R.id.apptitle)
    AppTitle appTitle;

    @Override
    public void initInjector() {

    }


    @Override
    public int bindLayout() {
        return R.layout.activity_regist_main_view;
    }

    @Override
    public void initView(View view) {
        appTitle.setLeftText(R.string.app_cancel)
                .setLeftTextColor(R.color.black_deep)
                .setLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }).setCenterTitle(R.string.regist_text)
                .setCenterTitleColor(R.color.black_deep);
        mBaseOperation.setStatusBarTextColor(true);

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
