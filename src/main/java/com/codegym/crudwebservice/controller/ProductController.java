package com.codegym.crudwebservice.controller;

import com.codegym.crudwebservice.model.Product;
import com.codegym.crudwebservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/")
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        System.out.println("Fetching Product with id " + id);
        Product product = productService.findById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/products/")
    public ResponseEntity<Product> addProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestParam("product") Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
