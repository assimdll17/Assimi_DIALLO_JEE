package enset.ma.jpamanymany.service;

import enset.ma.jpamanymany.entities.Role;
import enset.ma.jpamanymany.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String role);
    void addRoleToUser(String user, String role);
    User authenticate(String username, String password);
}
