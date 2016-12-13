package com.wolfteam.common.vo;

import java.util.Date;

public class TaotaoItemMQResult {

    private Long itemId;

    private Date create;

    private Date update;

    public TaotaoItemMQResult() {

    }

    public TaotaoItemMQResult(Long itemId) {
        this.itemId = itemId;
    }

    public TaotaoItemMQResult(Long itemId, Date create, Date update) {
        this.itemId = itemId;
        this.create = create;
        this.update = update;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

}
