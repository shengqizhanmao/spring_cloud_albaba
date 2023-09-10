package com.lin.sentinelService.client;

import com.lin.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lin
 * @version 14:12
 * @date 2023-09-03
 */
@FeignClient(value = "userService", path = "/user",fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("/get/{id}")
    Result get(@RequestParam("id") String id);
}
