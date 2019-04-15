package springboot.tests;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.recipe.models.Description;
import springboot.recipe.repositories.DescriptionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Name has to end with IT to invoke maven-failsafe-plugin to test system integration
 */
public class IntegrationTestIT {

  @Autowired
  DescriptionRepository descriptionRepository;

  @Test
  public void integrationTest() {
    Optional<Description> foundDescription = descriptionRepository.findByDescription("bla");
    Assert.assertNotNull(foundDescription.get());
  }

}
