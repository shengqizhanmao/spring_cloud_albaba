package com.lin.usernacos.client;

import com.lin.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lin
 * @version 00:48
 * @date 2023-08-26
 */
@FeignClient(name = "userService",path =  "/user")
public interface UserClient {
    @GetMapping("/get")
    Result get();
}
