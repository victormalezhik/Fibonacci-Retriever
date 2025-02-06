package com.example.FibonacciCalculator.util;
import com.example.FibonacciCalculator.entity.FibNumberEntities;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class DataGenerator {
    private static final int limit = 40;
    private static final ArrayList<Integer> fibonacci = new ArrayList<>();

    private static void addInitialNumbers() {
        fibonacci.add(0);
        fibonacci.add(1);
    }

    private static void generateFibonacciNumbers() {
        addInitialNumbers();
        for(int i = 2; i < limit; i++){
            int x = fibonacci.get(i-1) + fibonacci.get(i-2);
            fibonacci.add(x);
        }
    }

    private static FibNumberEntities mapToFibNumberEntities(int fibNumber) {
        FibNumberEntities fibNumberEntities = new FibNumberEntities();
        fibNumberEntities.setNumber(fibNumber);
        return fibNumberEntities;
    }

    public LinkedList<FibNumberEntities> initFibonacciNumbers() {
        LinkedList<FibNumberEntities> listFibNumEntities = new LinkedList<>();
        generateFibonacciNumbers();

        listFibNumEntities.addAll(
                fibonacci.stream()
                .map(DataGenerator::mapToFibNumberEntities)
                .toList());

        return listFibNumEntities;
    }


}
