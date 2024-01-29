package br.com.fiap.parkingmanagement.controller.exception;

import lombok.Getter;

@Getter
public class FormOfPaymentNotFoundException extends RuntimeException {
    public FormOfPaymentNotFoundException(String message) {
        super(message);
    }
}