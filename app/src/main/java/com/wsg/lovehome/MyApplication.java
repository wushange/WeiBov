package com.wsg.lovehome;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.wsg.lovehome.injector.component.ApplicationComponent;
import com.wsg.lovehome.injector.component.DaggerApplicationComponent;
import com.wsg.lovehome.injector.module.ApplicationModule;
import com.wsg.lovehome.util.Contanst;
import com.wsg.lovehome.util.GlideImageLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by wushange on 2016/06/01.
 */
public class MyApplication extends android.app.Application {
    private static MyApplication INSTANCE;
    private ApplicationComponent mApplicationComponent;
    /**
     * 对外提供整个应用生命周期的Context
     **/
    private static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        context = this;
        initGallyFinal();
        initFrescoConfig();
        Logger.init("WUSHANGE").logLevel(LogLevel.FULL);
//        LeakCanary.install(this);

    }


    private void initComponent() {
        mApplicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static MyApplication getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new MyApplication();
        }
        return INSTANCE;
    }


    /**
     * 对外提供Application Context
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }


    void initGallyFinal() {
        // 建议在application中配置
        // 设置主题 //设置主题
        ThemeConfig theme = new ThemeConfig.Builder().setTitleBarBgColor(getResources().getColor(R.color.appThemeColor)).build();
        // 配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true).setEnableEdit(false)
                .setEnableCrop(false).setEnableRotate(false)
                .setCropSquare(false).setEnablePreview(true).build();
        CoreConfig coreConfig = new CoreConfig.Builder(this,
                new GlideImageLoader(), theme).setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }


    private static final int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory();
    public static final int MAX_DISK_CACHE_SIZE = 50 * ByteConstants.MB;
    public static final int MAX_MEMORY_CACHE_SIZE = MAX_HEAP_SIZE / 8;

    private void initFrescoConfig() {
        File cacheFile = new File(Contanst.Cache_Root_Dir, Contanst.CACHE_DIR);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache).connectTimeout(15, TimeUnit.SECONDS)
                .build();
        final MemoryCacheParams bitmapCacheParams =
                new MemoryCacheParams(MAX_MEMORY_CACHE_SIZE, // Max total size of elements in the cache
                        Integer.MAX_VALUE,                     // Max entries in the cache
                        MAX_MEMORY_CACHE_SIZE, // Max total size of elements in eviction queue
                        Integer.MAX_VALUE,                     // Max length of eviction queue
                        Integer.MAX_VALUE);
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory.newBuilder(this, okHttpClient)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() {
                    public MemoryCacheParams get() {
                        return bitmapCacheParams;
                    }
                })
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(this).setMaxCacheSize(MAX_DISK_CACHE_SIZE).build())
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);
    }


}
