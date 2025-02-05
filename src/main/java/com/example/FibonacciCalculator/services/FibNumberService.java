package com.example.FibonacciCalculator.services;

import com.example.FibonacciCalculator.dto.FibNumberDTO;
import com.example.FibonacciCalculator.entity.FibNumberEntities;
import com.example.FibonacciCalculator.repository.FibonacciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FibNumberService implements CRUDInterface<FibNumberDTO>{

    private final FibonacciRepository fibonacciRepository;

    @Override
    public FibNumberDTO getById(int id) {
        FibNumberEntities fibNumberEntities = fibonacciRepository.findById(id).orElseThrow(null);
        return mapToFibNumberDTO(fibNumberEntities);
    }

    @Override
    public Collection<FibNumberDTO> getAll() {
        List<FibNumberDTO> fibNumberDTOS = fibonacciRepository.findAll()
                .stream()
                .map(FibNumberService::mapToFibNumberDTO)
                .toList();
        return fibNumberDTOS;
    }

    public static FibNumberDTO mapToFibNumberDTO(FibNumberEntities fibNumberEntities) {
        FibNumberDTO fibNumberDTO = new FibNumberDTO();
        fibNumberDTO.setId(fibNumberEntities.getId());
        fibNumberDTO.setFibNumber(fibNumberEntities.getNumber());
        return fibNumberDTO;
    }

    public static FibNumberEntities mapToFibNumberEntities(FibNumberDTO fibNumberDTO) {
        FibNumberEntities fibNumberEntities = new FibNumberEntities();
        fibNumberEntities.setId(fibNumberDTO.getId());
        fibNumberEntities.setNumber(fibNumberDTO.getFibNumber());
        return fibNumberEntities;
    }
}
