package com.tsystems.js.db.services;

import com.tsystems.js.db.entities.Passenger;
import com.tsystems.js.db.entities.Ticket;
import com.tsystems.js.db.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by kull on 28.09.16.
 */

@Service
@Transactional
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public List<Ticket> getBoughtTickets(int trainId){
        return ticketRepository.getBoughtTickets(trainId);
    }

    @Transactional
    public void buyTicket(Ticket ticket){
        ticketRepository.create(ticket);
    }

    @Transactional
    public void withdrawTicket(int ticketId){
        ticketRepository.delete(ticketId);
    }

    @Transactional
    public void updateTicketInfo(Ticket ticket){
        ticketRepository.update(ticket);
    }
}
