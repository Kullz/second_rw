package com.tsystems.js.db.repositories;

import java.util.List;

/**
 * Created by kull on 28.09.16.
 */
public interface GenericRepository<T> {

    void create(T entity);
    T findById(int id);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
}