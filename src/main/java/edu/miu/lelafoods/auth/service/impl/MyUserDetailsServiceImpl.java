package edu.miu.lelafoods.auth.service.impl;

import edu.miu.lelafoods.auth.dao.UserDao;
import edu.miu.lelafoods.auth.domain.User;
import edu.miu.lelafoods.auth.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    private UserDao userDao;

    PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserDetailsServiceImpl(UserDao users, @Lazy PasswordEncoder passwordEncoder) {
        this.userDao = users;
        this.passwordEncoder = passwordEncoder;
    }

    public User getByUsername(String username){
        return userDao.findByUsername(username);
//        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
    }

    public User saveUser(User user){
//        if(!(userDao.findByUsername(user.getUsername()) != null)){
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            return userDao.save(user);
//        }
//        return null;
    }

    public void saveUsers(List<User> users){
        for(User user:users){
            if(!(userDao.findByUsername(user.getUsername()) != null)){
                user.setPassword(this.passwordEncoder.encode(user.getPassword()));
                userDao.save(user);
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userDao.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }
}