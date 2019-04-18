package springboot.reactive;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import springboot.reactive.models.Car;
import springboot.reactive.repositories.CarsRepository;

@Slf4j
@Component
public class BootstrapDb implements ApplicationListener<ApplicationReadyEvent> {

  private final CarsRepository carsRepository;

  public BootstrapDb(CarsRepository carsRepository) {
    this.carsRepository = carsRepository;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    Car car1 = new Car("BMW", 1d, 1l);
    Car car2 = new Car("Škoda", 2d, 2l);
    Car car3 = new Car("Audi", 3d, 3l);
    Car car4 = new Car("Subaru", 4d, 4l);
    Car car5 = new Car("Hyundai", 5d, 5l);
    Car car6 = new Car("Toyota", 6d, 6l);
    Car car7 = new Car("Mercedes", 7d, 7l);
    Car car8 = new Car("Dacia", 8d, 8l);

    log.info("MongoDB initialization");
    carsRepository.saveAll(Arrays.asList(
        car1, car2, car3, car4, car5, car6, car7, car8
    )).subscribe();
    log.info("MongoDB initialization done");
  }
}
