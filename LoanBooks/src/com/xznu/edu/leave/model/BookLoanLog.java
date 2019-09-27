package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="BookLoanLog")
public class BookLoanLog implements Serializable {

    private Integer id;
    //借阅时间
    private Date time;
    //图书
    private Goods goods;
    //0未删除，1已删除
    private Integer isDelete;
    //借阅人
    private User jyUser;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="jyUser_id")
    public User getJyUser() {
        return jyUser;
    }

    public void setJyUser(User jyUser) {
        this.jyUser = jyUser;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="goods_id")
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
