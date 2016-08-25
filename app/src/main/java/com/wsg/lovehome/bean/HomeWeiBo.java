package com.wsg.lovehome.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeWeiBo {

    /**
     * statuses : [{"created_at":"Thu Aug 25 11:36:10 +0800 2016","id":4012324505923021,"mid":"4012324505923021","idstr":"4012324505923021","text":"现场，中国移动集团公司副总裁李慧镝宣布，中移动力争年内销售超过3000万台小米手机。转发点赞，抽送一台新品手机。[good]","textLength":114,"source_allowclick":1,"source_type":2,"source":"<a href=\"http://weibo.com/\" rel=\"nofollow\">小米手机5<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[{"thumbnail_pic":"http://ww3.sinaimg.cn/thumbnail/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg"}],"thumbnail_pic":"http://ww3.sinaimg.cn/thumbnail/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg","bmiddle_pic":"http://ww3.sinaimg.cn/bmiddle/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg","original_pic":"http://ww3.sinaimg.cn/large/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg","geo":null,"user":{"id":1771925961,"idstr":"1771925961","class":1,"screen_name":"小米公司","name":"小米公司","province":"11","city":"8","location":"北京 海淀区","description":"让每个人都能享受科技的乐趣。","url":"http://xiaomi.com","profile_image_url":"http://tva4.sinaimg.cn/crop.0.0.996.996.50/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg","cover_image":"http://ww4.sinaimg.cn/crop.0.0.920.300/699d71c9jw1f6fh54vju8j20pk08ct9s.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/699d71c9jw1f6fhy1fq5wj20u00u0ag1.jpg","profile_url":"xiaomikeji","domain":"xiaomikeji","weihao":"","gender":"m","followers_count":11205082,"friends_count":840,"pagefriends_count":31,"statuses_count":13794,"favourites_count":1420,"created_at":"Sat Jul 10 15:28:03 +0800 2010","following":true,"allow_all_act_msg":true,"geo_enabled":false,"verified":true,"verified_type":2,"remark":"","ptype":0,"allow_all_comment":true,"avatar_large":"http://tva4.sinaimg.cn/crop.0.0.996.996.180/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg","avatar_hd":"http://tva4.sinaimg.cn/crop.0.0.996.996.1024/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg","verified_reason":"小米科技有限责任公司","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"小米科技有限责任公司","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":685,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":4,"block_word":0,"block_app":1,"credit_score":80,"user_ability":4,"urank":36},"annotations":[{"client_mblogid":"9f0ae6da-1c82-4a04-a2dd-088043c63daa"},{"mapi_request":true}],"picStatus":"0:1","reposts_count":1,"comments_count":0,"attitudes_count":5,"isLongText":false,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":4294967300,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"rid":"0_0_1_2789474236757439440","userType":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":0}]
     * advertises : []
     * ad : []
     * hasvisible : false
     * previous_cursor : 0
     * next_cursor : 4012324501724249
     * total_number : 150
     * interval : 2000
     * uve_blank : -1
     * since_id : 4012324505923021
     * max_id : 4012324501724249
     * has_unread : 0
     */

    private boolean hasvisible;
    private long previous_cursor;
    private long next_cursor;
    private int total_number;
    private int interval;
    private int uve_blank;
    private long since_id;
    private long max_id;
    private int has_unread;
    /**
     * created_at : Thu Aug 25 11:36:10 +0800 2016
     * id : 4012324505923021
     * mid : 4012324505923021
     * idstr : 4012324505923021
     * text : 现场，中国移动集团公司副总裁李慧镝宣布，中移动力争年内销售超过3000万台小米手机。转发点赞，抽送一台新品手机。[good]
     * textLength : 114
     * source_allowclick : 1
     * source_type : 2
     * source : <a href="http://weibo.com/" rel="nofollow">小米手机5</a>
     * favorited : false
     * truncated : false
     * in_reply_to_status_id :
     * in_reply_to_user_id :
     * in_reply_to_screen_name :
     * pic_urls : [{"thumbnail_pic":"http://ww3.sinaimg.cn/thumbnail/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg"}]
     * thumbnail_pic : http://ww3.sinaimg.cn/thumbnail/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg
     * bmiddle_pic : http://ww3.sinaimg.cn/bmiddle/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg
     * original_pic : http://ww3.sinaimg.cn/large/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg
     * geo : null
     * user : {"id":1771925961,"idstr":"1771925961","class":1,"screen_name":"小米公司","name":"小米公司","province":"11","city":"8","location":"北京 海淀区","description":"让每个人都能享受科技的乐趣。","url":"http://xiaomi.com","profile_image_url":"http://tva4.sinaimg.cn/crop.0.0.996.996.50/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg","cover_image":"http://ww4.sinaimg.cn/crop.0.0.920.300/699d71c9jw1f6fh54vju8j20pk08ct9s.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/699d71c9jw1f6fhy1fq5wj20u00u0ag1.jpg","profile_url":"xiaomikeji","domain":"xiaomikeji","weihao":"","gender":"m","followers_count":11205082,"friends_count":840,"pagefriends_count":31,"statuses_count":13794,"favourites_count":1420,"created_at":"Sat Jul 10 15:28:03 +0800 2010","following":true,"allow_all_act_msg":true,"geo_enabled":false,"verified":true,"verified_type":2,"remark":"","ptype":0,"allow_all_comment":true,"avatar_large":"http://tva4.sinaimg.cn/crop.0.0.996.996.180/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg","avatar_hd":"http://tva4.sinaimg.cn/crop.0.0.996.996.1024/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg","verified_reason":"小米科技有限责任公司","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"小米科技有限责任公司","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":685,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":4,"block_word":0,"block_app":1,"credit_score":80,"user_ability":4,"urank":36}
     * annotations : [{"client_mblogid":"9f0ae6da-1c82-4a04-a2dd-088043c63daa"},{"mapi_request":true}]
     * picStatus : 0:1
     * reposts_count : 1
     * comments_count : 0
     * attitudes_count : 5
     * isLongText : false
     * mlevel : 0
     * visible : {"type":0,"list_id":0}
     * biz_feature : 4294967300
     * hasActionTypeCard : 0
     * darwin_tags : []
     * hot_weibo_tags : []
     * text_tag_tips : []
     * rid : 0_0_1_2789474236757439440
     * userType : 0
     * positive_recom_flag : 0
     * gif_ids :
     * is_show_bulletin : 0
     */

    private List<StatusesBean> statuses;
    private List<Object> advertises;
    private List<Object> ad;

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

    public List<StatusesBean> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusesBean> statuses) {
        this.statuses = statuses;
    }

    public List<Object> getAdvertises() {
        return advertises;
    }

    public void setAdvertises(List<Object> advertises) {
        this.advertises = advertises;
    }

    public List<Object> getAd() {
        return ad;
    }

    public void setAd(List<Object> ad) {
        this.ad = ad;
    }

    public static class StatusesBean {
        private String created_at;
        private long id;
        private String mid;
        private String idstr;
        private String text;
        private int textLength;
        private int source_allowclick;
        private int source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private String thumbnail_pic;
        private String bmiddle_pic;
        private String original_pic;
        private Object geo;
        /**
         * id : 1771925961
         * idstr : 1771925961
         * class : 1
         * screen_name : 小米公司
         * name : 小米公司
         * province : 11
         * city : 8
         * location : 北京 海淀区
         * description : 让每个人都能享受科技的乐趣。
         * url : http://xiaomi.com
         * profile_image_url : http://tva4.sinaimg.cn/crop.0.0.996.996.50/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg
         * cover_image : http://ww4.sinaimg.cn/crop.0.0.920.300/699d71c9jw1f6fh54vju8j20pk08ct9s.jpg
         * cover_image_phone : http://ww1.sinaimg.cn/crop.0.0.640.640.640/699d71c9jw1f6fhy1fq5wj20u00u0ag1.jpg
         * profile_url : xiaomikeji
         * domain : xiaomikeji
         * weihao :
         * gender : m
         * followers_count : 11205082
         * friends_count : 840
         * pagefriends_count : 31
         * statuses_count : 13794
         * favourites_count : 1420
         * created_at : Sat Jul 10 15:28:03 +0800 2010
         * following : true
         * allow_all_act_msg : true
         * geo_enabled : false
         * verified : true
         * verified_type : 2
         * remark :
         * ptype : 0
         * allow_all_comment : true
         * avatar_large : http://tva4.sinaimg.cn/crop.0.0.996.996.180/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg
         * avatar_hd : http://tva4.sinaimg.cn/crop.0.0.996.996.1024/699d71c9jw8f2paozoavmj20ro0ro3yw.jpg
         * verified_reason : 小米科技有限责任公司
         * verified_trade :
         * verified_reason_url :
         * verified_source :
         * verified_source_url :
         * verified_state : 0
         * verified_level : 3
         * verified_type_ext : 0
         * verified_reason_modified : 小米科技有限责任公司
         * verified_contact_name :
         * verified_contact_email :
         * verified_contact_mobile :
         * follow_me : false
         * online_status : 0
         * bi_followers_count : 685
         * lang : zh-cn
         * star : 0
         * mbtype : 12
         * mbrank : 4
         * block_word : 0
         * block_app : 1
         * credit_score : 80
         * user_ability : 4
         * urank : 36
         */

        private UserBean user;
        private String picStatus;
        private int reposts_count;
        private int comments_count;
        private int attitudes_count;
        private boolean isLongText;
        private int mlevel;
        /**
         * type : 0
         * list_id : 0
         */

        private VisibleBean visible;
        private long biz_feature;
        private int hasActionTypeCard;
        private String rid;
        private int userType;
        private int positive_recom_flag;
        private String gif_ids;
        private int is_show_bulletin;
        /**
         * thumbnail_pic : http://ww3.sinaimg.cn/thumbnail/699d71c9gw1f75u7r7d9nj24mo3344qw.jpg
         */

        private List<PicUrlsBean> pic_urls;
        /**
         * client_mblogid : 9f0ae6da-1c82-4a04-a2dd-088043c63daa
         */

        private List<AnnotationsBean> annotations;
        private List<Object> darwin_tags;
        private List<Object> hot_weibo_tags;
        private List<Object> text_tag_tips;

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getIdstr() {
            return idstr;
        }

        public void setIdstr(String idstr) {
            this.idstr = idstr;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getTextLength() {
            return textLength;
        }

        public void setTextLength(int textLength) {
            this.textLength = textLength;
        }

        public int getSource_allowclick() {
            return source_allowclick;
        }

        public void setSource_allowclick(int source_allowclick) {
            this.source_allowclick = source_allowclick;
        }

        public int getSource_type() {
            return source_type;
        }

        public void setSource_type(int source_type) {
            this.source_type = source_type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public void setIn_reply_to_status_id(String in_reply_to_status_id) {
            this.in_reply_to_status_id = in_reply_to_status_id;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id(String in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public String getThumbnail_pic() {
            return thumbnail_pic;
        }

        public void setThumbnail_pic(String thumbnail_pic) {
            this.thumbnail_pic = thumbnail_pic;
        }

        public String getBmiddle_pic() {
            return bmiddle_pic;
        }

        public void setBmiddle_pic(String bmiddle_pic) {
            this.bmiddle_pic = bmiddle_pic;
        }

        public String getOriginal_pic() {
            return original_pic;
        }

        public void setOriginal_pic(String original_pic) {
            this.original_pic = original_pic;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getPicStatus() {
            return picStatus;
        }

        public void setPicStatus(String picStatus) {
            this.picStatus = picStatus;
        }

        public int getReposts_count() {
            return reposts_count;
        }

        public void setReposts_count(int reposts_count) {
            this.reposts_count = reposts_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public int getAttitudes_count() {
            return attitudes_count;
        }

        public void setAttitudes_count(int attitudes_count) {
            this.attitudes_count = attitudes_count;
        }

        public boolean isIsLongText() {
            return isLongText;
        }

        public void setIsLongText(boolean isLongText) {
            this.isLongText = isLongText;
        }

        public int getMlevel() {
            return mlevel;
        }

        public void setMlevel(int mlevel) {
            this.mlevel = mlevel;
        }

        public VisibleBean getVisible() {
            return visible;
        }

        public void setVisible(VisibleBean visible) {
            this.visible = visible;
        }

        public long getBiz_feature() {
            return biz_feature;
        }

        public void setBiz_feature(long biz_feature) {
            this.biz_feature = biz_feature;
        }

        public int getHasActionTypeCard() {
            return hasActionTypeCard;
        }

        public void setHasActionTypeCard(int hasActionTypeCard) {
            this.hasActionTypeCard = hasActionTypeCard;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getPositive_recom_flag() {
            return positive_recom_flag;
        }

        public void setPositive_recom_flag(int positive_recom_flag) {
            this.positive_recom_flag = positive_recom_flag;
        }

        public String getGif_ids() {
            return gif_ids;
        }

        public void setGif_ids(String gif_ids) {
            this.gif_ids = gif_ids;
        }

        public int getIs_show_bulletin() {
            return is_show_bulletin;
        }

        public void setIs_show_bulletin(int is_show_bulletin) {
            this.is_show_bulletin = is_show_bulletin;
        }

        public List<PicUrlsBean> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<PicUrlsBean> pic_urls) {
            this.pic_urls = pic_urls;
        }

        public List<AnnotationsBean> getAnnotations() {
            return annotations;
        }

        public void setAnnotations(List<AnnotationsBean> annotations) {
            this.annotations = annotations;
        }

        public List<Object> getDarwin_tags() {
            return darwin_tags;
        }

        public void setDarwin_tags(List<Object> darwin_tags) {
            this.darwin_tags = darwin_tags;
        }

        public List<Object> getHot_weibo_tags() {
            return hot_weibo_tags;
        }

        public void setHot_weibo_tags(List<Object> hot_weibo_tags) {
            this.hot_weibo_tags = hot_weibo_tags;
        }

        public List<Object> getText_tag_tips() {
            return text_tag_tips;
        }

        public void setText_tag_tips(List<Object> text_tag_tips) {
            this.text_tag_tips = text_tag_tips;
        }

        public static class UserBean {
            private long id;
            private String idstr;
            @JSONField(name = "class")
            private int classX;
            private String screen_name;
            private String name;
            private String province;
            private String city;
            private String location;
            private String description;
            private String url;
            private String profile_image_url;
            private String cover_image;
            private String cover_image_phone;
            private String profile_url;
            private String domain;
            private String weihao;
            private String gender;
            private int followers_count;
            private int friends_count;
            private int pagefriends_count;
            private int statuses_count;
            private int favourites_count;
            private String created_at;
            private boolean following;
            private boolean allow_all_act_msg;
            private boolean geo_enabled;
            private boolean verified;
            private int verified_type;
            private String remark;
            private int ptype;
            private boolean allow_all_comment;
            private String avatar_large;
            private String avatar_hd;
            private String verified_reason;
            private String verified_trade;
            private String verified_reason_url;
            private String verified_source;
            private String verified_source_url;
            private int verified_state;
            private int verified_level;
            private int verified_type_ext;
            private String verified_reason_modified;
            private String verified_contact_name;
            private String verified_contact_email;
            private String verified_contact_mobile;
            private boolean follow_me;
            private int online_status;
            private int bi_followers_count;
            private String lang;
            private int star;
            private int mbtype;
            private int mbrank;
            private int block_word;
            private int block_app;
            private int credit_score;
            private int user_ability;
            private int urank;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getIdstr() {
                return idstr;
            }

            public void setIdstr(String idstr) {
                this.idstr = idstr;
            }

            public int getClassX() {
                return classX;
            }

            public void setClassX(int classX) {
                this.classX = classX;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getProfile_image_url() {
                return profile_image_url;
            }

            public void setProfile_image_url(String profile_image_url) {
                this.profile_image_url = profile_image_url;
            }

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public String getCover_image_phone() {
                return cover_image_phone;
            }

            public void setCover_image_phone(String cover_image_phone) {
                this.cover_image_phone = cover_image_phone;
            }

            public String getProfile_url() {
                return profile_url;
            }

            public void setProfile_url(String profile_url) {
                this.profile_url = profile_url;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getWeihao() {
                return weihao;
            }

            public void setWeihao(String weihao) {
                this.weihao = weihao;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(int followers_count) {
                this.followers_count = followers_count;
            }

            public int getFriends_count() {
                return friends_count;
            }

            public void setFriends_count(int friends_count) {
                this.friends_count = friends_count;
            }

            public int getPagefriends_count() {
                return pagefriends_count;
            }

            public void setPagefriends_count(int pagefriends_count) {
                this.pagefriends_count = pagefriends_count;
            }

            public int getStatuses_count() {
                return statuses_count;
            }

            public void setStatuses_count(int statuses_count) {
                this.statuses_count = statuses_count;
            }

            public int getFavourites_count() {
                return favourites_count;
            }

            public void setFavourites_count(int favourites_count) {
                this.favourites_count = favourites_count;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public boolean isFollowing() {
                return following;
            }

            public void setFollowing(boolean following) {
                this.following = following;
            }

            public boolean isAllow_all_act_msg() {
                return allow_all_act_msg;
            }

            public void setAllow_all_act_msg(boolean allow_all_act_msg) {
                this.allow_all_act_msg = allow_all_act_msg;
            }

            public boolean isGeo_enabled() {
                return geo_enabled;
            }

            public void setGeo_enabled(boolean geo_enabled) {
                this.geo_enabled = geo_enabled;
            }

            public boolean isVerified() {
                return verified;
            }

            public void setVerified(boolean verified) {
                this.verified = verified;
            }

            public int getVerified_type() {
                return verified_type;
            }

            public void setVerified_type(int verified_type) {
                this.verified_type = verified_type;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getPtype() {
                return ptype;
            }

            public void setPtype(int ptype) {
                this.ptype = ptype;
            }

            public boolean isAllow_all_comment() {
                return allow_all_comment;
            }

            public void setAllow_all_comment(boolean allow_all_comment) {
                this.allow_all_comment = allow_all_comment;
            }

            public String getAvatar_large() {
                return avatar_large;
            }

            public void setAvatar_large(String avatar_large) {
                this.avatar_large = avatar_large;
            }

            public String getAvatar_hd() {
                return avatar_hd;
            }

            public void setAvatar_hd(String avatar_hd) {
                this.avatar_hd = avatar_hd;
            }

            public String getVerified_reason() {
                return verified_reason;
            }

            public void setVerified_reason(String verified_reason) {
                this.verified_reason = verified_reason;
            }

            public String getVerified_trade() {
                return verified_trade;
            }

            public void setVerified_trade(String verified_trade) {
                this.verified_trade = verified_trade;
            }

            public String getVerified_reason_url() {
                return verified_reason_url;
            }

            public void setVerified_reason_url(String verified_reason_url) {
                this.verified_reason_url = verified_reason_url;
            }

            public String getVerified_source() {
                return verified_source;
            }

            public void setVerified_source(String verified_source) {
                this.verified_source = verified_source;
            }

            public String getVerified_source_url() {
                return verified_source_url;
            }

            public void setVerified_source_url(String verified_source_url) {
                this.verified_source_url = verified_source_url;
            }

            public int getVerified_state() {
                return verified_state;
            }

            public void setVerified_state(int verified_state) {
                this.verified_state = verified_state;
            }

            public int getVerified_level() {
                return verified_level;
            }

            public void setVerified_level(int verified_level) {
                this.verified_level = verified_level;
            }

            public int getVerified_type_ext() {
                return verified_type_ext;
            }

            public void setVerified_type_ext(int verified_type_ext) {
                this.verified_type_ext = verified_type_ext;
            }

            public String getVerified_reason_modified() {
                return verified_reason_modified;
            }

            public void setVerified_reason_modified(String verified_reason_modified) {
                this.verified_reason_modified = verified_reason_modified;
            }

            public String getVerified_contact_name() {
                return verified_contact_name;
            }

            public void setVerified_contact_name(String verified_contact_name) {
                this.verified_contact_name = verified_contact_name;
            }

            public String getVerified_contact_email() {
                return verified_contact_email;
            }

            public void setVerified_contact_email(String verified_contact_email) {
                this.verified_contact_email = verified_contact_email;
            }

            public String getVerified_contact_mobile() {
                return verified_contact_mobile;
            }

            public void setVerified_contact_mobile(String verified_contact_mobile) {
                this.verified_contact_mobile = verified_contact_mobile;
            }

            public boolean isFollow_me() {
                return follow_me;
            }

            public void setFollow_me(boolean follow_me) {
                this.follow_me = follow_me;
            }

            public int getOnline_status() {
                return online_status;
            }

            public void setOnline_status(int online_status) {
                this.online_status = online_status;
            }

            public int getBi_followers_count() {
                return bi_followers_count;
            }

            public void setBi_followers_count(int bi_followers_count) {
                this.bi_followers_count = bi_followers_count;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public int getMbtype() {
                return mbtype;
            }

            public void setMbtype(int mbtype) {
                this.mbtype = mbtype;
            }

            public int getMbrank() {
                return mbrank;
            }

            public void setMbrank(int mbrank) {
                this.mbrank = mbrank;
            }

            public int getBlock_word() {
                return block_word;
            }

            public void setBlock_word(int block_word) {
                this.block_word = block_word;
            }

            public int getBlock_app() {
                return block_app;
            }

            public void setBlock_app(int block_app) {
                this.block_app = block_app;
            }

            public int getCredit_score() {
                return credit_score;
            }

            public void setCredit_score(int credit_score) {
                this.credit_score = credit_score;
            }

            public int getUser_ability() {
                return user_ability;
            }

            public void setUser_ability(int user_ability) {
                this.user_ability = user_ability;
            }

            public int getUrank() {
                return urank;
            }

            public void setUrank(int urank) {
                this.urank = urank;
            }
        }

        public static class VisibleBean {
            private int type;
            private int list_id;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getList_id() {
                return list_id;
            }

            public void setList_id(int list_id) {
                this.list_id = list_id;
            }
        }

        public static class PicUrlsBean {
            private String thumbnail_pic;

            public String getThumbnail_pic() {
                return thumbnail_pic;
            }

            public void setThumbnail_pic(String thumbnail_pic) {
                this.thumbnail_pic = thumbnail_pic;
            }
        }

        public static class AnnotationsBean {
            private String client_mblogid;

            public String getClient_mblogid() {
                return client_mblogid;
            }

            public void setClient_mblogid(String client_mblogid) {
                this.client_mblogid = client_mblogid;
            }
        }
    }
}
