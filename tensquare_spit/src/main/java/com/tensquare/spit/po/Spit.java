package com.tensquare.spit.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * 吐槽实体类
 *
 * @Author: CooFive
 * @CreateDate: 18/9/2 15:13
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Spit implements Serializable {
    /**
     * 主键标识，该属性的值会自动对应mongodb的主键字段"_id",如果该属性名就叫"id",则该注释可以省略，否则必须写
     */
    @Id
    private String id;
    /**
     * 该属性对应mongodb的字段的名字，如果一致，则无需该注解
     * 吐槽内容
     */
    @Field("content")
    private String content;
    /**
     * 发布日期
     */
    private Date publishtime;
    /**
     * 发布人id
     */
    private String userid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 浏览量
     */
    private Integer visits;
    /**
     * 点赞数
     */
    private Integer thumbup;
    /**
     * 分享数
     */
    private Integer share;
    /**
     * 回复数
     */
    private Integer comment;
    /**
     * 状态
     */
    private String state;
    /**
     * 上级id
     */
    private String parentid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
