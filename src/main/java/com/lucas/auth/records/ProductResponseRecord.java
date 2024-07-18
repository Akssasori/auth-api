package com.lucas.auth.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductResponseRecord(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        Double price,

        @NotNull
        Integer amount

) {
}
