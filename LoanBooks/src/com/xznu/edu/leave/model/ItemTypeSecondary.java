package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ItemTypeSecondary")
public class ItemTypeSecondary implements Serializable {

    private Integer id;
    //名称
    private String name;
    private ItemType itemType;
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

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="itemType_id")
    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
