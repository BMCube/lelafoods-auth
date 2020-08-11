package edu.miu.lelafoods.auth.dao;

import edu.miu.lelafoods.auth.domain.Customer;

public interface CustomerDao extends GenericDao<Customer> {
    Customer findByUsername(String username);
}
