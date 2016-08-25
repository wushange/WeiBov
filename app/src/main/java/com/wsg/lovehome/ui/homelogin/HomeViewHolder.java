package com.wsg.lovehome.ui.homelogin;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wsg.lovehome.R;
import com.wsg.lovehome.bean.HomeWeiBo;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeViewHolder extends BaseViewHolder<HomeWeiBo.StatusesBean> {
    private TextView userName;
    private TextView context;

    public HomeViewHolder(ViewGroup parent) {
        super(parent, R.layout.weibo_item_view);
        userName = $(R.id.item_tv_username);
        context = $(R.id.item_tv_content);
    }

    @Override
    public void setData(final HomeWeiBo.StatusesBean weibo) {
        userName.setText(weibo.getUser().getName());
        context.setText(weibo.getText());
    }
}
