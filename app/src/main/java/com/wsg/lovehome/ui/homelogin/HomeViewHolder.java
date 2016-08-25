package com.wsg.lovehome.ui.homelogin;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.wsg.lovehome.R;
import com.wsg.lovehome.bean.HomeWeiBo;

import java.util.Date;

import cn.finalteam.toolsfinal.DateUtils;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeViewHolder extends BaseViewHolder<HomeWeiBo.StatusesBean> {
    private TextView userName;
    private TextView context;
    private TextView creatTime;

    public HomeViewHolder(ViewGroup parent) {
        super(parent, R.layout.weibo_item_view);
        userName = $(R.id.item_tv_username);
        context = $(R.id.item_tv_content);
        creatTime = $(R.id.item_tv_time);
    }

    @Override
    public void setData(final HomeWeiBo.StatusesBean weibo) {
        userName.setText(weibo.getUser().getName());
        context.setText(weibo.getText());
        Logger.e("未转化==" + weibo.getCreated_at()+"--\n--时间化=="+ new Date(weibo.getCreated_at()).toString() +"---\n--转化后=="+ DateUtils.format(new Date(weibo.getCreated_at())) );
        creatTime.setText(DateUtils.getTimeInterval(new Date(weibo.getCreated_at())));
    }
}
