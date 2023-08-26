package com.lin.usernacos.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.common.Result;
import com.lin.common.pojo.User;
import com.lin.common.utils.IpUtils;
import com.lin.usernacos.client.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lin
 * @version 02:33
 * @date 2023-08-25
 */
@RestController
@RequestMapping("/user")
public class UserApi {

    @Value("${server.port}")
    private int port;

    @Resource
    private UserClient userClient;

    @GetMapping("/get")
    public Result get() {
        System.out.println("开始调用了远程服务");
        Result result = userClient.get();
        Object data = result.getData();
        //将Object转换为User对象
        User user = new ObjectMapper().convertValue(data, User.class);
        user.setAge(user.getAge()+1);
        result.setData(user);
        System.out.println("调用了远程服务结束，其返回结果：" + result);
        return result;
    }
    @GetMapping("/get2")
    public Result get2() {
        String ipAddr = IpUtils.getIpAddr();
        User user = new User();
        user.setAge(20);
        user.setName("linShengwei");
        user.setSex("女");
        System.out.println("ip:"+ipAddr+",调用了本服务，本端口：" + port + "，返回结果：" + user);
        return new Result("user", user);
    }



}
