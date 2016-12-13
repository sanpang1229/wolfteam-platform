package com.wolfteam.manage.pojo;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "tb_item_desc")
public class ItemDesc {

    /**
     * 商品ID
     */
//    @Id
    private Long itemId;
    
    /**
     * 商品描述
     */
    private String itemDesc;
    
    private Date created;
    
    private Date updated;
    
    public ItemDesc(){
        
    }

    public ItemDesc(Long itemId, String itemDesc, Date created, Date updated) {
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.created = created;
        this.updated = updated;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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
        return "ItemDesc [itemId=" + itemId + ", itemDesc=" + itemDesc + ", created=" + created
                + ", updated=" + updated + "]";
    }
}
