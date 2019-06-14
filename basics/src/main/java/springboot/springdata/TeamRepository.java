package springboot.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestResource(path = "teams", rel = "teams")
@RestController
public interface TeamRepository extends JpaRepository<Team, Long> {

  Team findByName(@PathVariable("team") String team);

}
