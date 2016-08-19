package com.wsg.lovehome.ui.messageunlogin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class MessageUnLoginFragment extends BaseFragmentV4 {
    @BindView(R.id.apptitle)
    AppTitle appTitle;
    @BindView(R.id.message_root)
    LinearLayout root;

    @Override
    public void initInjector() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_message_unlogin_main_view;
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
        appTitle.setCenterTitle(R.string.tabbar_message)
                .setCenterTitleColor(R.color.black_deep);
        initEmptyView();
    }

    private void initEmptyView() {
        View emptyView = LayoutInflater.from(getContext()).inflate(R.layout.empty_message_layout, null);
        root.addView(emptyView);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }
}
