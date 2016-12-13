package com.wolfteam.manage.pojo;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_item_cat")
public class ItemCat {

    @Id
    private Long id;

    private Long parentId;

    private String name;
    
    private Integer status;
    
    private Integer sortOrder;
    
    private Boolean isParent;
    
    private Date created;
    private Date updated;
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * easyui的返回结果集
     * @return
     */
    public String getText(){
        return getName();
    }
    
    /**
     * 打开状态，closed：父节点，open：叶子节点
     * @return
     */
    public String getState(){
        return getIsParent() ? "closed" : "open";
    }

    @Override
    public String toString() {
        return "ItemCat [id=" + id + ", parentId=" + parentId + ", name=" + name + "]";
    }
}
