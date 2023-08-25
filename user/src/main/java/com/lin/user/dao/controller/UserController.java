package com.lin.user.dao.controller;

import com.lin.common.Result;
import com.lin.common.pojo.User;
import com.lin.common.utils.IpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private int port;
    @GetMapping("/get")
    public Result hello() {
        String ipAddr = IpUtils.getIpAddr();
        User user = new User();
        user.setAge(18);
        user.setName("lin");
        user.setSex("男");
        System.out.println("ip:"+ipAddr+",调用了本服务，本端口：" + port + "，返回结果：" + user);
        return new Result("user", user);
    }

    //获取IP地址
}
