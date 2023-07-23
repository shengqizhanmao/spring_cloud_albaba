package com.lin.ordernacos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin
 * @version 14:17
 * @date 2023-07-23
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{a}")
    public String add(@PathVariable("a") String a){
        System.out.println(a);
        return a;
    }
}
