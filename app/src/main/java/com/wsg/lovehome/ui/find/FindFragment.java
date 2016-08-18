package com.wsg.lovehome.ui.find;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class FindFragment extends BaseFragmentV4 {
    @BindView(R.id.apptitle)
    AppTitle appTitle;

    @Override
    public void initInjector() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_find_main_view;
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

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }
}
