package springboot.reactive.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import springboot.reactive.models.Car;
import springboot.reactive.repositories.CarsRepository;

@Service
public class CarService {

  private final CarsRepository carsRepository;

  public CarService(CarsRepository carsRepository) {
    this.carsRepository = carsRepository;
  }

  public Mono<Car> getCar(Long id) {
    return carsRepository.findById(id);
  }
}
