package edu.miu.lelafoods.gateway.dao.impl;

import edu.miu.lelafoods.gateway.dao.CustomerDao;
import edu.miu.lelafoods.gateway.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {
    public CustomerDaoImpl() {
        super.setDaoType(Customer.class);
    }

    public Customer findByUsername(String username){
        Query query = entityManager.createQuery("select m from Customer m  where m.username =:username");
        return (Customer) query.setParameter("username", username).getSingleResult();
    }

}
