package com.lucas.auth.dtos;

import com.lucas.auth.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRecord(
        @NotNull
        @NotBlank
        String login,
        @NotNull
        @NotBlank
        String password,
        @NotNull
        @NotBlank
        UserRole role
) {
}
