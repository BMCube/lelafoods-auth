package edu.miu.lelafoods.auth.dao;

import edu.miu.lelafoods.auth.domain.User;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);
}
