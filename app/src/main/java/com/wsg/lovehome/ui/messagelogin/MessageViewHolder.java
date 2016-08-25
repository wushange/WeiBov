package com.wsg.lovehome.ui.messagelogin;

import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wsg.lovehome.R;

/**
 * Created by wushange on 2016/8/25.
 */
public class MessageViewHolder extends BaseViewHolder<String> {
    public MessageViewHolder(ViewGroup itemView) {
        super(itemView, R.layout.item_message_view);

    }

    @Override
    public void setData(String data) {
        super.setData(data);
    }
}
