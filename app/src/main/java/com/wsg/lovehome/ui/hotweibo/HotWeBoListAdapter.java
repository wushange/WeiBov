package com.wsg.lovehome.ui.hotweibo;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wsg.lovehome.bean.WeiBoResult;

import javax.inject.Inject;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class HotWeBoListAdapter extends RecyclerArrayAdapter<WeiBoResult.StatusesBean> {

    @Inject
    public HotWeBoListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotWeiBoListViewHolder(parent);
    }
}
