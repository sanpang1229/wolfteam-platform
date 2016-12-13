package com.wolfteam.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {

    @Autowired(required = false)
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<ShardedJedis, T> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            // 从redis中获取数据
            return fun.execute(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    /**
     * set方法
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String execute(ShardedJedis shardedJedis) {
                return shardedJedis.set(key, value);
            }
        });
    }

    /**
     * 保存数据到redis中，并且设置过期时间
     * 
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String set(final String key, final String value, final Integer expire) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String execute(ShardedJedis shardedJedis) {
                // 设置数据
                String str = shardedJedis.set(key, value);
                // 设置过期时间
                shardedJedis.expire(key, expire);
                return str;
            }
        });
    }

    /**
     * 设置过期时间
     * 
     * @param key
     * @param expire
     * @return
     */
    public Long expire(final String key, final Integer expire) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long execute(ShardedJedis e) {
                return e.expire(key, expire);
            }
        });
    }

    /**
     * get 方法
     * 
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String execute(ShardedJedis e) {
                return e.get(key);
            }
        });
    }

    /**
     * 根据key删除redis中的数据
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long execute(ShardedJedis e) {
                return e.del(key);
            }
        });
    }

}
