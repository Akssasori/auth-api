package com.lucas.auth.services;

import com.lucas.auth.models.Product;
import com.lucas.auth.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) throw new RuntimeException("Produto não localizado");

        return product;
    }

    public Product save (Product product) {
        return productRepository.save(product);
    }
}
