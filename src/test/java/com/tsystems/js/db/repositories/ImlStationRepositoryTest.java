package com.tsystems.js.db.repositories;

import com.tsystems.js.db.config.DBConfig;
import com.tsystems.js.db.config.DBTestConfig;
import com.tsystems.js.db.entities.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBTestConfig.class)
@Transactional
public class ImlStationRepositoryTest {

    @Autowired
    private StationRepository stationRepository;


    @Test
    public void testCreate() throws Exception {

        stationRepository.create(new Station("TestSt1"));
        Station st = stationRepository.findByName("TestSt1");
        assertThat(st.getStationName(), is(notNullValue()));

        stationRepository.create(new Station("TestSt2"));
        stationRepository.create(new Station("TestSt2"));
        List<Station> stations= stationRepository.findAll();
        assertThat(stations.size(), is(2));

    }

    @Test
    public void testFindById() throws Exception {
        stationRepository.create(new Station("Test"));
        Station st1 = stationRepository.findByName("Test");
        int idSt1 = st1.getId();
        st1 = stationRepository.findById(idSt1);
        assertThat(st1.getStationName(), is("Test"));
    }

    @Test
    public void testFindByName() throws Exception{
        stationRepository.create(new Station("TestSt1"));
        Station st = stationRepository.findByName("TestSt1");
        assertThat(st, is(notNullValue()));
        assertThat(st.getStationName(), is("TestSt1"));
    }

    @Test
    public void testFindAll() throws Exception {
        for(int i = 0; i < 20; i++){
            stationRepository.create(new Station("Test" + i));
        }
        List<Station> stations = stationRepository.findAll();
        assertThat(stations.size(), is(20));
    }

    @Test
    public void testUpdate() throws Exception {
        Station test = new Station("Test");
        stationRepository.create(test);
        test = stationRepository.findByName("Test");
        test.setStationName("TestU");
        int testId = test.getId();
        stationRepository.update(test);
        test = stationRepository.findById(testId);
        assertThat(test.getStationName(), is("TestU"));
    }

    @Test
    public void testDelete() throws Exception {
        for(int i = 0; i < 20; i++){
            stationRepository.create(new Station("Test" + i));
        }

        for(int i = 0; i < 20; i++){
            stationRepository.delete(stationRepository.findByName("Test" + i).getId());
        }

        List<Station> station = stationRepository.findAll();
        assertThat(station.size(), is(0));
    }
}