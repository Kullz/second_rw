package com.tsystems.js.db.repositories;

import com.tsystems.js.db.entities.Train;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by kull on 28.09.16.
 */
@Repository
public class ImlTrainRepository implements TrainRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Train entity) {
        entityManager.persist(entity);
    }

    public Train findById(int id) {
        return entityManager.find(Train.class, id);
    }

    public List<Train> findAll() {
        return entityManager.createQuery("SELECT train FROM TRAIN train").getResultList();
    }

    public void update(Train entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
