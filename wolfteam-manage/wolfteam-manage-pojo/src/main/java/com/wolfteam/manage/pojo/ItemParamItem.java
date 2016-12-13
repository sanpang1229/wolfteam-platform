package com.wolfteam.manage.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品规格和商品的关系表（最终生成的数据表）
 * 
 * @author zhijun
 *
 */
@Table(name = "tb_item_param_item")
public class ItemParamItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 商品ID
     */
    private Long itemId;
    
    /**
     * 参数数据，格式为json格式
     */
    private String paramData;
    
    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;
    
    public ItemParamItem(){}

    public ItemParamItem(Long id, Long itemId, String paramData, Date created, Date updated) {
        this.id = id;
        this.itemId = itemId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
        return "ItemParamItem [id=" + id + ", itemId=" + itemId + ", paramData=" + paramData + ", created="
                + created + ", updated=" + updated + "]";
    }
    
}
