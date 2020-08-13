package edu.miu.lelafoods.gateway.dao;

import edu.miu.lelafoods.gateway.domain.DeliveryManager;

public interface DeliveryManagerDao extends GenericDao<DeliveryManager> {
    DeliveryManager findByUsername(String username);
}
