package com.wolfteam.manage.mapper;

import java.util.List;

import com.wolfteam.manage.base.mapper.WolfteamMapper;
import com.wolfteam.manage.pojo.Content;

/**
 * 内容
 */
public interface ContentMapper extends WolfteamMapper<Content> {

    /**
     * 根据内容id查询内容列表，通过updated实现倒序查询
     * 
     * @param content
     * @return
     */
    List<Content> queryListOrderByUpdated(Content content);

}
