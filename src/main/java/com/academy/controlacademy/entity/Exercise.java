package com.academy.controlacademy.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private Integer num_series;

  @Column(nullable = false)
  private Integer min_reps;

  @Column(nullable = false)
  private Integer max_reps;

  @Column(nullable = false)
  private Integer weight;

  @Column(nullable = false)
  private Integer rest_time;

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @ManyToMany
  @JoinTable(
      name = "exercise_muscles",
      joinColumns = @JoinColumn(name = "exercise_id"),
      inverseJoinColumns = @JoinColumn(name = "muscle_id"))
  private Set<Muscle> muscles;

  @ManyToMany(mappedBy = "exercises")
  private Set<Training> trainings;

  public Exercise() {}

  public Exercise(
      String name,
      Integer num_series,
      Integer min_reps,
      Integer max_reps,
      Integer weight,
      Integer rest_time,
      Set<Muscle> muscles,
      Set<Training> trainings) {
    this.name = name;
    this.num_series = num_series;
    this.min_reps = min_reps;
    this.max_reps = max_reps;
    this.weight = weight;
    this.rest_time = rest_time;
    this.muscles = muscles;
    this.trainings = trainings;
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

  public Integer getNum_series() {
    return num_series;
  }

  public void setNum_series(Integer num_series) {
    this.num_series = num_series;
  }

  public Integer getMin_reps() {
    return min_reps;
  }

  public void setMin_reps(Integer min_reps) {
    this.min_reps = min_reps;
  }

  public Integer getMax_reps() {
    return max_reps;
  }

  public void setMax_reps(Integer max_reps) {
    this.max_reps = max_reps;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getRest_time() {
    return rest_time;
  }

  public void setRest_time(Integer rest_time) {
    this.rest_time = rest_time;
  }

  public Set<Muscle> getMuscles() {
    return muscles;
  }

  public void setMuscles(Set<Muscle> muscles) {
    this.muscles = muscles;
  }

  public Set<Training> getTrainings() {
    return trainings;
  }

  public void setTrainings(Set<Training> trainings) {
    this.trainings = trainings;
  }
}
