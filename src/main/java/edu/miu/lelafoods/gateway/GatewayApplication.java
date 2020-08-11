package edu.miu.lelafoods.gateway;

import edu.miu.lelafoods.gateway.domain.User;
import edu.miu.lelafoods.gateway.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.ArrayList;
import java.util.Arrays;


@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class GatewayApplication implements CommandLineRunner {

    @Autowired
    MyUserDetailsService userService;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("admin@miu.edu","admin","George","","Cannon", new ArrayList<>(Arrays.asList("ROLE_ADMIN")));
        userService.saveUser(user);
    }
}
