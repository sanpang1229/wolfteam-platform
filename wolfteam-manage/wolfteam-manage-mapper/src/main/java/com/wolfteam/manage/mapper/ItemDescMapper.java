package com.wolfteam.manage.mapper;

import com.wolfteam.manage.base.mapper.WolfteamMapper;
import com.wolfteam.manage.pojo.ItemDesc;

public interface ItemDescMapper extends WolfteamMapper<ItemDesc>{

    /**
     * 根据商品id更新描述数据
     * 
     * @param itemDesc
     */
    void updateItemDescByItemId(ItemDesc itemDesc);

}
