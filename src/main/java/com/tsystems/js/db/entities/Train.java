package com.tsystems.js.db.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TRAIN")
public class Train {

    private int trainNumber;
    private int version;
    private int availableSeats;
    private List<Station> path;


    public Train() {
    }

    public Train(int trainNumber, int availableSeats, List<Station> path) {
        this.trainNumber = trainNumber;
        this.availableSeats = availableSeats;
        this.path = path;
    }

    @Id
    @Column(name="ID_TRAIN_NUMBER")
    public int getTrainNumber() {
        return trainNumber;
    }

    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }

    @Column(name="AVAILABLE_SEATS")
    public int getAvailableSeats() {
        return availableSeats;
    }

    @OneToMany
    @JoinTable(name="TRAIN_ROUTE",
               joinColumns = @JoinColumn(name="STATION_ID"),
               inverseJoinColumns = @JoinColumn(name="TRAIN_ID"))
    public List<Station> getPath() {
        return path;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setPath(List<Station> path) {
        this.path = path;
    }
}
