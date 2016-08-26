package com.wsg.lovehome.ui.imagepreview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragment;
import com.wsg.lovehome.photodrawee.OnViewTapListener;
import com.wsg.lovehome.photodrawee.PhotoDraweeView;
import com.wsg.lovehome.util.ResourceUtils;
import com.wsg.lovehome.widget.ImageLoadProgressBar;

import butterknife.BindView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

/**
 * Created by sll on 2016/3/10.
 */
public class ImageFragment extends BaseFragment {


    @BindView(R.id.image)
    PhotoDraweeView image;
    @BindView(R.id.progress)
    SmoothProgressBar progress;
    @BindView(R.id.rlProgress)
    RelativeLayout rlProgress;
    @BindView(R.id.tvInfo)
    TextView tvInfo;
    private String url = "";

    public static ImageFragment newInstance(String url) {
        ImageFragment mFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        mFragment.setArguments(bundle);
        return mFragment;
    }


    @Override
    public int bindLayout() {
        return R.layout.preview_item_layout;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {
        url = parms.getString("url");

    }

    @Override
    public void initView(View view) {
        progress.setIndeterminate(true);
        image.setOnViewTapListener(new OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                getActivity().finish();
            }
        });

    }

    @Override
    public void doBusiness(Context mContext) {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setProgressiveRenderingEnabled(true)
                .build();

        GenericDraweeHierarchy hierarchy =
                new GenericDraweeHierarchyBuilder(getResources()).setProgressBarImage(
                        new ImageLoadProgressBar(new ImageLoadProgressBar.OnLevelChangeListener() {
                            @Override
                            public void onChange(int level) {
                                if (level > 100 && progress.getVisibility() == View.VISIBLE) {
                                    progress.setVisibility(View.GONE);
                                }
                            }
                        }, ResourceUtils.getThemeColor(getActivity()))).build();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);

        PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
        controller.setControllerListener(listener);
        controller.setImageRequest(request);
        controller.setOldController(image.getController());
        controller.setAutoPlayAnimations(true);
        image.setHierarchy(hierarchy);
        image.setController(controller.build());

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    private BaseControllerListener<ImageInfo> listener = new BaseControllerListener<ImageInfo>() {

        @Override
        public void onFailure(String id, Throwable throwable) {
            super.onFailure(id, throwable);
            System.out.println("onFailure:" + throwable.getMessage());
            progress.setVisibility(View.GONE);
            tvInfo.setVisibility(View.VISIBLE);
            tvInfo.setText("图片加载失败");
        }

        @Override
        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);
            System.out.println("onFinalImageSet");
            if (imageInfo == null) {
                return;
            }
            image.update(imageInfo.getWidth(), imageInfo.getHeight());
            progress.setVisibility(View.GONE);
        }

        @Override
        public void onSubmit(String id, Object callerContext) {
            super.onSubmit(id, callerContext);
            System.out.println("onSubmit");
            progress.setVisibility(View.VISIBLE);
            tvInfo.setVisibility(View.GONE);
        }
    };

}
