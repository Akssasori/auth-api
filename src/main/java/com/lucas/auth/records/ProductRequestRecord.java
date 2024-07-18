package com.lucas.auth.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
