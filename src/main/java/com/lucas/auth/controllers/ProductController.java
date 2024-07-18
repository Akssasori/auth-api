package com.lucas.auth.controllers;

import com.lucas.auth.models.Product;
import com.lucas.auth.records.ProductResponseRecord;
import com.lucas.auth.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

        List<ProductResponseRecord> productResponseRecords = new ArrayList<>();

        productService.findAll().forEach(product -> {
            var productResponseRecord = new ProductResponseRecord(product.getName(), product.getPrice(), product.getAmount());
            productResponseRecords.add(productResponseRecord);
        });


        return ResponseEntity.ok().body(productResponseRecords);
    }
}
