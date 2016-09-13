package com.wsg.lovehome.bean;

import io.realm.RealmObject;

public class TestPicUrlsBean extends RealmObject {
    private String thumbnail_pic;

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }
}