package com.tsystems.js.db.repositories;

import com.tsystems.js.db.entities.Passenger;
import com.tsystems.js.db.entities.Station;

import java.util.List;

/**
 * Created by kull on 28.09.16.
 */
public interface StationRepository extends GenericRepository<Station> {
    Station findByName(String stationName);
}
