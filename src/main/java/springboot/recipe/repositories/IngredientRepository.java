package springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import springboot.recipe.models.Description;
import springboot.recipe.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
