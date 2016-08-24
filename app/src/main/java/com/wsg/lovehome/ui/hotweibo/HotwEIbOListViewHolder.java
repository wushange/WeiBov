package com.wsg.lovehome.ui.hotweibo;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wsg.lovehome.R;
import com.wsg.lovehome.bean.WeiBoResult;


/**
 * Created by Mr.Jude on 2015/2/22.
 */
public class HotWeiBoListViewHolder extends BaseViewHolder<WeiBoResult.StatusesBean> {


    private TextView userName;
    private TextView context;

    public HotWeiBoListViewHolder(ViewGroup parent ) {
        super(parent, R.layout.weibo_item_view);
        userName = $(R.id.item_tv_username);
        context = $(R.id.item_tv_content);
    }

    @Override
    public void setData(final WeiBoResult.StatusesBean weibo) {
        userName.setText(weibo.getUser().getName());
        context.setText(weibo.getText());
    }
}
