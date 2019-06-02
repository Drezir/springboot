package securityproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import securityproject.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);
    User getById(Long id);
}
