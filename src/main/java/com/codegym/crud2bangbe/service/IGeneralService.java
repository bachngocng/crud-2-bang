package com.codegym.crud2bangbe.service;

import com.codegym.crud2bangbe.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void removeById(Long id);
}