package springboot.recipe.controllers;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.recipe.models.Recipe;
import springboot.recipe.services.RecipeService;

@RestController
public class RecipeController {

  private RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/recipe/list")
  public Collection<Recipe> listRecipes() {
    return recipeService.getAllRecipes();
  }

}
