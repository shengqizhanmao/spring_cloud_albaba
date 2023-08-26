package com.lin.user.dao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.common.Result;
import com.lin.common.pojo.User;
import com.lin.common.utils.IpUtils;
import com.lin.user.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserClient userClient;

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

    @GetMapping("/get2")
    public Result get2() {
        System.out.println("开始调用了远程服务");
        Result result = userClient.get2();
        Object data = result.getData();
        //将Object转换为User对象
        User user = new ObjectMapper().convertValue(data, User.class);
        user.setAge(user.getAge()+3);
        result.setData(user);
        System.out.println("调用了远程服务结束，其返回结果：" + result);
        return new Result("user", user);
    }
}
