package springboot.springdata;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import javax.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TeamService {

  private final TeamRepository teamRepository;

  @PostConstruct
  public void init() {
    Team team = new Team();
    team.setName("Team");
    Player player = new Player("John", "Wayne");
    player.setTeam(team);
    team.setPlayers(new HashSet<>(Collections.singletonList(player)));
    teamRepository.save(team);
  }

}
