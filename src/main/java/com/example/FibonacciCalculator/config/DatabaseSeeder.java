package com.example.FibonacciCalculator.config;

import com.example.FibonacciCalculator.repository.FibonacciRepository;
import com.example.FibonacciCalculator.util.DataGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder {

    private final DataGenerator dataGenerator;



    @Bean
    CommandLineRunner initDatabase(FibonacciRepository fibonacciRepository) {}
}
