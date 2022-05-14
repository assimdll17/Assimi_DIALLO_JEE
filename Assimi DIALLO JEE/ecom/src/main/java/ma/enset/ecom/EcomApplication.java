package ma.enset.ecom;

import ma.enset.ecom.entities.Product;
import ma.enset.ecom.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            Stream.of("Computer","Printer","SmartPhone").forEach(name->{
                productRepository.save(
                        new Product(UUID.randomUUID().toString(),
                                name,Math.random()*8000,Math.random()*100)
                );
            });
        };
    }

}
