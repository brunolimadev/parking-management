package br.com.fiap.parkingmanagement.model.dto.checkin;

public record PaymentDto(
        String type,
        CardDto card
) { }