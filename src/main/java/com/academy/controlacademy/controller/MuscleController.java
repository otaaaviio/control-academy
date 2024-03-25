package com.academy.controlacademy.controller;

import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.service.MuscleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/muscles")
public class MuscleController {
    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping("/{id}")
    public Muscle findMuscleById(@PathVariable Long id) {
        return muscleService.findById(id);
    }

    @GetMapping
    public List<Muscle> indexMuscle() {
        return muscleService.index();
    }

    @PostMapping
    public Muscle createMuscle(@RequestBody Muscle record) {
        return muscleService.create(record);
    }

    @PutMapping("/{id}")
    public Muscle updateMuscle(@PathVariable Long id, @RequestBody Muscle record) {
        if (muscleService.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Muscle not found");
        }
        return muscleService.update(record);
    }

    @DeleteMapping("/{id}")
    public void deleteMuscle(@PathVariable Long id) {
            muscleService.delete(id);
    }
}
