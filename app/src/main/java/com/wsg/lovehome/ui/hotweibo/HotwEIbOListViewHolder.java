package com.wsg.lovehome.ui.hotweibo;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wsg.lovehome.R;
import com.wsg.lovehome.bean.WeiBoResult;
import com.wsg.lovehome.ui.imagepreview.ImagePreviewActivity;
import com.wsg.lovehome.util.Html2Text;
import com.wsg.lovehome.util.TimeLineUtility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.finalteam.toolsfinal.DateUtils;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22.
 */
public class HotWeiBoListViewHolder extends BaseViewHolder<WeiBoResult.StatusesBean> {


    private TextView userName;
    private TextView context;
    private NineGridImageView nineGridImageView;
    private CircleImageView userAvator;
    private TextView shareCount;
    private TextView commentCount;
    private TextView likeCount;
    private TextView fromSource;
    private TextView creatTime;

    public HotWeiBoListViewHolder(ViewGroup parent) {
        super(parent, R.layout.weibo_item_view);
        userName = $(R.id.item_tv_username);
        context = $(R.id.item_tv_content);
        creatTime = $(R.id.item_tv_time);
        nineGridImageView = $(R.id.nine_grid_view);
        userAvator = $(R.id.item_img_avator);
        shareCount = $(R.id.item_tv_share_count);
        commentCount = $(R.id.item_tv_comments_count);
        likeCount = $(R.id.item_tv_like_count);
        fromSource = $(R.id.item_tv_fromtype);
    }

    @Override
    public void setData(final WeiBoResult.StatusesBean weibo) {
        Glide.with(super.getContext()).load(weibo.getUser().getAvatar_hd()).asBitmap().into(userAvator);
        userName.setText(weibo.getUser().getName());
        context.setText(TimeLineUtility.convertNormalStringToSpannableString(weibo.getText(), TimeLineUtility.TimeLineStatus.FEED));
        creatTime.setText(DateUtils.getTimeInterval(new Date(weibo.getCreated_at())));
        nineGridImageView.setAdapter(mAdapter);
        nineGridImageView.setSingleImgSize(LinearLayout.LayoutParams.WRAP_CONTENT);
        nineGridImageView.setImagesData(weibo.getPic_urls());

        fromSource.setText(Html2Text.Html2Text(weibo.getSource()));
        shareCount.setText("" + weibo.getReposts_count());
        commentCount.setText("" + weibo.getComments_count());
        likeCount.setText("" + weibo.getAttitudes_count());
    }

    private NineGridImageViewAdapter<WeiBoResult.StatusesBean.PicUrlsBean> mAdapter = new NineGridImageViewAdapter<WeiBoResult.StatusesBean.PicUrlsBean>() {
        @Override
        protected void onDisplayImage(Context context, ImageView imageView, WeiBoResult.StatusesBean.PicUrlsBean photo) {

            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) imageView;
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(photo.getThumbnail_pic().replace("thumbnail", "bmiddle")))
                    .setProgressiveRenderingEnabled(true)
                    .build();
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            controller.setImageRequest(request);
            controller.setOldController(simpleDraweeView.getController());
            controller.setAutoPlayAnimations(false);
            simpleDraweeView.setController(controller.build());
        }

        @Override
        protected ImageView generateImageView(Context context) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            return simpleDraweeView;
        }

        @Override
        protected void onItemImageClick(Context context, int index, List<WeiBoResult.StatusesBean.PicUrlsBean> photoList) {
            ArrayList<String> urls = new ArrayList<String>();
            for (WeiBoResult.StatusesBean.PicUrlsBean bean : photoList) {
                urls.add(bean.getThumbnail_pic().replace("thumbnail", "large"));
            }
            ImagePreviewActivity.startActivity(context, urls.get(index), urls);
        }
    };
}
