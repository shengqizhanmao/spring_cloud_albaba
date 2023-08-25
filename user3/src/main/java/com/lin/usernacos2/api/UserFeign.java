package com.lin.usernacos2.api;

import com.lin.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lin
 * @version 02:33
 * @date 2023-08-25
 */
@FeignClient(value = "userService",path = "/user")
public interface UserFeign {

    @GetMapping("/get")
    Result get();
}