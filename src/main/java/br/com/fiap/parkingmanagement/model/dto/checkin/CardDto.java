package br.com.fiap.parkingmanagement.model.dto.checkin;

public record CardDto(
        String type,
        String number,
        String verificationCode
) { }