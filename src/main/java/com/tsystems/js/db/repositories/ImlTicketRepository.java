package com.tsystems.js.db.repositories;

import com.tsystems.js.db.entities.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by kull on 28.09.16.
 */
@Repository
public class ImlTicketRepository implements TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void create(Ticket entity) {
        entityManager.persist(entity);
    }

    public Ticket findById(int id) {
        return entityManager.find(Ticket.class, id);
    }

    public List<Ticket> findAll() {
        return entityManager.createQuery("SELECT t from TICKET t").getResultList();
    }

    public void update(Ticket entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    public List<Ticket> getBoughtTickets(int trainNumber) {
        return entityManager.createQuery("SELECT ticket FROM Ticket ticket WHERE ticket.trainNumber='" + trainNumber + "'")
                .getResultList();
    }
}
