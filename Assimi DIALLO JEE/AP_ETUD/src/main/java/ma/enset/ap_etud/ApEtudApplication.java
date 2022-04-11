package ma.enset.ap_etud;

import ma.enset.ap_etud.entities.Etudiant;
import ma.enset.ap_etud.entities.Genre;
import ma.enset.ap_etud.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
