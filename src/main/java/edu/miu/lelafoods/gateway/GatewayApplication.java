package edu.miu.lelafoods.gateway;

import edu.miu.lelafoods.gateway.domain.Address;
import edu.miu.lelafoods.gateway.domain.Customer;
import edu.miu.lelafoods.gateway.domain.User;
import edu.miu.lelafoods.gateway.service.CustomerService;
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

    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("admin@lelafoods.com","admin","George","","Cannon", new ArrayList<>(Arrays.asList("ROLE_ADMIN")));
        userService.saveUser(user);

        Address address = new Address();
        address.setCity("Batavia");
        address.setStreet("1009 3rd St,");
        address.setPostalCode("52533");
        address.setCountry("USA");

        Customer customer = new Customer("customer@lelafoods.com","admin","George","","Cannon", new ArrayList<>(Arrays.asList("ROLE_CUSTOMER")),"EN302",address);
        customerService.registerCustomer(customer);
    }
}
