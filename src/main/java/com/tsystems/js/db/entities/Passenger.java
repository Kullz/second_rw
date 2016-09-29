package com.tsystems.js.db.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PASSENGER")
public class Passenger {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name="BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
