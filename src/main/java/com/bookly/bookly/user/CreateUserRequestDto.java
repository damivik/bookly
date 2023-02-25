package com.bookly.bookly.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDto(@NotBlank @Email String email, @NotBlank String password) {
}
