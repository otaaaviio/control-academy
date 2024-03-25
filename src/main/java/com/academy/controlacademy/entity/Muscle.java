package com.academy.controlacademy.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "muscles")
public class Muscle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToMany(mappedBy = "muscles")
  private Set<Exercise> exercises;

  public Muscle() {}

  public Muscle(String name, Set<Exercise> exercises) {
    this.name = name;
    this.exercises = exercises;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Exercise> getExercises() {
    return exercises;
  }

  public void setExercises(Set<Exercise> exercises) {
    this.exercises = exercises;
  }
}
