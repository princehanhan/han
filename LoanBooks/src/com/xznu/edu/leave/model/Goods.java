package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Goods")
public class Goods implements Serializable {

    private Integer id;
    //图片地址
    private String fileName1;
    private String fileName2;
    private String fileName3;
    private String fileName4;
    private String fileName5;
    //图书名称
    private String name;
    //图书介绍
    private String js;
    //图书借阅次数
    private Integer count;
    //0未删除，1已删除
    private Integer isDelete;
    //角色
    private User user;
    //借阅人
    private User jyUser;
    //是否借阅(0未借 1已借)
    private Integer isJy;
    //是否上架(0是 1否)
    private Integer isSj;
    private Integer isSh;
    private ItemTypeSecondary itemTypeSecondary;
    private List<Integer> types;
    private Integer isSd;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName1() {
        return fileName1;
    }

    public void setFileName1(String fileName1) {
        this.fileName1 = fileName1;
    }

    public String getFileName2() {
        return fileName2;
    }

    public void setFileName2(String fileName2) {
        this.fileName2 = fileName2;
    }

    public String getFileName3() {
        return fileName3;
    }

    public void setFileName3(String fileName3) {
        this.fileName3 = fileName3;
    }

    public String getFileName4() {
        return fileName4;
    }

    public void setFileName4(String fileName4) {
        this.fileName4 = fileName4;
    }

    public String getFileName5() {
        return fileName5;
    }

    public void setFileName5(String fileName5) {
        this.fileName5 = fileName5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="js", nullable=true, length = 2000, updatable = true, insertable = true)
    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    @Column(name="count", nullable=true, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name="isDelete", nullable=true, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="itemTypeSecondary_id")
    public ItemTypeSecondary getItemTypeSecondary() {
        return itemTypeSecondary;
    }

    public void setItemTypeSecondary(ItemTypeSecondary itemTypeSecondary) {
        this.itemTypeSecondary = itemTypeSecondary;
    }
    @Transient
    public List<Integer> getTypes() {
        return types;
    }

    public void setType(List<Integer> types) {
        this.types = types;
    }

    public User getJyUser() {
        return jyUser;
    }

    public void setJyUser(User jyUser) {
        this.jyUser = jyUser;
    }

    @Column(name="isJy", nullable=true, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsJy() {
        return isJy;
    }

    public void setIsJy(Integer isJy) {
        this.isJy = isJy;
    }
    @Column(name="isSj", nullable=true, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsSj() {
        return isSj;
    }

    public void setIsSj(Integer isSj) {
        this.isSj = isSj;
    }
    @Column(name="isSd", nullable=true, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsSd() {
        return isSd;
    }

    public void setIsSd(Integer isSd) {
        this.isSd = isSd;
    }

    @Column(name="isSh", nullable=true, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsSh() {
        return isSh;
    }

    public void setIsSh(Integer isSh) {
        this.isSh = isSh;
    }
}
