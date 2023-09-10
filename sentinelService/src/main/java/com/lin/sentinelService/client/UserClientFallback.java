package com.lin.sentinelService.client;

import com.lin.common.Result;
import org.springframework.stereotype.Component;

/**
 * @author lin
 * @version 14:37
 * @date 2023-09-03
 */

@Component
public class UserClientFallback implements UserClient{
    @Override
    public Result get(String id) {
        return new Result(30001, "用户服务被限流了", null, false);
    }
}
