package com.wsg.lovehome.bean;

import io.realm.RealmObject;

public class TestAnnotationsBean extends RealmObject {
    private String client_mblogid;

    public String getClient_mblogid() {
        return client_mblogid;
    }

    public void setClient_mblogid(String client_mblogid) {
        this.client_mblogid = client_mblogid;
    }
}