package springboot.tests;

import static junit.framework.TestCase.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import springboot.reactive.models.Car;
import springboot.reactive.repositories.CarsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReactiveCarTestIT {

  @Autowired
  CarsRepository carsRepository;


  @Test
  public void testLoadCarsReactively() throws InterruptedException {
    Flux<Car> flux = Flux.empty();
    for (long i = 0; i < 8; ++i) {
      flux = Flux.merge(carsRepository.findByCarId(i + 1).log(), flux);
    }
    CarConsumerChecker carConsumerChecker = new CarConsumerChecker();
    flux.parallel(8).subscribe(carConsumerChecker);
    System.out.println("Test done yet? No! Async job are running");
    Thread.sleep(5000);
    assertEquals(8, carConsumerChecker.cars.size());
  }

  private class CarConsumerChecker implements Consumer<Car> {

    private Set<Car> cars;

    public CarConsumerChecker() {
      cars = new HashSet<>();
    }

    @Override
    public void accept(Car car) {
      cars.add(car);
      log.info("Carr added: " + car);
    }
  }
}
