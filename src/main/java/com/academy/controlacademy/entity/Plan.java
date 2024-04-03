package com.academy.controlacademy.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "plan_type_id", nullable = false)
    private PlanType plan_type;

    @Column(nullable = false)
    private Double monthly_value;

    @Temporal(TemporalType.DATE)
    private Date start_date;

    @ManyToOne
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard credit_card;

    public Plan() {}

    public Plan(User user, PlanType plan_type, Double monthly_value, Date start_date, CreditCard credit_card) {
        this.user = user;
        this.plan_type = plan_type;
        this.monthly_value = monthly_value;
        this.start_date = start_date;
        this.credit_card = credit_card;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PlanType getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(PlanType plan_type) {
        this.plan_type = plan_type;
    }

    public Double getMonthly_value() {
        return monthly_value;
    }

    public void setMonthly_value(Double monthly_value) {
        this.monthly_value = monthly_value;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public CreditCard getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(CreditCard credit_card) {
        this.credit_card = credit_card;
    }
}
