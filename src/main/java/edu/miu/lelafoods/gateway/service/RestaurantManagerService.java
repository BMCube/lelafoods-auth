package edu.miu.lelafoods.gateway.service;

import edu.miu.lelafoods.gateway.domain.RestaurantManager;

import java.util.List;

public interface RestaurantManagerService {
    List<RestaurantManager> getAllRestaurantManagers();
    RestaurantManager getRestaurantManagerById(Long id);
    RestaurantManager registerRestaurantManager(RestaurantManager restaurantManager) throws Exception;
    RestaurantManager updateRestaurantManager(RestaurantManager updatedRestaurantManager, Long restaurantManagerId);
    void deleteRestaurantManagerById(Long restaurantManagerId);
    RestaurantManager getByUsername(String username);
}
