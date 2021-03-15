package com.example.demo.redis.RedisUtil;

/**
 * @author Zhengyn
 * @description
 * @create 20/12/3 15:11
 */
public interface RedisArgs {

    /***
     * 缓存过期时间 单位分钟
     * */
    long ONE_DAY_MINUTES = 60 * 10;

    long A_WEEK_MINUTES = 60 * 24 * 7;
}
