package com.springbootcrud.service;

import com.springbootcrud.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    <S extends Product> S save(S entity);

    Optional<Product> findById(Integer integer);

    void deleteById(Integer integer);
}
