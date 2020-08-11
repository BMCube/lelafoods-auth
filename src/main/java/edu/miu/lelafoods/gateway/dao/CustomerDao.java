package edu.miu.lelafoods.gateway.dao;

import edu.miu.lelafoods.gateway.domain.Customer;

public interface CustomerDao extends GenericDao<Customer> {
    Customer findByUsername(String username);
}
