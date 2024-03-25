package com.academy.controlacademy.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "attendance_history")
public class AttendanceHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Temporal(TemporalType.DATE)
  private Date date;

  public AttendanceHistory() {}

  public AttendanceHistory(User user, Date date) {
    this.user = user;
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
