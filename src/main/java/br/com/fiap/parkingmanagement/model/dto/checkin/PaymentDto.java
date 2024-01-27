package br.com.fiap.parkingmanagement.model.dto.checkin;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record PaymentDto(
        @NotEmpty(message = "Informe a modalidade de pagamento!")
        String type,
        @Valid
        CardDto card,


        double amount
) { }