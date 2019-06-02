package springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import springboot.recipe.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
