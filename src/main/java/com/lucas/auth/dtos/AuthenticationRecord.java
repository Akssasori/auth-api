package com.lucas.auth.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRecord(
        @NotNull
        @NotBlank
        String login,
        @NotNull
        @NotBlank
        String password
) {
}
