package edu.miu.lelafoods.auth.service;

import edu.miu.lelafoods.auth.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer registerCustomer(Customer customer) throws Exception;
    Customer updateCustomer(Customer updatedCustomer, Long customerId);
    void deleteCustomerById(Long customerId);
    Customer getByUsername(String username);
}
