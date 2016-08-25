package com.wsg.lovehome.ui.messagelogin;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

/**
 * Created by wushange on 2016/8/25.
 */
public class MessageAdapter extends RecyclerArrayAdapter<String> {

    @Inject
    public MessageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(parent);
    }
}
