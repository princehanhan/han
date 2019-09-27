package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="User")
public class User implements Serializable {

    private Integer id;
    //用户名
    private String name;
    //手机号码
    private String phone;
    //密码
    private String pass;
    //真实姓名
    private String realName;
    private String xh;
    //0未删除，1已删除
    private Integer isDelete;
    //是否审核（0未审核 1审核）
    private Integer isSh;
    //角色
    private Role role;
    //时间
    private Date time;
    //用户认证照片
    private String rz;
    //班级
    private String bj;
    //是否上下架(0上架 1下架)
    private Integer isSj;
    //评价次数
    private Integer pjcs;
    //评分
    private Double pf;
    //是否在读(0否 1是)
    private Integer zd;

    //所属系
    private String ssx;
    //专业
    private String zy;
    //禁用 0否 1是
    private Integer isJy;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name="isSh", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsSh() {
        return isSh;
    }

    public void setIsSh(Integer isSh) {
        this.isSh = isSh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getRz() {
        return rz;
    }

    public void setRz(String rz) {
        this.rz = rz;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    @Column(name="pf", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }

    @Column(name="isSj", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsSj() {
        return isSj;
    }

    public void setIsSj(Integer isSj) {
        this.isSj = isSj;
    }

    @Column(name="pjcs", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getPjcs() {
        return pjcs;
    }

    public void setPjcs(Integer pjcs) {
        this.pjcs = pjcs;
    }
    @Column(name="zd", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getZd() {
        return zd;
    }

    public void setZd(Integer zd) {
        this.zd = zd;
    }

    public String getSsx() {
        return ssx;
    }

    public void setSsx(String ssx) {
        this.ssx = ssx;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    @Column(name="isJy", nullable=false, columnDefinition="int default 0", updatable = true, insertable = true)
    public Integer getIsJy() {
        return isJy;
    }

    public void setIsJy(Integer isJy) {
        this.isJy = isJy;
    }
}
