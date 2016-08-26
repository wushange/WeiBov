package com.wsg.lovehome.ui.hotweibo;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wsg.lovehome.R;
import com.wsg.lovehome.bean.WeiBoResult;

import java.util.List;


/**
 * Created by Mr.Jude on 2015/2/22.
 */
public class HotWeiBoListViewHolder extends BaseViewHolder<WeiBoResult.StatusesBean> {


    private TextView userName;
    private TextView context;
    private NineGridImageView nineGridImageView;

    public HotWeiBoListViewHolder(ViewGroup parent) {
        super(parent, R.layout.weibo_item_view);
        userName = $(R.id.item_tv_username);
        context = $(R.id.item_tv_content);
        nineGridImageView = $(R.id.nine_grid_view);
    }

    @Override
    public void setData(final WeiBoResult.StatusesBean weibo) {
        userName.setText(weibo.getUser().getName());
        context.setText(weibo.getText());
        nineGridImageView.setAdapter(mAdapter);
        nineGridImageView.setImagesData(weibo.getPic_urls());
    }

    private NineGridImageViewAdapter<WeiBoResult.StatusesBean.PicUrlsBean> mAdapter = new NineGridImageViewAdapter<WeiBoResult.StatusesBean.PicUrlsBean>() {
        @Override
        protected void onDisplayImage(Context context, ImageView imageView, WeiBoResult.StatusesBean.PicUrlsBean photo) {

            Glide.with(context).load(photo.getThumbnail_pic()).into(imageView);

        }

        @Override
        protected ImageView generateImageView(Context context) {
            return super.generateImageView(context);
        }

        @Override
        protected void onItemImageClick(Context context, int index, List<WeiBoResult.StatusesBean.PicUrlsBean> photoList) {
        }
    };
}
