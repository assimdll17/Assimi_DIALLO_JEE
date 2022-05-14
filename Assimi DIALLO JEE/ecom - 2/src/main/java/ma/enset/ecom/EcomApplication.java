package ma.enset.ecom;

import ma.enset.ecom.entities.Category;
import ma.enset.ecom.entities.Product;
import ma.enset.ecom.repositories.CategoryRepository;
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
    public CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            Stream.of("Computers","Printers","Smart Phones").forEach(name->{
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            });
            categoryRepository.findAll().forEach(cat->{
                for (int i = 1; i<=5; i++){
                    Product product = new Product();
                    product.setId(UUID.randomUUID().toString());
                    product.setPrice(100+Math.random()*9000);
                    product.setQuantity(1+Math.random()*50);
                    product.setName(cat.getName()+"-"+i);
                    product.setCategory(cat);
                    productRepository.save(product);
                }
            });
        };
    }

}
