package edu.miu.lelafoods.gateway.service.impl;

import edu.miu.lelafoods.gateway.dao.DeliveryManagerDao;
import edu.miu.lelafoods.gateway.domain.DeliveryManager;
import edu.miu.lelafoods.gateway.service.DeliveryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryManagerServiceImpl implements DeliveryManagerService {

    DeliveryManagerDao deliveryManagerDao;
    PasswordEncoder passwordEncoder;

    @Autowired
    public DeliveryManagerServiceImpl(DeliveryManagerDao deliveryManagerDao, @Lazy PasswordEncoder passwordEncoder) {
        this.deliveryManagerDao = deliveryManagerDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<DeliveryManager> getAllDeliveryManagers() {
        return deliveryManagerDao.findAll();
    }


    @Override
    public DeliveryManager getDeliveryManagerById(Long id) {
        return deliveryManagerDao.findOne(id);
    }

    @Override
    public DeliveryManager registerDeliveryManager(DeliveryManager deliveryManager) throws Exception {
//        if (!(deliveryManagerDao.findByUsername(deliveryManager.getUsername()) != null)) {
            String plainPasssword = deliveryManager.getPassword();
            deliveryManager.setPassword(this.passwordEncoder.encode(plainPasssword));

            DeliveryManager savedDeliveryManager = deliveryManagerDao.save(deliveryManager);
            return savedDeliveryManager;
//        } else {
//            throw new Exception("Username " + deliveryManager.getUsername() + " is already taken");
//        }
    }

    @Override
    public DeliveryManager updateDeliveryManager(DeliveryManager updatedDeliveryManager, Long deliveryManagerId) {
        return deliveryManagerDao.update(updatedDeliveryManager);
    }

    @Override
    public void deleteDeliveryManagerById(Long deliveryManagerId) {
        deliveryManagerDao.deleteById(deliveryManagerId);
    }

    @Override
    public DeliveryManager getByUsername(String username) {
        return deliveryManagerDao.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
    }

}
