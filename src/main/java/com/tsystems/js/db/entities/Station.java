package com.tsystems.js.db.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name="STATION")
public class Station {

    private int id;
    private int version;
    private String stationName;
    private Map<Station, Date> timeTable;

    public Station() {
    }

    public Station(String stationName) {
        this.stationName = stationName;
    }

    public Station(String stationName, Map<Station, Date> timeTable) {
        this.stationName = stationName;
        this.timeTable = timeTable;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    public int getId() {
        return id;
    }

    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }

    @Column(name="STATION_NAME")
    public String getStationName() {
        return stationName;
    }

    @ElementCollection
    @JoinTable(name = "TIME_TABLE")
    @Column (name="DEPARTURE_TIME")
    @MapKeyColumn(name="STATION_ID")
    public Map<Station, Date> getTimeTable() {
        return timeTable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setTimeTable(Map<Station, Date> timeTable) {
        this.timeTable = timeTable;
    }
}
