package com.academy.controlacademy.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "training_users")
public class TrainingUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;


  @ManyToOne
  @JoinColumn(name = "training_id", nullable = false)
  private Training training;

  @Temporal(TemporalType.DATE)
  private Date date;

  public TrainingUser() {}

  public TrainingUser(User user, Training training, Date date) {
    this.user = user;
    this.training = training;
    this.date = date;
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

  public Training getTraining() {
    return training;
  }

  public void setTraining(Training training) {
    this.training = training;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
