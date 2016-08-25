package com.wsg.lovehome.ui.homelogin;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wsg.lovehome.bean.HomeWeiBo;

import javax.inject.Inject;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeAdapter  extends RecyclerArrayAdapter<HomeWeiBo.StatusesBean> {

    @Inject public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(parent);
    }
}
