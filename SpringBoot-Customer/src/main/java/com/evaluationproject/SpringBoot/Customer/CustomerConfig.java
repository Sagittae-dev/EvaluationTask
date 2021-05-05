package com.evaluationproject.SpringBoot.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer mateusz = new Customer(
                    "mateusz",
                    "baranski",
                    "028398120398");
            Customer wika = new Customer(
                    "WIka",
                    "baranska",
                    "98798797");
            repository.saveAll(List.of(mateusz, wika));
        };
    }
}
