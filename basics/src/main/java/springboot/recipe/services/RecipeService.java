package springboot.recipe.services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.recipe.models.Recipe;
import springboot.recipe.repositories.RecipeRepository;
import springboot.recipe.utils.RecipeUtils;

@Service
public class RecipeService {

  @Autowired
  RecipeRepository recipeRepository;

  public Collection<Recipe> getAllRecipes() {
    return RecipeUtils.fromIterable(recipeRepository.findAll());
  }

}
