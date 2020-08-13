package edu.miu.lelafoods.gateway.service;

import edu.miu.lelafoods.gateway.domain.DeliveryManager;

import java.util.List;

public interface DeliveryManagerService {
    List<DeliveryManager> getAllDeliveryManagers();
    DeliveryManager getDeliveryManagerById(Long id);
    DeliveryManager registerDeliveryManager(DeliveryManager deliveryManager) throws Exception;
    DeliveryManager updateDeliveryManager(DeliveryManager updatedDeliveryManager, Long deliveryManagerId);
    void deleteDeliveryManagerById(Long deliveryManagerId);
    DeliveryManager getByUsername(String username);
}
