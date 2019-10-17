package demo.springboot.redis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    //region Key操作

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    //endregion

    //region String操作

    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    //endregion

    //region Hash操作
    public void HashSet() {
        // 写如方法
    }
    //endregion
}
