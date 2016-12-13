package org.wechat.abbs.callutils.dto.wx.resp;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午5:01:17
 * 类说明
 * 			响应消息之音乐消息
 *
 * @version 0.1 
 *  
 */
public class MusicMessageResp extends BaseMessageResp {  
    // 音乐  
    private Music Music;  
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        Music = music;  
    }  
}  