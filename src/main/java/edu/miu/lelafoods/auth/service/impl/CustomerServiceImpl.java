package edu.miu.lelafoods.auth.service.impl;

import edu.miu.lelafoods.auth.domain.Customer;
import edu.miu.lelafoods.auth.dao.CustomerDao;
import edu.miu.lelafoods.auth.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao;
    PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, @Lazy PasswordEncoder passwordEncoder) {
        this.customerDao = customerDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }


    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.findOne(id);
    }

    @Override
    public Customer registerCustomer(Customer customer) throws Exception {
        if (!(customerDao.findByUsername(customer.getUsername()) != null)) {
            String plainPasssword = customer.getPassword();
            customer.setPassword(this.passwordEncoder.encode(plainPasssword));

            Customer savedCustomer = customerDao.save(customer);
            return savedCustomer;
        } else {
            throw new Exception("Username " + customer.getUsername() + " is already taken");
        }
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer, Long customerId) {
        return customerDao.update(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerDao.deleteById(customerId);
    }

    @Override
    public Customer getByUsername(String username) {
        return customerDao.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
    }

}
