package com.tsystems.js.db.services;

import com.tsystems.js.db.config.DBConfig;
import com.tsystems.js.db.entities.Ticket;
import com.tsystems.js.db.repositories.TicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

/**
 * Created by kull on 28.09.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@Transactional
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void testGetBoughtTickets() throws Exception {

    }

    @Test
    public void testBuyTicket() throws Exception {;
    }

    @Test
    public void testWithdrawTicket() throws Exception {

    }

    @Test
    public void testUpdateTicketInfo() throws Exception {

    }
}