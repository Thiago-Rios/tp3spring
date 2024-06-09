package com.infnet.tp3spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void cacheCurso(String key, Object curso) {
        redisTemplate.opsForValue().set(key, curso, 10, TimeUnit.MINUTES);
    }

    public Object getCursoFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void removeCursoFromCache(String key) {
        redisTemplate.delete(key);
    }
}
