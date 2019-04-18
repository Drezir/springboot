package springboot.reactive.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import springboot.reactive.models.Car;

@Repository
public interface CarsRepository extends ReactiveMongoRepository<Car, Long> {

  Mono<Car> findByCarId(Long id);
}
