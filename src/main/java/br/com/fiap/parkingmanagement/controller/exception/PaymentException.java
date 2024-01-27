package br.com.fiap.parkingmanagement.controller.exception;

import lombok.Getter;

@Getter
public class PaymentException extends RuntimeException {

   private String title;

    public PaymentException(String title, String message) {
        super(message);
        this.title = title;
    }
}
