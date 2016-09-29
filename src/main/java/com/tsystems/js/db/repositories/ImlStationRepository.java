package com.tsystems.js.db.repositories;

import com.tsystems.js.db.entities.Station;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ImlStationRepository implements StationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Station entity) {
        if(findByName(entity.getStationName()) == null) {
            entityManager.persist(entity);
        }else{}
    }

    public Station findById(int id) {
        return entityManager.find(Station.class, id);
    }

    public List<Station> findAll() {
        return entityManager.createQuery("SELECT station FROM Station station").getResultList();
    }

    public void update(Station entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    public Station findByName(String stationName) {
        try {
            return (Station) entityManager.createQuery("SELECT station from Station station " +
                    "WHERE station.stationName='" + stationName + "'").getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
