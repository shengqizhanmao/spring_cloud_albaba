package com.lin.sentinelService;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lin.common.Result;
import com.lin.sentinelService.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin
 * @version 12:52
 * @date 2023-09-03
 */
@RestController
public class TsetController {
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }
    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }
    @Autowired
    private UserClient userClient;
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id)
    {
        return userClient.get(id);
    }


    @GetMapping("/fusing/{name}")
    @SentinelResource(value="fusing", blockHandler = "fusingTestBlockHandle")
    public String fusingTest(@PathVariable(value = "name",required = false) String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success" + name;
    }

    /**
     * BlockException异常处理
     * @param name
     * @param e
     * @return
     */
    public String fusingTestBlockHandle(String name, BlockException e) {
        e.printStackTrace();
        String msg = "fusingTest接口被熔断了，请稍后再试，name=" + name;
        System.out.println(msg);
        return msg;
    }

}
