package com.example.FibonacciCalculator.controller;

import com.example.FibonacciCalculator.dto.FibNumberDTO;
import com.example.FibonacciCalculator.services.FibNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/fibonacci")
public class FibNumberController {

    private final FibNumberService fibNumberService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<FibNumberDTO> getFibNumberById(@PathVariable int id) {
        FibNumberDTO fibNumberDTO = fibNumberService.getById(id);
        return new ResponseEntity<>(fibNumberDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<FibNumberDTO>> getAllFibNumbers() {
        Collection<FibNumberDTO> finNumberCollection = fibNumberService.getAll();
        return new ResponseEntity<>(finNumberCollection, HttpStatus.OK);
    }
}
