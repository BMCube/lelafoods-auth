package edu.miu.lelafoods.gateway.dao.impl;

import edu.miu.lelafoods.gateway.dao.RestaurantManagerDao;
import edu.miu.lelafoods.gateway.domain.RestaurantManager;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class RestaurantManagerDaoImpl extends GenericDaoImpl<RestaurantManager> implements RestaurantManagerDao {
    public RestaurantManagerDaoImpl() {
        super.setDaoType(RestaurantManager.class);
    }

    public RestaurantManager findByUsername(String username){
        Query query = entityManager.createQuery("select m from RestaurantManager m  where m.username =:username");
        return (RestaurantManager) query.setParameter("username", username).getSingleResult();
    }

}
