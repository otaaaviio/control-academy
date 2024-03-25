package com.academy.controlacademy.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exercise_weight_history")
public class ExerciseWeightHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer previous_weight;

    @Column(nullable = false)
    private Integer new_weight;

    @Temporal(TemporalType.DATE)
    private Date date;

    public ExerciseWeightHistory() {}

    public ExerciseWeightHistory(Exercise exercise, Integer previous_weight, Integer new_weight, Date date, User user) {
        this.exercise = exercise;
        this.previous_weight = previous_weight;
        this.new_weight = new_weight;
        this.date = date;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPrevious_weight() {
        return previous_weight;
    }

    public void setPrevious_weight(Integer previous_weight) {
        this.previous_weight = previous_weight;
    }

    public Integer getNew_weight() {
        return new_weight;
    }

    public void setNew_weight(Integer new_weight) {
        this.new_weight = new_weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
