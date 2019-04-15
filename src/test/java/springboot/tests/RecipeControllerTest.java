package springboot.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springboot.recipe.controllers.RecipeController;
import springboot.recipe.models.Description;
import springboot.recipe.models.Ingredient;
import springboot.recipe.models.Recipe;
import springboot.recipe.services.RecipeService;

public class RecipeControllerTest {

  @Mock
  RecipeService recipeService;

  RecipeController recipeController;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    recipeController = new RecipeController(recipeService);
  }

  @Test
  public void testController() throws Exception {
    Recipe recipe = new Recipe();
    recipe.setDescription(new Description());
    recipe.addIngredient(new Ingredient());
    recipe.getDescription().setDescription("Description");
    recipe.getIngredients().forEach(i -> i.setName("Ingredient"));

    ObjectMapper objectMapper = new ObjectMapper();
    String expectedJson = objectMapper.writeValueAsString(Collections.singleton(recipe));

    when(recipeService.getAllRecipes()).thenReturn(Collections.singletonList(recipe));

    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

    mockMvc.perform(get("/recipe/list"))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(expectedJson));
  }


}
