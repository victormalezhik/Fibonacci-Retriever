package com.example.FibonacciCalculator.services;

import java.util.Collection;

public interface CRUDInterface<T>{
    T getById(int id);
    Collection<T> getAll();
}
