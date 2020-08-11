package edu.miu.lelafoods.gateway.controller;

import edu.miu.lelafoods.gateway.domain.Customer;
import edu.miu.lelafoods.gateway.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = CustomerController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    public static final String BASE_URL = "/customers";

    CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<Customer> listCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = {"/{customerId}"})
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public Customer registerCustomer(@Valid @RequestBody Customer customer) throws Exception {
        customer.setRoles(new ArrayList<>(Arrays.asList("ROLE_CUSTOMER")));
        return customerService.registerCustomer(customer);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@Valid @RequestBody Customer updatedCustomer, @PathVariable Long customerId){
        return customerService.updateCustomer(updatedCustomer,customerId);
    }

    @DeleteMapping(value = {"/{customerId}"})
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
    }

}
