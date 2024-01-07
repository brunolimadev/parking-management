package br.com.fiap.parkingmanagement.controller.exception;

import lombok.Getter;

@Getter
public class VehicleException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String title;

    public VehicleException(String title, String message) {
        super(message);
        this.title = title;
    }
}
