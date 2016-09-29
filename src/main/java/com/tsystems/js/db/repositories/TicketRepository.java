package com.tsystems.js.db.repositories;

import com.tsystems.js.db.entities.Ticket;

import java.util.List;

/**
 * Created by kull on 28.09.16.
 */
public interface TicketRepository extends GenericRepository<Ticket> {
    List<Ticket> getBoughtTickets(int trainNumber);
}
