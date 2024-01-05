package br.com.fiap.parkingmanagement.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record UserDto(
    String name,
    @Email(message = "Email should be valid")
    String email,
    @Min(value = 6L, message = "Password must be at least 6 characters long")
    @Max(value = 12L, message = "Password must be at max 12 characters long")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one digit, one lowercase, one uppercase, one special character")
    String password,
    LocalDateTime createdAt
) {
}
