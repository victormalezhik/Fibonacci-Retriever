package com.example.FibonacciCalculator.servicesTest;

import com.example.FibonacciCalculator.dto.FibNumberDTO;
import com.example.FibonacciCalculator.entity.FibNumberEntities;
import com.example.FibonacciCalculator.repository.FibonacciRepository;
import com.example.FibonacciCalculator.services.FibNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FibNumberServicesTest {

    private final FibonacciRepository fibonacciRepository = Mockito.mock(FibonacciRepository.class);

    private final FibNumberService fibNumberService = new FibNumberService(fibonacciRepository);

    @Test
    @DisplayName("Test converting entity to DTO")
    public void testMapToFibNumberDTO() {
        int numberId = 5;
        FibNumberEntities fibNumberEntities = new FibNumberEntities();
        fibNumberEntities.setId(numberId);

        FibNumberDTO fibNumberDTO = FibNumberService.mapToFibNumberDTO(fibNumberEntities);
        assertEquals(numberId, fibNumberDTO.getId());
    }


    @Test
    @DisplayName("Test getting fibonacci number by its id")
    public void testGetById(){
        int numberId = 5;
        FibNumberEntities fibNumberEntities = new FibNumberEntities();
        fibNumberEntities.setId(numberId);
        fibNumberEntities.setNumber(3);

        when(fibonacciRepository.findById(numberId)).thenReturn(Optional.of(fibNumberEntities));

        FibNumberDTO fibNumberDTO = fibNumberService.getById(numberId);
        assertEquals(numberId,fibNumberDTO.getId());
        verify(fibonacciRepository, times(1)).findById(numberId);
    }

    @Test
    @DisplayName("Test getting all fibonacci numbers from DB")
    public void testGetAllFibNumbers() {
        int size = 3;

        List<FibNumberEntities> fibNumberEntities = new ArrayList<>();

        fibNumberEntities.add(new FibNumberEntities());
        fibNumberEntities.add(new FibNumberEntities());
        fibNumberEntities.add(new FibNumberEntities());

        when(fibonacciRepository.findAll()).thenReturn(fibNumberEntities);

        assertEquals(size, fibNumberService.getAll().size());
        verify(fibonacciRepository, times(1)).findAll();
    }
}
