package ma.enset.ap_etud;

import ma.enset.ap_etud.entities.Etudiant;
import ma.enset.ap_etud.entities.Genre;
import ma.enset.ap_etud.repositories.EtudiantRepository;
import ma.enset.ap_etud.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ApEtudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApEtudApplication.class, args);
    }

   // @Bean
    CommandLineRunner saveEtudiants(EtudiantRepository etudiantRepository){
       return args->{
           etudiantRepository.save(new Etudiant(null,"Diallo","Toto","assim@mail.com",new Date(), Genre.MASCULIN,true));
           etudiantRepository.save(new Etudiant(null,"Ba","Fifi","ba@mail.com",new Date(), Genre.FEMININ,true));
           etudiantRepository.save(new Etudiant(null,"Barry","Momo","barry@mail.com",new Date(), Genre.MASCULIN,true));
           etudiantRepository.save(new Etudiant(null,"Sow","Nana","sow@mail.com",new Date(), Genre.FEMININ,false));

           etudiantRepository.findAll().forEach(e->{
               System.out.println(e.getNom()+" "+e.getPrenom());
           });
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args->{
            securityService.saveNewUser("assimi", "1234","1234");
            securityService.saveNewUser("diallo", "1234","1234");
            securityService.saveNewUser("assimdll", "1234","1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("assimi", "USER");
            securityService.addRoleToUser("assimi", "ADMIN");
            securityService.addRoleToUser("diallo", "USER");
            securityService.addRoleToUser("assimdll", "USER");
        };
    }

}
