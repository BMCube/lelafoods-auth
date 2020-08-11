package edu.miu.lelafoods.gateway.dao;

import java.util.List;

public interface GenericDao<T> {
    T save(T t);

    void deleteById(Long id);

    T findOne(Long id);

    T update(T t);

    List<T> findAll();



}
