package demo.springboot.redis.redis.aop;

import demo.springboot.redis.redis.RedisUtil;
import demo.springboot.redis.redis.annoatation.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Slf4j
@Component
public class RedisCacheAspect {
    @Autowired
    private RedisUtil redisUtil;

    /*
     * 配置切入点
     * */
    @Pointcut("@annotation(demo.springboot.redis.redis.annoatation.RedisCache)")
    public void aspect() {
    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 获取切面对象
        Class<?> targetClass = point.getTarget().getClass();

        // 获取目标方法名称
        String methodName = point.getSignature().getName();

        // 获取切面方法
        Method targetMethod = targetClass.getMethod(methodName);

        // 获取切面方法注解
        RedisCache redisCache = targetMethod.getAnnotation(RedisCache.class);

        // 获取切面方法参数
        Map<String, Object> params = getPointParams(point);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            log.info("name: " + entry.getKey() + " value: " + entry.getValue());
        }

        // 获取缓存Key值
        String key = redisCache.Key();

        // 从缓存获取数据
        Object result = redisUtil.get(key);

        // 如果缓存命中，则返回缓存数据
        if (result != null) {
            log.info("从缓存中获取了城市 >> " + result.toString());
            return result;
        }

        result =  point.proceed();
        log.info("从方法中获取了城市 >> " + result.toString());
        redisUtil.set(key, result, 60* 1000);

        return result;
    }

    private Map<String, Object> getPointParams(ProceedingJoinPoint point) {
        Map<String, Object> params = new HashMap<>();

        String[] paramNames = ((CodeSignature)point.getSignature()).getParameterNames();
        Object[] paramValues = point.getArgs();

        for (int i=0;i< paramNames.length; i++) {
            params.put(paramNames[i], paramValues[i]);
        }

        return params;
    }
}
