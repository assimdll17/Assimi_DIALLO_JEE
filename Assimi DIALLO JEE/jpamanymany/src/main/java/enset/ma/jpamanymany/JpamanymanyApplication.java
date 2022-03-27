package enset.ma.jpamanymany;

import enset.ma.jpamanymany.entities.Role;
import enset.ma.jpamanymany.entities.User;
import enset.ma.jpamanymany.service.UserService;
import enset.ma.jpamanymany.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JpamanymanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpamanymanyApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args ->{
            Stream.of("assimdll", "diallo")
                    .forEach(username->{
                        User user = new User();
                        user.setUserName(username);
                        user.setPassword("12345");
                        userService.addNewUser(user);
                    });

            Stream.of("STUDENT","USER", "ADMIN")
                    .forEach(rolename->{
                        Role role = new Role();
                        role.setRoleName(rolename);
                        userService.addNewewRole(role);
                    });

            userService.addRoleToUser("assimdll","STUDENT");
            userService.addRoleToUser("assimdll","USER");
            userService.addRoleToUser("diallo","USER");
            userService.addRoleToUser("diallo","ADMIN");

            try {
                User user = userService.authenticate("assimdll","12345");
                //System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Roles--------->");

                user.getRoles().forEach(r->{
                    System.out.println("role : "+r.toString());
                });

            }catch(Exception e) {
                e.printStackTrace();
            }
        };



    }

}
