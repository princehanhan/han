package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 回复评论
 */
@Entity
@Table(name="ReplyComments")
public class ReplyComments implements Serializable {

    private Integer id;
    //发表评论时间
    private Date time;
    //0未删除，1已删除
    private Integer isDelete;
    //所属评论
    private Comments comments;
    //回复人
    private User user;
    //发表内容
    private String nr;


    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="comments_id")
    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }
}
