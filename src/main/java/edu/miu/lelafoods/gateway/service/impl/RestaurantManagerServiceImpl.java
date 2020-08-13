package edu.miu.lelafoods.gateway.service.impl;

import edu.miu.lelafoods.gateway.dao.RestaurantManagerDao;
import edu.miu.lelafoods.gateway.domain.RestaurantManager;
import edu.miu.lelafoods.gateway.service.RestaurantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    RestaurantManagerDao restaurantManagerDao;
    PasswordEncoder passwordEncoder;

    @Autowired
    public RestaurantManagerServiceImpl(RestaurantManagerDao restaurantManagerDao, @Lazy PasswordEncoder passwordEncoder) {
        this.restaurantManagerDao = restaurantManagerDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<RestaurantManager> getAllRestaurantManagers() {
        return restaurantManagerDao.findAll();
    }


    @Override
    public RestaurantManager getRestaurantManagerById(Long id) {
        return restaurantManagerDao.findOne(id);
    }

    @Override
    public RestaurantManager registerRestaurantManager(RestaurantManager restaurantManager) throws Exception {
//        if (!(restaurantManagerDao.findByUsername(restaurantManager.getUsername()) != null)) {
            String plainPasssword = restaurantManager.getPassword();
            restaurantManager.setPassword(this.passwordEncoder.encode(plainPasssword));

            RestaurantManager savedRestaurantManager = restaurantManagerDao.save(restaurantManager);
            return savedRestaurantManager;
//        } else {
//            throw new Exception("Username " + restaurantManager.getUsername() + " is already taken");
//        }
    }

    @Override
    public RestaurantManager updateRestaurantManager(RestaurantManager updatedRestaurantManager, Long restaurantManagerId) {
        return restaurantManagerDao.update(updatedRestaurantManager);
    }

    @Override
    public void deleteRestaurantManagerById(Long restaurantManagerId) {
        restaurantManagerDao.deleteById(restaurantManagerId);
    }

    @Override
    public RestaurantManager getByUsername(String username) {
        return restaurantManagerDao.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
    }

}
