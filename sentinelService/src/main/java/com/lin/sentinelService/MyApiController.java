package com.lin.sentinelService;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin
 * @version 20:06
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/api")
@Slf4j
@RefreshScope
public class MyApiController {

    @Value("${username}")
    private String username;

    @Value("${age}")
    private String age;

    @GetMapping(value = "/getData")
    public JSONObject getData() {
        log.info("username:" + username);
        log.info("age:" + age);
        return new JSONObject().fluentPut("username", username);
    }
}