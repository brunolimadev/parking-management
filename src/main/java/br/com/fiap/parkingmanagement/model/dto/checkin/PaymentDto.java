package br.com.fiap.parkingmanagement.model.dto.checkin;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PaymentDto(
        @NotBlank(message = "Informe a modalidade de pagamento!")
        String type,
        @Valid
        CardDto card,
        double amount
) { }