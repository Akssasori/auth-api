package com.lucas.auth.models;

import com.lucas.auth.dtos.ProductRequestRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private Integer amount;

    public Product(String name, Double price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Product recordToProduct(ProductRequestRecord productRequestRecord) {
        var product = new Product();

        product.setAmount(productRequestRecord.amount());
        product.setName(productRequestRecord.name());
        product.setPrice(productRequestRecord.price());

        return product;
    }
}
