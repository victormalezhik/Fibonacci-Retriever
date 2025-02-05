package com.example.FibonacciCalculator.repository;

import com.example.FibonacciCalculator.entity.FibNumberEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FibonacciRepository extends JpaRepository<FibNumberEntities,Integer> {
}
