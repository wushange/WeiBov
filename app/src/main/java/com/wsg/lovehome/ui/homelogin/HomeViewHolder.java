package com.wsg.lovehome.ui.homelogin;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wsg.lovehome.R;
import com.wsg.lovehome.bean.HomeWeiBo;

import java.util.Date;
import java.util.List;

import cn.finalteam.toolsfinal.DateUtils;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeViewHolder extends BaseViewHolder<HomeWeiBo.StatusesBean> {
    private TextView userName;
    private TextView context;
    private TextView creatTime;
    private NineGridImageView nineGridImageView;

    public HomeViewHolder(ViewGroup parent) {
        super(parent, R.layout.weibo_item_view);
        userName = $(R.id.item_tv_username);
        context = $(R.id.item_tv_content);
        creatTime = $(R.id.item_tv_time);
        nineGridImageView = $(R.id.nine_grid_view);
    }

    @Override
    public void setData(final HomeWeiBo.StatusesBean weibo) {
        userName.setText(weibo.getUser().getName());
        context.setText(weibo.getText());
        creatTime.setText(DateUtils.getTimeInterval(new Date(weibo.getCreated_at())));
        nineGridImageView.setAdapter(mAdapter);
        nineGridImageView.setImagesData(weibo.getPic_urls());
    }

    private NineGridImageViewAdapter<HomeWeiBo.StatusesBean.PicUrlsBean> mAdapter = new NineGridImageViewAdapter<HomeWeiBo.StatusesBean.PicUrlsBean>() {
        @Override
        protected void onDisplayImage(Context context, ImageView imageView, HomeWeiBo.StatusesBean.PicUrlsBean photo) {

            Glide.with(context).load(photo.getThumbnail_pic()).into(imageView);

        }

        @Override
        protected ImageView generateImageView(Context context) {
            return super.generateImageView(context);
        }

        @Override
        protected void onItemImageClick(Context context, int index, List<HomeWeiBo.StatusesBean.PicUrlsBean> photoList) {
        }
    };
}
