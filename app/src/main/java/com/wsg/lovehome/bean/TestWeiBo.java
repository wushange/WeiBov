package com.wsg.lovehome.bean;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by wushange on 2016/8/25.
 */
public class TestWeiBo extends RealmObject {
    private boolean hasvisible;
    private long previous_cursor;
    private long next_cursor;
    private int total_number;
    private int interval;
    private int uve_blank;
    private long since_id;
    private long max_id;
    private int has_unread;
    private RealmList<TestStatusesBean> statuses;
    private RealmList<RealmString> advertises;
    private RealmList<RealmString> ad;

    public boolean isHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(boolean hasvisible) {
        this.hasvisible = hasvisible;
    }

    public long getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(long previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public long getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(long next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getUve_blank() {
        return uve_blank;
    }

    public void setUve_blank(int uve_blank) {
        this.uve_blank = uve_blank;
    }

    public long getSince_id() {
        return since_id;
    }

    public void setSince_id(long since_id) {
        this.since_id = since_id;
    }

    public long getMax_id() {
        return max_id;
    }

    public void setMax_id(long max_id) {
        this.max_id = max_id;
    }

    public int getHas_unread() {
        return has_unread;
    }

    public void setHas_unread(int has_unread) {
        this.has_unread = has_unread;
    }

    public List<TestStatusesBean> getStatuses() {
        return statuses;
    }

    public void setStatuses(RealmList<TestStatusesBean> statuses) {
        this.statuses = statuses;
    }

    public RealmList<RealmString> getAdvertises() {
        return advertises;
    }

    public void setAdvertises(RealmList<RealmString> advertises) {
        this.advertises = advertises;
    }

    public RealmList<RealmString> getAd() {
        return ad;
    }

    public void setAd(RealmList<RealmString> ad) {
        this.ad = ad;
    }
}
