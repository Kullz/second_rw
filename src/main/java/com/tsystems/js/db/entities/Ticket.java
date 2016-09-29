package com.tsystems.js.db.entities;


import sun.reflect.CallerSensitive;

import javax.persistence.*;

@Entity
@Table(name="TICKET")
public class Ticket {

    public static final String boughtTickets = "boughtTickets";

    private int id;
    private int trainNumber;
    private Passenger passenger;
    private int version;

    public Ticket() {
    }


    public Ticket(int trainNumber, Passenger passenger) {
        this.trainNumber = trainNumber;
        this.passenger = passenger;
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

    @Column(name="TRAIN_NUMBER")
    public int getTrainNumber() {
        return trainNumber;
    }

    @OneToOne
    @JoinColumn(name="PASSENGER_ID")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
