package com.academy.controlacademy.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, length = 14, unique = true)
  private String cpf;

  @Temporal(TemporalType.DATE)
  private Date birth_date;

  @Column(nullable = false)
  private Boolean is_instructor = false;

  public User() {}

  public User(String name, String cpf, Date birth_date, Boolean is_instructor) {
    this.name = name;
    this.cpf = cpf;
    this.birth_date = birth_date;
    this.is_instructor = is_instructor;
  }

  @Override
  public boolean equals(Object o) {
    return (this == o) || (o instanceof User user && Objects.equals(id, user.id));
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Boolean getIs_instructor() {
    return is_instructor;
  }

  public void setIs_instructor(Boolean is_instructor) {
    this.is_instructor = is_instructor;
  }

  public Date getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }
}
