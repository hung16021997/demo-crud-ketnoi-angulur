package com.codegym.crudwebservice.service;

import com.codegym.crudwebservice.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
