package springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import springboot.recipe.models.Description;

public interface DescriptionRepository extends CrudRepository<Description, Long> {

}
