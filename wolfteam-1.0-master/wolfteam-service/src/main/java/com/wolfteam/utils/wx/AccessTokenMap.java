package com.wolfteam.utils.wx;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wolfteam.conmon.wx.WXPlatAPIUtil;

import net.sf.json.JSONObject;

public class AccessTokenMap {
    private static Log log = LogFactory.getLog(AccessTokenMap.class);

    private static Map<String, Entity> toeknStory = new HashMap<>();

    // private Entity entity = new Entity();

    public static Map<String, Entity> getToeknStory() {
        return toeknStory;
    }

    public static void setToeknStory(Map<String, Entity> toeknStory) {
        AccessTokenMap.toeknStory = toeknStory;
    }

    public static String getAccessToekn(String key, Date now) {
        Entity e = toeknStory.get(key);
        if (e != null && e.getExpireTime() != null && e.getExpireTime().after(now)) {
            log.info("AccessToen-没有超时 直接获取：" + e.getAccessToken() + "<<<超时时间：" + e.getExpireTime());
            return e.getAccessToken();
        } else {
            log.info("AccessToen-已经超时了超时 重新获取获取");
            JSONObject o = WXPlatAPIUtil.getAccessToken("wx94173ae840e4c429","fce2c755a2cfaa2e7c660929436545d0");
            System.out.println(o);
            AccessTokenMap.setAccessToekn("AccessToken", o.getString("access_token"), initHaftHourDate());
            return o.getString("access_token");
        }
    }

    public static void setAccessToekn(String key, String accessToken, Date expireTime) {
        Entity e = toeknStory.get(key);
        if (e == null) {
            e = new Entity();
            e.setAccessToken(accessToken);
            e.setExpireTime(expireTime);
            toeknStory.put(key, e);
            return;
        }
        e.setAccessToken(accessToken);
        e.setExpireTime(expireTime);
        toeknStory.put(key, e);
    }

    static class Entity {
        private String accessToken;

        private Date expireTime;

        public Entity() {
            super();
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Date getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Date expireTime) {
            this.expireTime = expireTime;
        }

    }

    public static void main(String[] args) {
        System.out.println(AccessTokenMap.getAccessToekn("AccessToken", new Date()));
    }

    private static Date initHaftHourDate() {
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long curren = System.currentTimeMillis();
        curren += 28 * 60 * 1000;
        Date da = new Date(curren);
        return da;
    }

}
