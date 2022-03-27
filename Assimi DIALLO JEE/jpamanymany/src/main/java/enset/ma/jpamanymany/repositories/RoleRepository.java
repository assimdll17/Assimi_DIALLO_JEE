package enset.ma.jpamanymany.repositories;

import enset.ma.jpamanymany.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String role);
}
