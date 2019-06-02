package springboot.reactive.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springboot.reactive.models.Car;
import springboot.reactive.services.CarService;

@RestController
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping(path = "/cars/{id}")
  public Mono<Car> getCar(Long id) {
    return carService.getCar(id);
  }

}
