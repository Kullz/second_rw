package com.tsystems.js.db.repositories;

import com.tsystems.js.db.config.DBTestConfig;
import com.tsystems.js.db.entities.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DBTestConfig.class)
@Transactional
public class ImlPassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    public void testCreate() throws Exception {
        for(int i = 0; i < 10; i++){
            Passenger pas1 = new Passenger("Test", "Tester", new GregorianCalendar(2000, 11, 10).getTime());
            passengerRepository.create(pas1);
        }

        List<Passenger> passengers = passengerRepository.findAll();
        assertThat(passengers.size(), is(1));
    }

    @Test
    public void testFindAll() throws Exception {
        for(int i = 0; i < 20; i++){
            Passenger pas = new Passenger("Test"+i, "Tester", new GregorianCalendar(2000,11,10).getTime());
            passengerRepository.create(pas);
        }

        List<Passenger> passengers = passengerRepository.findAll();
        assertThat(passengers.size(), is(20));
    }

    @Test
    public void testUpdate() throws Exception {
        Passenger pas = new Passenger("Test", "Tester", new GregorianCalendar(2000, 11, 10).getTime());
        passengerRepository.create(pas);
        pas = passengerRepository.getPassenger(pas);
        pas.setFirstName("NewTest");
        int pasId = pas.getId();
        passengerRepository.update(pas);
        pas = passengerRepository.findById(pasId);
        assertThat(pas.getFirstName(), is("NewTest"));
    }

    @Test
    public void testDelete() throws Exception {
        for (int i = 0; i < 30; i++){
            Passenger pas = new Passenger("Test" + i, "Tester", new GregorianCalendar(2000, 9, 11).getTime());
            passengerRepository.create(pas);
            passengerRepository.delete(passengerRepository.getPassenger(pas).getId());
        }

        Passenger pas = new Passenger("Test", "Tester", new GregorianCalendar(2000, 9, 11).getTime());
        passengerRepository.create(pas);
        List<Passenger> passengers = passengerRepository.findAll();

        assertThat(passengers.size(), is(1));
    }
}