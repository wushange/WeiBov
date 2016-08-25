package com.wsg.lovehome.ui.messagelogin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wsg.lovehome.MainComponent;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.widget.AppTitle;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class MessageFragment extends BaseFragmentV4 {
    @BindView(R.id.apptitle)
    AppTitle appTitle;

    @BindView(R.id.easyrecyclerview)
    EasyRecyclerView easyRecyclerView;
    @Inject
    MessageAdapter adapter;
    @Override
    public void initInjector() {
        getComponent(MainComponent.class).inject(this);

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_message_login_view;
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
                .setCenterTitleColor(R.color.black_deep)
                .setLeftText(R.string.find_group_text)
                .setLeftTextColor(R.color.black_deep)
                .setRightImageRes(R.drawable.navigationbar_icon_newchat_selete)
                .setRightImageClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
        ;
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerView.setAdapter(adapter);
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View headView = LayoutInflater.from(getContext()).inflate(R.layout.message_login_head_view,null);
                return headView;
            }

            @Override
            public void onBindView(View headerView) {

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
