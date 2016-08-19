package com.wsg.lovehome.bean;

import java.util.List;

public class StatusesBean {
    private String source;
    private String mid;
    private int userType;
    private int textLength;
    private int attitudes_count;
    private String gif_ids;
    private String in_reply_to_user_id;
    /**
     * urank : 14
     * screen_name : 不完美的你别怂
     * mbrank : 2
     * weihao :
     * province : 44
     * statuses_count : 4212
     * following : false
     * class : 1
     * follow_me : false
     * verified_type : -1
     * id : 5819872720
     * verified_reason_url :
     * cover_image_phone : http://ww2.sinaimg.cn/crop.0.0.640.640.640/006lRAKQgw1f6b3nmoy0yj30u00u079i.jpg
     * domain :
     * avatar_hd : http://tva2.sinaimg.cn/crop.0.0.996.996.1024/006lRAKQjw8f6t7y5yp39j30ro0rpgn1.jpg
     * friends_count : 192
     * bi_followers_count : 27
     * location : 广东 江门
     * verified_source :
     * name : 不完美的你别怂
     * pagefriends_count : 20
     * verified_reason :
     * mbtype : 11
     * verified_source_url :
     * avatargj_id : gj_vip_011
     * remark :
     * url :
     * city : 7
     * gender : f
     * cardid : star_026
     * block_app : 1
     * ptype : 0
     * block_word : 0
     * star : 0
     * verified : false
     * allow_all_act_msg : false
     * lang : zh-cn
     * idstr : 5819872720
     * profile_url : u/5819872720
     * credit_score : 80
     * avatar_large : http://tva2.sinaimg.cn/crop.0.0.996.996.180/006lRAKQjw8f6t7y5yp39j30ro0rpgn1.jpg
     * user_ability : 0
     * online_status : 0
     * geo_enabled : true
     * followers_count : 62
     * profile_image_url : http://tva2.sinaimg.cn/crop.0.0.996.996.50/006lRAKQjw8f6t7y5yp39j30ro0rpgn1.jpg
     * description : 多吃点   胖点也没事  放正你已经很胖了
     * verified_trade :
     * created_at : Mon Jan 04 09:30:26 +0800 2016
     * favourites_count : 462
     * allow_all_comment : true
     */

    private UserBean user;
    private int source_type;
    private long id;
    private int page_type;
    private String idstr;
    /**
     * list_id : 0
     * type : 0
     */

    private VisibleBean visible;
    private int biz_feature;
    private int mlevel;
    private boolean favorited;
    private int positive_recom_flag;
    private String in_reply_to_status_id;
    private boolean truncated;
    private int hasActionTypeCard;
    private String text;
    private int reposts_count;
    private int source_allowclick;
    private String created_at;
    private int comments_count;
    private boolean isLongText;
    private String in_reply_to_screen_name;
    private List<?> text_tag_tips;
    private List<?> hot_weibo_tags;
    private List<Integer> biz_ids;
    private List<?> pic_urls;
    private List<?> darwin_tags;
    /**
     * shooting : 1
     * client_mblogid : 5a780e54-069d-4c81-a15a-42c329b844e6
     */

    private List<AnnotationsBean> annotations;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getTextLength() {
        return textLength;
    }

    public void setTextLength(int textLength) {
        this.textLength = textLength;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public String getGif_ids() {
        return gif_ids;
    }

    public void setGif_ids(String gif_ids) {
        this.gif_ids = gif_ids;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getSource_type() {
        return source_type;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPage_type() {
        return page_type;
    }

    public void setPage_type(int page_type) {
        this.page_type = page_type;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public VisibleBean getVisible() {
        return visible;
    }

    public void setVisible(VisibleBean visible) {
        this.visible = visible;
    }

    public int getBiz_feature() {
        return biz_feature;
    }

    public void setBiz_feature(int biz_feature) {
        this.biz_feature = biz_feature;
    }

    public int getMlevel() {
        return mlevel;
    }

    public void setMlevel(int mlevel) {
        this.mlevel = mlevel;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public int getPositive_recom_flag() {
        return positive_recom_flag;
    }

    public void setPositive_recom_flag(int positive_recom_flag) {
        this.positive_recom_flag = positive_recom_flag;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public int getHasActionTypeCard() {
        return hasActionTypeCard;
    }

    public void setHasActionTypeCard(int hasActionTypeCard) {
        this.hasActionTypeCard = hasActionTypeCard;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public int getSource_allowclick() {
        return source_allowclick;
    }

    public void setSource_allowclick(int source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public boolean isIsLongText() {
        return isLongText;
    }

    public void setIsLongText(boolean isLongText) {
        this.isLongText = isLongText;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public List<?> getText_tag_tips() {
        return text_tag_tips;
    }

    public void setText_tag_tips(List<?> text_tag_tips) {
        this.text_tag_tips = text_tag_tips;
    }

    public List<?> getHot_weibo_tags() {
        return hot_weibo_tags;
    }

    public void setHot_weibo_tags(List<?> hot_weibo_tags) {
        this.hot_weibo_tags = hot_weibo_tags;
    }

    public List<Integer> getBiz_ids() {
        return biz_ids;
    }

    public void setBiz_ids(List<Integer> biz_ids) {
        this.biz_ids = biz_ids;
    }

    public List<?> getPic_urls() {
        return pic_urls;
    }

    public void setPic_urls(List<?> pic_urls) {
        this.pic_urls = pic_urls;
    }

    public List<?> getDarwin_tags() {
        return darwin_tags;
    }

    public void setDarwin_tags(List<?> darwin_tags) {
        this.darwin_tags = darwin_tags;
    }

    public List<AnnotationsBean> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationsBean> annotations) {
        this.annotations = annotations;
    }
}
