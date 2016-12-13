package com.wolfteam.manage.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品规则参数(模板表)
 * 
 */
@Table(name = "tb_item_param")
public class ItemParam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 商品类目ID
     */
    private Long itemCatId;
    
    /**
     * 参数数据，格式为json格式
     */
    private String paramData;
    
    private Date created;
    private Date updated;
    
    public ItemParam(){}
    
    public ItemParam(Long id, Long itemCatId, String paramData, Date created, Date updated) {
        this.id = id;
        this.itemCatId = itemCatId;
        this.paramData = paramData;
        this.created = created;
        this.updated = updated;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getItemCatId() {
        return itemCatId;
    }
    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }
    public String getParamData() {
        return paramData;
    }
    public void setParamData(String paramData) {
        this.paramData = paramData;
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
    @Override
    public String toString() {
        return "ItemParam [id=" + id + ", itemCatId=" + itemCatId + ", paramData=" + paramData + ", created="
                + created + ", updated=" + updated + "]";
    }

}
