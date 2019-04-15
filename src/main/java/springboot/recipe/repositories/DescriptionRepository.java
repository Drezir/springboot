package springboot.recipe.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import springboot.recipe.models.Description;

public interface DescriptionRepository extends CrudRepository<Description, Long> {
  Optional<Description> findByDescription(String description);
}
