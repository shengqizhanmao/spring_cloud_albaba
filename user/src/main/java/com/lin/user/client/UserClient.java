package com.lin.user.client;

import com.lin.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lin
 * @version 21:13
 * @date 2023-08-26
 */
@FeignClient(name = "userService2",path =  "/user")
public interface UserClient {
    @GetMapping("/get2")
    Result get2();
}
