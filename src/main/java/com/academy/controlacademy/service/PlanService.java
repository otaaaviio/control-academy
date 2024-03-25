package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.Plan;
import com.academy.controlacademy.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService extends BaseService<Plan> {

  @Autowired
  public PlanService(PlanRepository repository) {
    super(repository);
  }
}
