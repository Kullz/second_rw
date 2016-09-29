package com.tsystems.js.db.repositories;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.tsystems.js.db.entities.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ImlPassengerRepository implements PassengerRepository {

    @PersistenceContext
    private EntityManager entityManager;



    public void create(Passenger passenger) {
        try {
            getPassenger(passenger);
        }catch (Exception e) {
            entityManager.persist(passenger);
        }
    }

    public Passenger findById(int id) {
        return entityManager.find(Passenger.class, id);
    }

    public List<Passenger> findAll() {
        return entityManager.createQuery("SELECT pas FROM Passenger pas").getResultList();
    }

    public void update(Passenger passenger) {
        entityManager.merge(passenger);
    }

    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    public Passenger getPassenger(Passenger passenger) throws NoResultException {
        TypedQuery<Passenger> query = entityManager.createQuery("SELECT pas FROM Passenger pas " +
                "WHERE pas.firstName=:firstName and pas.lastName=:lastName", Passenger.class );
        query.setParameter("firstName", passenger.getFirstName());
        query.setParameter("lastName", passenger.getLastName());

        return query.getSingleResult();
    }
}
