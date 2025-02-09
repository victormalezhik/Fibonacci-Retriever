package com.example.FibonacciCalculator.utilTest;

import com.example.FibonacciCalculator.entity.FibNumberEntities;
import com.example.FibonacciCalculator.util.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DataGeneratorTest {

    private DataGenerator dataGenerator;

    @BeforeEach
    public void setUp(){
        dataGenerator = new DataGenerator();
    }
    @Test
    @DisplayName("Test the limit of generated list of fibonacci numbers")
    public void testInitFibonacciNumbersLimit(){
        int limit = 40;

        LinkedList<FibNumberEntities> list = dataGenerator.initFibonacciNumbers();

        assertEquals(limit, list.size());
    }

    @Test
    @DisplayName("Test of an initialization correct work ")
    public void testCorrectWorkOfInit(){
        FibNumberEntities fibNumberEntities = new FibNumberEntities();
        fibNumberEntities.setId(5);
        fibNumberEntities.setNumber(3);

        LinkedList<FibNumberEntities> entitiesList = dataGenerator.initFibonacciNumbers();

        assertEquals(fibNumberEntities.getNumber(), entitiesList.get(4).getNumber());
    }
}
