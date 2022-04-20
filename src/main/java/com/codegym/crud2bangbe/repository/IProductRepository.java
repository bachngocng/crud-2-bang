package com.codegym.crud2bangbe.repository;

import com.codegym.crud2bangbe.model.Product;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
