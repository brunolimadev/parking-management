package br.com.fiap.parkingmanagement.model.dto.checkin;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CardDto(
        @NotNull(message = "Informe o tipo de cartão!")
        String type,
        @Pattern(regexp = "^(\\d{4}-){3}\\d{4}$", message = "Número de cartão inválido! Utilize o formato: xxxx-xxxx-xxxx-xxxx")
        String number,
        @Pattern(regexp = "^\\d{2}\\/\\d{2}$", message = "Informe o mês de validade do cartão no formato: xx/xx")
        String expiringDate,
        @Pattern(regexp = "^[0-9]{3}$", message = "CVV inválido! Utilize o formato: xxx")
        String verificationCode
) { }