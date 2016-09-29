package com.tsystems.js.db.repositories;

import com.tsystems.js.db.entities.Passenger;

import java.util.List;

/**
 * Created by kull on 28.09.16.
 */
public interface PassengerRepository extends GenericRepository<Passenger>{
    Passenger getPassenger(Passenger passenger);
}
