package springboot.recipe.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import springboot.recipe.models.Description;
import springboot.recipe.models.Ingredient;
import springboot.recipe.models.Recipe;
import springboot.recipe.repositories.RecipeRepository;

@Component
@Slf4j
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {

  private RecipeRepository recipeRepository;

  public DatabaseInitializer(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    log.info("Beginning of table initialization");

    Ingredient salt = new Ingredient();
    Ingredient pepper = new Ingredient();
    salt.setName("Salt");
    pepper.setName("Pepper");

    Description description = new Description();
    description.setDescription("bla");

    Recipe recipe = new Recipe();
    recipe.setDescription(description);
    recipe
        .addIngredient(salt)
        .addIngredient(pepper);

    recipeRepository.save(recipe);

    log.info("Ending of table initialization");
  }
}
