package com.psr.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;


    // Constructor, getters, and setters

    public Country(  String country ) {

        this.country = country;

    }


    public Country() {

    }


    public int getCountryId() {
        return countryId;
    }


    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public Date getLastUpdate() {
        return lastUpdate;
    }


    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    @Override
    public String toString() {
        return "Country [countryId=" + countryId + ", country=" + country + ", lastUpdate=" + lastUpdate + "]";
    }




}

