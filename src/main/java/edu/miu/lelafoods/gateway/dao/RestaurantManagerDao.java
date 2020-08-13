package edu.miu.lelafoods.gateway.dao;

import edu.miu.lelafoods.gateway.domain.RestaurantManager;

public interface RestaurantManagerDao extends GenericDao<RestaurantManager> {
    RestaurantManager findByUsername(String username);
}
