package com.example.jpaapp;

import com.example.jpaapp.entities.Patient;
import com.example.jpaapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      /*  patientRepository.save(new Patient(null,"hassan",new Date(),false,56));
        patientRepository.save(new Patient(null,"Mohammed",new Date(),true,100));
        patientRepository.save(new Patient(null,"Imane",new Date(),false,210));
        */
        for(int i=0; i<100;i++){
            patientRepository.save(
                    new Patient(null, "Hassan",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*1000))
            );
        }
       Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
        System.out.println("Total pages : "+patients.getTotalPages());
        System.out.println("Total elements :"+patients.getTotalElements());
        System.out.println("Num Page: "+patients.getNumber());
       // List<Patient> content = patients.getContent(); On peut utiliser content a la place de patients pour le foreach
        System.out.println("****************All******************");
       patients.forEach(p -> {
           System.out.println("===============================");
           System.out.println(p.getId());
           System.out.println(p.getNom());
           System.out.println(p.getScore());
           System.out.println(p.getDateNaissance());
           System.out.println(p.isMalade());
       });

        System.out.println("******************By Malade*****************");
        //Utilisation d'une methode definie dans l'interface
        Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,4));
        byMalade.forEach(p -> {
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });

        System.out.println("******************Chercher Patient*****************");
        List<Patient> patientList = patientRepository.chercherPatients("%H%",40);
        patientList.forEach(p -> {
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });

        System.out.println("*************By Id****************");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if(patient!=null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        //Mise a jour
        patient.setScore(870);
        patientRepository.save(patient);

        //Suppression
        //patientRepository.deleteById(1L);



    }
}
