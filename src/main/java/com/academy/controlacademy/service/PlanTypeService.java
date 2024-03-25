package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.PlanType;
import com.academy.controlacademy.repository.PlanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanTypeService extends BaseService<PlanType> {

    @Autowired
    public PlanTypeService(PlanTypeRepository repository) {
        super(repository);
    }
}
