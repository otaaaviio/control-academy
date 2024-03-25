package com.academy.controlacademy.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16, unique = true)
    private String number;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Temporal(TemporalType.DATE)
    private Date expiration_date;

    public CreditCard() {}

    public CreditCard(String number, String cvv, Date expiration_date) {
        this.number = number;
        this.cvv = cvv;
        this.expiration_date = expiration_date;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
}
