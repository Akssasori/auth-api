package com.lucas.auth.mappers;

import com.lucas.auth.models.Product;
import com.lucas.auth.dtos.ProductRequestRecord;
import com.lucas.auth.dtos.ProductResponseRecord;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product toProduct(ProductRequestRecord record) {
        return new Product(record.name(), record.price(), record.amount());
    }

    public static ProductResponseRecord toResponseRecord(Product product) {
        return new ProductResponseRecord(product.getName(), product.getPrice(), product.getAmount());
    }

    public static List<ProductResponseRecord> toListResponseRecord(List<Product> products) {
        List<ProductResponseRecord> productResponseRecords = new ArrayList<>();

        for (Product product : products) {
           var response = new ProductResponseRecord(product.getName(), product.getPrice(), product.getAmount());
           productResponseRecords.add(response);
        }

        return productResponseRecords;
    }
}
