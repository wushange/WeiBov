package com.wsg.lovehome.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.util.AccessTokenKeeper;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class HomeFragment extends BaseFragmentV4 {
    @BindView(R.id.apptitle)
    AppTitle appTitle;
    @BindView(R.id.home_root)
    LinearLayout root;

    @Override
    public void initInjector() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home_main_view;
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
        appTitle.setCenterTitle(AccessTokenKeeper.readAccessToken(getContext()).getUid())
                .setCenterTitleColor(R.color.black_deep)
                .setLeftImage(R.drawable.navigationbar_friendattention_selete)
                .setLeftImageClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setRightImageRes(R.drawable.navigationbar_icon_radar_selete)
                .setRightImageClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        appTitle.getmCenterTitle().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.timeline_icon_more_highlighted, 0);
        appTitle.setCenterTitilClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appTitle.getmCenterTitle().setCompoundDrawablesWithIntrinsicBounds(0,0,R.mipmap.timeline_icon_more_highlighted_uper,0);
            }
        });

    }


    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }
}
