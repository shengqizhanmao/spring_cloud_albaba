package com.lin.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(UserApplication.class, args);
        while(true){
            String user = run.getEnvironment().getProperty("user");
            String test = run.getEnvironment().getProperty("test");
            System.out.println("user:"+user+"----"+"test:"+test);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
