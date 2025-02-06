package com.example.FibonacciCalculator.config;

import com.example.FibonacciCalculator.repository.FibonacciRepository;
import com.example.FibonacciCalculator.util.DataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DatabaseSeeder {

    private final DataGenerator dataGenerator;

    @Bean
    CommandLineRunner initDatabase(FibonacciRepository fibonacciRepository) {
        return args -> {
            if(fibonacciRepository.count() == 0) {
                fibonacciRepository.saveAll(dataGenerator.initFibonacciNumbers());
                log.info("Fibonacci numbers created");
            }
        };
    }
}
