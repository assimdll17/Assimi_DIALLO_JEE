package enset.ma.jpamanymany.repositories;

import enset.ma.jpamanymany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String > {
    User findUserByUserName(String user);
}
