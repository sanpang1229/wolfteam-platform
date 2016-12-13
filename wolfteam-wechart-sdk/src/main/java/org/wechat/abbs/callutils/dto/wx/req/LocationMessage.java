package org.wechat.abbs.callutils.dto.wx.req;
 
/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午4:53:25
 * 类说明
 * 			请求消息之地理位置消息
 *
 * @version 0.1 
 *  
 */
public class LocationMessage extends BaseMessage {  
    // 地理位置维度  
    private String Location_X;  
    // 地理位置经度  
    private String Location_Y;  
    // 地图缩放大小  
    private String Scale;  
    // 地理位置信息  
    private String Label;  
  
    public String getLocation_X() {  
        return Location_X;  
    }  
  
    public void setLocation_X(String location_X) {  
        Location_X = location_X;  
    }  
  
    public String getLocation_Y() {  
        return Location_Y;  
    }  
  
    public void setLocation_Y(String location_Y) {  
        Location_Y = location_Y;  
    }  
  
    public String getScale() {  
        return Scale;  
    }  
  
    public void setScale(String scale) {  
        Scale = scale;  
    }  
  
    public String getLabel() {  
        return Label;  
    }  
  
    public void setLabel(String label) {  
        Label = label;  
    }  
}  