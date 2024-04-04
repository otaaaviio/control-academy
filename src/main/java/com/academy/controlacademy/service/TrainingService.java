package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.TrainingDto;
import com.academy.controlacademy.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingService extends BaseService<Training, TrainingDto> {
  @Autowired
  public TrainingService(JpaRepository<Training, Long> repository) {
    super(repository);
  }

  @Override
  protected Training newEntityInstance() {
    return new Training();
  }

  //  private final TrainingRepository trainingRepository;
  //
  //  @Autowired
  //  public TrainingService(
  //      TrainingRepository repository) {
  //    this.trainingRepository = repository;
  //  }

  //  public ResponseEntity<Training> create(TrainingDto request) {
  //    Training training = new Training();
  //
  //    training.setUser(request.user());
  //    training.setStart_date(request.start_date());
  //    training.setExercises(request.exercises());
  //
  //    return ResponseEntity.status(HttpStatus.CREATED).body(trainingRepository.save(training));
  //  }
  //
  //  public ResponseEntity<Training> findById(Long id) {
  //    Optional<Training> record = trainingRepository.findById(id);
  //    return record
  //            .map(t -> ResponseEntity.status(HttpStatus.OK).body(t))
  //            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  //  }
  //
  //  public ResponseEntity<List<Training>> index() {
  //    return ResponseEntity.status(HttpStatus.OK)
  //            .body(trainingRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
  //  }
  //
  //  public ResponseEntity<Training> update(Long id, TrainingDto request) {
  //    Training training = trainingRepository.findById(id)
  //            .orElseThrow(() -> new EntityNotFoundException("Unable to find training with id:" +
  // id));
  //
  //    training.setUser(request.user());
  //    training.setStart_date(request.start_date());
  //    training.setExercises(request.exercises());
  //
  //    return ResponseEntity.status(HttpStatus.OK).body(trainingRepository.save(training));
  //  }
  //
  //  public ResponseEntity<Object> delete(Long id) {
  //    Optional<Training> record = trainingRepository.findById(id);
  //    if (record.isEmpty()) {
  //      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  //    }
  //    trainingRepository.deleteById(id);
  //    return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
  //  }
}
