package com.evaluationproject.SpringBootProduct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product credit = new Product(
                    1,
                    10000,
                    "Credit");
            Product otherCredit = new Product(
                    2,
                    250000,
                    "Big Credit");
            repository.saveAll(List.of(credit, otherCredit));
        };
    }
}
