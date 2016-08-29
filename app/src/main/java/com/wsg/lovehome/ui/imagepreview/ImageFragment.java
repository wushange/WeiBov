package com.wsg.lovehome.ui.imagepreview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
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
import com.orhanobut.logger.Logger;
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
    @BindView(R.id.webview)
    WebView webView;
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
        webView.addJavascriptInterface(new PictureJavaScriptInterface(), "picturejs");

    }

    final class PictureJavaScriptInterface {

        public PictureJavaScriptInterface() {

        }

        @JavascriptInterface
        public void onClick() {
            getActivity().finish();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("url", url);
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
            if (imageInfo.getWidth() > 1024 || imageInfo.getHeight() > 1024) {
                Logger.e("这个是长图");
                readLargePicture(webView);
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

    @SuppressLint("SetJavaScriptEnabled")
    private void readLargePicture(final WebView large) {
        image.setVisibility(View.INVISIBLE);
        large.getSettings().setJavaScriptEnabled(true);
        large.getSettings().setUseWideViewPort(true);
        large.getSettings().setLoadWithOverviewMode(true);
        large.getSettings().setBuiltInZoomControls(true);
        large.getSettings().setDisplayZoomControls(false);

        large.setVerticalScrollBarEnabled(false);
        large.setHorizontalScrollBarEnabled(false);

//        String str1 = "file://" + file.getAbsolutePath().replace("/mnt/sdcard/", "/sdcard/");
        String str2 = "<html>\n<head>\n     <style>\n          html,body{background:#3b3b3b;margin:0;padding:0;}          *{-webkit-tap-highlight-color:rgba(0, 0, 0, 0);}\n     </style>\n     <script type=\"text/javascript\">\n     var imgUrl = \""
                + url
                + "\";"
                + "     var objImage = new Image();\n"
                + "     var realWidth = 0;\n"
                + "     var realHeight = 0;\n"
                + "\n"
                + "     function onLoad() {\n"
                + "          objImage.onload = function() {\n"
                + "               realWidth = objImage.width;\n"
                + "               realHeight = objImage.height;\n"
                + "\n"
                + "               document.gagImg.src = imgUrl;\n"
                + "               onResize();\n"
                + "          }\n"
                + "          objImage.src = imgUrl;\n"
                + "     }\n"
                + "\n"
                + "     function imgOnClick() {\n"
                + "			window.picturejs.onClick();"
                + "     }\n"
                + "     function onResize() {\n"
                + "          var scale = 1;\n"
                + "          var newWidth = document.gagImg.width;\n"
                + "          if (realWidth > newWidth) {\n"
                + "               scale = realWidth / newWidth;\n"
                + "          } else {\n"
                + "               scale = newWidth / realWidth;\n"
                + "          }\n"
                + "\n"
                + "          hiddenHeight = Math.ceil(30 * scale);\n"
                + "          document.getElementById('hiddenBar').style.height = hiddenHeight + \"px\";\n"
                + "          document.getElementById('hiddenBar').style.marginTop = -hiddenHeight + \"px\";\n"
                + "     }\n"
                + "     </script>\n"
                + "</head>\n"
                + "<body onload=\"onLoad()\" onresize=\"onResize()\" onclick=\"Android.toggleOverlayDisplay();\">\n"
                + "     <table style=\"width: 100%;height:100%;\">\n"
                + "          <tr style=\"width: 100%;\">\n"
                + "               <td valign=\"middle\" align=\"center\" style=\"width: 100%;\">\n"
                + "                    <div style=\"display:block\">\n"
                + "                         <img name=\"gagImg\" src=\"\" width=\"100%\" style=\"\" onclick=\"imgOnClick()\" />\n"
                + "                    </div>\n"
                + "                    <div id=\"hiddenBar\" style=\"position:absolute; width: 0%; background: #3b3b3b;\"></div>\n"
                + "               </td>\n" + "          </tr>\n" + "     </table>\n" + "</body>\n" + "</html>";
        large.loadDataWithBaseURL("file:///android_asset/", str2, "text/html", "utf-8", null);

        large.setTag(new Object());
        large.postDelayed(new Runnable() {

            @Override
            public void run() {
                large.setVisibility(View.VISIBLE);
            }
        }, 500);
    }

}
