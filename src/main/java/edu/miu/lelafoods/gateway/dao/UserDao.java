package edu.miu.lelafoods.gateway.dao;

import edu.miu.lelafoods.gateway.domain.User;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);
}
