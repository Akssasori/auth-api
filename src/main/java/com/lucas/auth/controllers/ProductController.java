package com.lucas.auth.controllers;

import com.lucas.auth.mappers.ProductMapper;
import com.lucas.auth.records.ProductRequestRecord;
import com.lucas.auth.records.ProductResponseRecord;
import com.lucas.auth.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseRecord>> findALl() {
        return ResponseEntity.ok().body(ProductMapper.toListResponseRecord(productService.findAll()));
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseRecord> save(@RequestBody ProductRequestRecord productRequestRecord) {
        var product = ProductMapper.toProduct(productRequestRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toResponseRecord(productService.save(product)));

    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseRecord> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ProductMapper.toResponseRecord(productService.findById(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
