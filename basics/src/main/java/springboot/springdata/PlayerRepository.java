package springboot.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestResource(path = "players", rel = "players")
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
