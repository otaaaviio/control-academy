package com.academy.controlacademy.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class Training {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Temporal(TemporalType.DATE)
  private Date start_date;

  @ManyToMany
  @JoinTable(
      name = "training_exercises",
      joinColumns = @JoinColumn(name = "training_id"),
      inverseJoinColumns = @JoinColumn(name = "exercise_id"))
  private Set<Exercise> exercises;

  public Training() {}

  public Training(User user, Date start_date, Set<Exercise> exercises) {
    this.user = user;
    this.start_date = start_date;
    this.exercises = exercises;
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

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Set<Exercise> getExercises() {
    return exercises;
  }

  public void setExercises(Set<Exercise> exercises) {
    this.exercises = exercises;
  }
}
