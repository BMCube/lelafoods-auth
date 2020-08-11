package edu.miu.lelafoods.gateway.dao.impl;

import edu.miu.lelafoods.gateway.dao.UserDao;
import edu.miu.lelafoods.gateway.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super.setDaoType(User.class);
    }

    public User findByUsername(String username) {
        Query query = entityManager.createQuery("select m from User m  where m.username =:username");
        return (User) query.setParameter("username", username).getSingleResult();
    }

}
