package com.polaris.common.redis;

import com.polaris.common.annotations.RedisIdempotent;
import com.polaris.common.constants.RedisConstant;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TokenService {

    @Resource
    private RedisValueServiceImpl redisValueService;

    public String createToken() {
        String idempotent = UUID.randomUUID().toString() + System.currentTimeMillis();
        redisValueService.set(idempotent, idempotent, 5l, TimeUnit.MINUTES);
        return idempotent;
    }

    public void checkToken(HttpServletRequest request) {
        String idempotent = request.getHeader(RedisConstant.REDIS_IDEMPOTENT_KEY);
        Assert.hasLength(idempotent, "请勿重复提交!");
        idempotent = (String) redisValueService.get(idempotent);
        Assert.notNull(idempotent, "请勿重复提交");
        redisValueService.delete(idempotent);
    }
}
