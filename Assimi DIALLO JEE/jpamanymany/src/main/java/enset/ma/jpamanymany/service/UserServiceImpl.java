package enset.ma.jpamanymany.service;

import enset.ma.jpamanymany.entities.Role;
import enset.ma.jpamanymany.entities.User;
import enset.ma.jpamanymany.repositories.RoleRepository;
import enset.ma.jpamanymany.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String role) {
        return roleRepository.findRoleByRoleName(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = userRepository.findUserByUserName(username);
        Role role = roleRepository.findRoleByRoleName(rolename);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);

        }
        userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findUserByUserName(username);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
