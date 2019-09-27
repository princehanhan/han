package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="ItemType")
public class ItemType implements Serializable {

    private Integer id;
    //名称
    private String name;
    //删除(0未删除 1删除)
    private Integer isDelete;

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

//    <many-to-one name="parent" column="Dw_ID" class="Dw" lazy="false"/>
//        <set name="child" inverse="true" cascade="delete" where="isDelete = 0" order-by="sort asc, id asc">
//            <cache usage="read-write"/>
//            <key column="Dw_ID"/>
//            <one-to-many class="Dw"/>
//        </set>

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
