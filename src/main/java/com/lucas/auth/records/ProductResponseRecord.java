package com.lucas.auth.records;

public record ProductResponseRecord(
        String name,
        Double price,
        Integer amount
) {
}
