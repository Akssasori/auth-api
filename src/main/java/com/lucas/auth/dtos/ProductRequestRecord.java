package com.lucas.auth.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestRecord(

        @NotNull(message = "name not be null")
        @NotBlank
        String name,

        @NotNull
        @Positive
        Double price,

        @NotNull
        Integer amount

) {
}
