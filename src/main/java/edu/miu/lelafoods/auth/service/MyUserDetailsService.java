package edu.miu.lelafoods.auth.service;

import edu.miu.lelafoods.auth.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MyUserDetailsService extends UserDetailsService {

    User getByUsername(String username);

    User saveUser(User user);

    void saveUsers(List<User> users);

    UserDetails loadUserByUsername(String username);

}
