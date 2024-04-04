package com.academy.controlacademy.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class Training {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @OneToMany(mappedBy = "training")
  private Set<TrainingUser> trainingUsers;

  @ManyToMany
  @JoinTable(
      name = "training_exercises",
      joinColumns = @JoinColumn(name = "training_id"),
      inverseJoinColumns = @JoinColumn(name = "exercise_id"))
  private Set<Exercise> exercises;

  public Training() {}

  public Training(String title, Set<TrainingUser> trainingUsers, Set<Exercise> exercises) {
    this.title = title;
    this.trainingUsers = trainingUsers;
    this.exercises = exercises;
  }

  public Long getId() {
    return id;
  }

  public Set<TrainingUser> getTrainingUsers() {
    return trainingUsers;
  }

  public void setTrainingUsers(Set<TrainingUser> trainingUsers) {
    this.trainingUsers = trainingUsers;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Exercise> getExercises() {
    return exercises;
  }

  public void setExercises(Set<Exercise> exercises) {
    this.exercises = exercises;
  }
}
