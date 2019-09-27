package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="UserComments")
public class UserComments implements Serializable {

    private Integer id;
    //借阅人
    private User jyUser;
    //所属人
    private User user;
    //所属商品
    private Goods goods;
    //借阅人评分
    private Integer jypf;
    //所属人评分
    private Integer sspf;
    //是否已评价(0未 1借阅人已评价 2所属人已评价)
    private Integer isYp;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name="jypf", nullable=false, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getJypf() {
        return jypf;
    }

    public void setJypf(Integer jypf) {
        this.jypf = jypf;
    }
    @Column(name="sspf", nullable=false, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getSspf() {
        return sspf;
    }

    public void setSspf(Integer sspf) {
        this.sspf = sspf;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="jyUser_id")
    public User getJyUser() {
        return jyUser;
    }

    public void setJyUser(User jyUser) {
        this.jyUser = jyUser;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="goods_id")
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public UserComments(Goods goods) {
        this.goods = goods;
    }

    public UserComments() {
    }

    @Column(name="isYp", nullable=false, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsYp() {
        return isYp;
    }

    public void setIsYp(Integer isYp) {
        this.isYp = isYp;
    }
}
