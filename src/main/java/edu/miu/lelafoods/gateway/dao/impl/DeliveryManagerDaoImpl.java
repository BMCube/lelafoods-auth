package edu.miu.lelafoods.gateway.dao.impl;

import edu.miu.lelafoods.gateway.dao.DeliveryManagerDao;
import edu.miu.lelafoods.gateway.domain.DeliveryManager;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class DeliveryManagerDaoImpl extends GenericDaoImpl<DeliveryManager> implements DeliveryManagerDao {
    public DeliveryManagerDaoImpl() {
        super.setDaoType(DeliveryManager.class);
    }

    public DeliveryManager findByUsername(String username){
        Query query = entityManager.createQuery("select m from DeliveryManager m  where m.username =:username");
        return (DeliveryManager) query.setParameter("username", username).getSingleResult();
    }

}
